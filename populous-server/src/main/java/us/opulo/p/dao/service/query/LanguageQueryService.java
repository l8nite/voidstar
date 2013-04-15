/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.query;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.LanguageService;

/**
 * A library of methods used to query the Language table.
 * @author Jason Campos
 */
@Singleton
public class LanguageQueryService implements LanguageService {

	@Inject 
	@HibernateService
	private LanguageService service;

	@Override
	public List<Language> getAllLanguages() {
		return service.getAllLanguages();
	}
	
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
