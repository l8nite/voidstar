/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.service;

import java.util.Collection;
import java.util.List;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;

public interface LanguageService {
	Language getLanguageWithId(Integer id);
	List<Language> getLanguagesWithIds(Collection<Integer> ids);
	
	Language getLanguageWithName(String name);
	List<Language> getLanguagesWithNames(Collection<String> names);
	
	List<Language> getLanguagesInCountry(Country country);
	List<Language> getLanguagesInCountries(Collection<Country> countries);
}