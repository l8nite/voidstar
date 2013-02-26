package edu.sjsu.voidstar.project1.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import edu.sjsu.voidstar.project2.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.project2.jaxb.tables.Languages;

@Entity
@XmlRootElement(name="Language")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Language", propOrder = {
    "id",
    "language"
})
@XmlGroup(Languages.class)
public class Language extends HEntity {
	
	@Id
	@XmlElement(name = "ID")
	private Integer id;        
    
    @XmlElement(name = "Language")
	private String language;
	
	@OneToMany(mappedBy="languageId")
	@XmlTransient
	private Set<CountryLanguage> countries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<CountryLanguage> getCountries() {
		return countries;
	}

	public void setCountries(Set<CountryLanguage> countries) {
		this.countries = countries;
	}

	// TODO: tons of performance problems. Clean up if I have time
	public static TreeMap<Language,Long> getSortedMostSpoken() {
		List<CountryLanguage> countryLanguages = CountryLanguage.get(); 
		
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
	
	@Override
	public String toString() {			// - to sort descending
		return this.language;
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
