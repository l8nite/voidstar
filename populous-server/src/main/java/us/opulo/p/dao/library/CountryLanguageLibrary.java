/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.library;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.hibernate.SessionProvider;

import com.google.inject.Singleton;

/**
 * A library of methods used to query the CountryLanguage table.
 * @author Jason Campos
 */
@Singleton
public class CountryLanguageLibrary implements CountryLanguageService {
	
	@Inject
	@HibernateService
	private CountryLanguageService service;
	
	@Inject
	private SessionProvider session;

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

	@SuppressWarnings("unchecked")
	public List<Language> getMostPopularLanguages(Country country, int maxResults) {
		return (List<Language>) session.get().createCriteria(CountryLanguage.class, "countryLanguage")
		.add(Restrictions.eq("countryCode", country.getCode()))
		.setProjection(Projections.property("language"))
		.addOrder(Order.desc("percentage"))
		.setMaxResults(maxResults)
		.list();
	}
}
