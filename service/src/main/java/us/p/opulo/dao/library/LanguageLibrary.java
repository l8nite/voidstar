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
import javax.inject.Singleton;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class LanguageLibrary implements LanguageService {

	@Inject 
	@HibernateService
	private LanguageService service;
	
	@Inject 
	private HibernateSession session;

	@Override
	public Language getLanguageWithId(Integer id) {
		return service.getLanguageWithId(id);
	}
	
	@Override
	public List<Language> getLanguagesWithIds(Collection<Integer> ids) {
		return service.getLanguagesWithIds(ids);
	}

	@Override
	public Language getLanguageWithName(String name) {
		return service.getLanguageWithName(name);
	}
	@Override
	public List<Language> getLanguagesWithNames(Collection<String> names) {
		return service.getLanguagesWithNames(names);
	}

	@Override
	public List<Language> getLanguagesInCountry(Country country) {
		return service.getLanguagesInCountry(country);
	}

	@Override
	public List<Language> getLanguagesInCountries(Collection<Country> countries) {
		return service.getLanguagesInCountries(countries);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
