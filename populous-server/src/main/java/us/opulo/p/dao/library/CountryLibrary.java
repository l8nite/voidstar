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

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CountryService;

import com.google.inject.Singleton;

/**
 * A library of methods used to query the Country table.
 * @author Jason Campos
 */
@Singleton
public class CountryLibrary implements CountryService {
	
	@Inject
	@HibernateService
	private CountryService service;

	@Override
	public List<Country> getAllCountries() {
		return service.getAllCountries();
	}
	
	@Override
	public Country getCountryWithCode(String countryCode) {
		return service.getCountryWithCode(countryCode);
	}
	
	@Override
	public List<Country> getCountriesWithCodes(Collection<String> countryCodes) {
		return service.getCountriesWithCodes(countryCodes);
	}

	@Override
	public List<Country> getCountriesOnContinent(String continent) {
		return service.getCountriesOnContinent(continent);
	}

	@Override
	public List<Country> getCountriesOnContinents(Collection<String> continents) {
		return service.getCountriesOnContinents(continents);
	}

	/* ADDITIONAL LIBRARY METHODS */

}
