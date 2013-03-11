package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Singleton;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class LanguageHibernateService implements LanguageService {
	@HibernateService
	CountryLanguageService countryLanguageService;

	public Language getLanguageById(Integer languageId) {
		return (Language) HibernateSession.get().createCriteria(Language.class).add(Restrictions.eq("id", languageId)).uniqueResult();
	}

	public Language getLanguageByName(String languageName) {
		return (Language) HibernateSession.get().createCriteria(Language.class).add(Restrictions.eq("language", languageName)).uniqueResult();
	}

	public List<Language> getLanguagesByCity(City city) {
		return getLanguagesByCountry(city.getCountry());
	}

	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesByCountry(Country country) {
		return HibernateSession.get().createCriteria(Language.class, "l").createAlias("countries", "cl")
				.add(Restrictions.eq("cl.countryCode", country.getCode()))

				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getSortedLanguagesByCountry(Country country) {
		return HibernateSession.get().createCriteria(Language.class, "l").createAlias("countries", "cl")
				.add(Restrictions.eq("cl.countryCode", country.getCode()))
				.setProjection(Projections.projectionList().add(Projections.groupProperty("cl.language")).add(Projections.property("cl.percentage")))
				.addOrder(Order.desc("cl.percentage")).list();
	}

	// TODO: tons of performance problems. Clean up if I have time
	public TreeMap<Language, Long> getSortedMostSpoken() {
		List<CountryLanguage> countryLanguages = countryLanguageService.getAll();

		// Initialize keys. Sort the map later
		Map<Language, Long> unsortedLanguages = new HashMap<>();

		// Calculate the approximate number of speakers per language
		for (CountryLanguage cl : countryLanguages) {
			Country c = cl.getCountry(); // TODO: n+1 leak.
			Language l = cl.getLanguage(); // TODO: n+1 leak.

			Long speakers = unsortedLanguages.get(l);

			if (speakers == null) {
				speakers = 0L;
			}

			// TODO: cast to long then box to Long - better way?
			speakers += (long) (c.getPopulation() * (cl.getPercentage() / 100));
			unsortedLanguages.put(l, speakers);
		}

		TreeMap<Language, Long> sortedLanguages = new TreeMap<>(new MostSpokenLanguageComparator(unsortedLanguages));
		sortedLanguages.putAll(unsortedLanguages);
		return sortedLanguages;
	}

	private static class MostSpokenLanguageComparator implements Comparator<Language> {
		Map<Language, Long> languageSpeakers;

		public MostSpokenLanguageComparator(Map<Language, Long> languageSpeakers) {
			this.languageSpeakers = languageSpeakers;
		}

		@Override
		public int compare(Language o1, Language o2) {
			return languageSpeakers.get(o2).compareTo(languageSpeakers.get(o1));
		}
	}
}
