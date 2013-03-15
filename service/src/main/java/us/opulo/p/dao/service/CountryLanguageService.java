/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service;

import java.util.Collection;
import java.util.List;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;

public interface CountryLanguageService {
	List<CountryLanguage> getAllCountryLanguages();
	
	List<CountryLanguage> getCountryLanguagesForLanguage(Language language);
	List<CountryLanguage> getCountryLanguagesForLanguages(Collection<Language> languages);
	
	List<CountryLanguage> getCountryLanguagesForCountry(Country country);
	List<CountryLanguage> getCountryLanguagesForCountries(Collection<Country> countries);
}
