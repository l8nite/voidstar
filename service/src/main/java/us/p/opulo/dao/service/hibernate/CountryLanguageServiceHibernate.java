/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.service.hibernate;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CountryLanguageServiceHibernate implements CountryLanguageService {
	
	@Inject
	private HibernateSession session;
	
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
