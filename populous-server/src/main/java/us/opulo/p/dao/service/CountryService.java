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

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * A service interface for the Country table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface CountryService extends RemoteService {
	/**
	 * @return All Countries
	 */
	List<Country> getAllCountries();
	
	/**
	 * Retrieves the Country associated with the argument countryCode.
	 * @param countryCode The countryCode associated with the Country to fetch.
	 * @return The Country associated with the argument countryCode.
	 */
	Country getCountryWithCode(String countryCode);
	
	/**
	 * Retrieves the Countries associated with each of the argument countryCodes.
	 * @param countryCodes The countryCodes asociated with the Countries to fetch.
	 * @return The Countries associated with each oft he argument countryCodes.
	 */
	List<Country> getCountriesWithCodes(Collection<String> countryCodes);
	
	/**
	 * Retrieves the Countries on the argument continent.
	 * @param continent The continent for which to retrieve all Countries.
	 * @return The Countries on the argument continent.
	 */
	List<Country> getCountriesOnContinent(String continent);
	
	/**
	 * Retrieves the Countries on each of the argument continents.
	 * @param continents The continents for which to retrieve all Countries.
	 * @return The Countries on the argument continents.
	 */
	List<Country> getCountriesOnContinents(Collection<String> continents);
}
