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

/**
 * A service interface for the CountryLanguage table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface CountryLanguageService {
	/**
	 * @return All CountryLanguages.
	 */
	List<CountryLanguage> getAllCountryLanguages();
	
	/**
	 * Retrieves all CountryLanguages associated with the argument language.
	 * @param language The language for which to retrieve all associated CountryLanguages.
	 * @return All CountryLanguages associated with the argument language.
	 */
	List<CountryLanguage> getCountryLanguagesForLanguage(Language language);
	
	/**
	 * Retrieves all CountryLanguages associated with each of the argument languages.
	 * @param languages The languages for which to retrieve all associated CountryLanguages.
	 * @return All CountryLanguages associated with each of the argument languages. 
	 */
	List<CountryLanguage> getCountryLanguagesForLanguages(Collection<Language> languages);
	
	/**
	 * Retrieves all CountryLanguages associated with the argument country.
	 * @param country The country for which to retrieve all associated CountryLanguages.
	 * @return All CountryLanguages associated with the argument country.
	 */
	List<CountryLanguage> getCountryLanguagesForCountry(Country country);
	
	/**
	 * Retrieves all CountryLanguages associated with each of the argument countries.
	 * @param countries The countries for which to retrieve all associated CountryLanguages
	 * @return All CountryLanguages associated with each of the argument countries.
	 */
	List<CountryLanguage> getCountryLanguagesForCountries(Collection<Country> countries);
}
