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

public interface CountryService {
	Country getCountryWithCode(String countryCode);
	List<Country> getCountriesWithCodes(Collection<String> countryCodes);
	
	List<Country> getCountriesOnContinent(String continent);
	List<Country> getCountriesOnContinents(Collection<String> continents);
}
