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

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;

/**
 * A service interface for the City table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface CityService {
	/**
	 * @return All Cities.
	 */
	List<City> getAllCities();
	
	/**
	 * Retrieves the City associated with the argument cityId.
	 * @param cityId The ID of the City to retrieve.
	 * @return The City associated with the argument cityId.
	 */
	City getCityWithId(Integer cityId);
	
	/**
	 * Retrieves all Cities associated with the argument cityIds.
	 * @param cityIds The IDs of the Cities to retrieve.
	 * @return A list of Cities associated with the argument cityIds.
	 */
	List<City> getCitiesWithIds(Collection<Integer> cityIds);
	
	/**
	 * Retrieves all Cities which match the argument cityName.
	 * @param cityName The name of the Cities to retrieve.
	 * @return A list of Cities which match the argument cityName.
	 */
	List<City> getCitiesWithName(String cityName);
	
	/**
	 * Retrieves all Cities which match one of the argument cityNames.
	 * @param cityNames The names of the Cities to retrieve.
	 * @return A list of Cities which match one of the argument cityNames.
	 */
	List<City> getCitiesWithNames(Collection<String> cityNames);
	
	/**
	 * Retrieves all Cities associated with the argument country.
	 * @param country The country for which to retrieve the associated Cities.
	 * @return A list of Cities associated with the argument country.
	 */
	List<City> getCitiesInCountry(Country country);
	
	/**
	 * Retrieves all Cities associated with one of the argument countries.
	 * @param countries A collection of Country objects for which to retrieve the associated Cities.
	 * @return A list of Cities associates with the argument country.
	 */
	List<City> getCitiesInCountries(Collection<Country> countries);
}