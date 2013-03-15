/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.library;

import java.util.Collection;
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
	public List<CountryLanguage> getAllCountryLanguages() {
		return service.getAllCountryLanguages();
	}
	
	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguage(Language language) {
		return service.getCountryLanguagesForLanguage(language);
	}
	
	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguages(Collection<Language> languages) {
		return service.getCountryLanguagesForLanguages(languages);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountry(Country country) {
		return service.getCountryLanguagesForCountry(country);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountries(Collection<Country> countries) {
		return service.getCountryLanguagesForCountries(countries);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
