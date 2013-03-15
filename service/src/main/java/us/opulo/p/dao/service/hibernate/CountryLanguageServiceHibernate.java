/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.hibernate;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.hibernate.HibernateSession;

@Singleton
public class CountryLanguageServiceHibernate implements CountryLanguageService {
	
	@Inject
	private HibernateSession session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getAllCountryLanguages() {
		return session.get().createCriteria(CountryLanguage.class).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesForLanguage(Language language){
		return session.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getCountryLanguagesForLanguages(Collection<Language> languages) {
		return session.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.in("language", languages))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesForCountry(Country country) {
		return session.get()
				.createCriteria(CountryLanguage.class)
				.add(Restrictions.eq("countryCode", country.getCode()))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getCountryLanguagesForCountries(Collection<Country> countries) {
		return session.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.in("country", countries))
			.list();
	}
}
