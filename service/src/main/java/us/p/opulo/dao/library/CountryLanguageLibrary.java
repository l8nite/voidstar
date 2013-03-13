package us.p.opulo.dao.library;

import java.util.List;

import javax.inject.Inject;

import com.google.inject.Singleton;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CountryLanguageLibrary implements CountryLanguageService {
	
	@Inject
	@HibernateService
	private CountryLanguageService service;
	
	@Inject
	private HibernateSession session;

	@Override
	public List<CountryLanguage> getCountryLanguagesByLanguage(Language language) {
		return service.getCountryLanguagesByLanguage(language);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesByCountry(Country country) {
		return service.getCountryLanguagesByCountry(country);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
