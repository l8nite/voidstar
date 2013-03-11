package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class CountryLanguageHibernateService implements CountryLanguageService {
	
	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesByLanguage(Language language){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesByCountry(Country country) {
		return HibernateSession.get()
				.createCriteria(CountryLanguage.class)
				.add(Restrictions.eq("countryCode", country.getCode()))
				.list();
	}
}
