package edu.sjsu.voidstar.dao.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;

public class LanguageService {
	
	// TODO: tons of performance problems. Clean up if I have time
	public static TreeMap<Language,Long> getSortedMostSpoken() {
		List<CountryLanguage> countryLanguages = CountryLanguageService.getAll(); 
		
		// Initialize keys. Sort the map later
		Map<Language,Long> unsortedLanguages = new HashMap<>();
			
		// Calculate the approximate number of speakers per language
		for(CountryLanguage cl : countryLanguages) {
			Country c = cl.getCountry(); // TODO: n+1 leak. 
			Language l = cl.getLanguage(); // TODO: n+1 leak. 
			
			Long speakers = unsortedLanguages.get(l);
			
			if(speakers == null) {
				speakers = 0L;
			}
			
			// TODO: cast to long then box to Long - better way?
			speakers += (long) (c.getPopulation() * ( cl.getPercentage() / 100 ));
			unsortedLanguages.put(l, speakers);
		}
		
		TreeMap<Language,Long> sortedLanguages = new TreeMap<>(new MostSpokenLanguageComparator(unsortedLanguages));
		sortedLanguages.putAll(unsortedLanguages);
		return sortedLanguages;
	}
	
	private static class MostSpokenLanguageComparator implements Comparator<Language> {
		Map<Language,Long> languageSpeakers;
	
		public MostSpokenLanguageComparator(Map<Language,Long> languageSpeakers) {
			this.languageSpeakers = languageSpeakers;
		}
		
		@Override
		public int compare(Language o1, Language o2) {
			return languageSpeakers.get(o2).compareTo(languageSpeakers.get(o1));
		}
	}
}
