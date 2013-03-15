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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class LanguageServiceHibernate implements LanguageService {
	@Inject
	@HibernateService
	private CountryLanguageService countryLanguageService;

	@Inject 
	HibernateSession session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getAllLanguages() {
		return session.get().createCriteria(Language.class).list();
	}
	
	@Override
	public Language getLanguageWithId(Integer languageId) {
		return (Language) session.get()
			.createCriteria(Language.class)
			.add(Restrictions.eq("id", languageId))
			.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesWithIds(Collection<Integer> ids) {
		return session.get().createCriteria(Language.class)
			.add(Restrictions.in("id", ids))
			.list();
	}

	@Override
	public Language getLanguageWithName(String languageName) {
		return (Language) session.get()
			.createCriteria(Language.class)
			.add(Restrictions.eq("language", languageName))
			.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesWithNames(Collection<String> names) {
		return session.get().createCriteria(Language.class)
			.add(Restrictions.in("language", names))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesInCountry(Country country) {
		return session.get().createCriteria(Language.class, "l")
			.createAlias("countries", "cl")
			.add(Restrictions.eq("cl.countryCode", country.getCode()))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesInCountries(Collection<Country> countries) {
		Set<String> countryCodes = new HashSet<>();
		for(Country country: countries) {
			countryCodes.add(country.getCode());
		}
		
		return session.get().createCriteria(Language.class)
			.createAlias("countries", "cl")
			.add(Restrictions.in("cl.countryCode", countryCodes))
			.list();
	}
}
