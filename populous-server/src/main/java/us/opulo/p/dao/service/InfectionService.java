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
import us.opulo.p.dao.Infection;

/**
 * A service interface for the Infection table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface InfectionService {
	/**
	 * @return All Infections
	 */
	List<Infection> getAllInfections();
	
	/**
	 * Retrieves the Infection for the argument city.
	 * @param city The City for which to retrieve the associated Infection.
	 * @return The infection for the argument city.
	 */
	Infection getInfectionForCity(City city);
	
	/**
	 * Retrieves the Infections for the argument cities.
	 * @param cities The cities for which to retrieve the associated Infections.
	 * @return The Infections for the argument cities.
	 */
	List<Infection> getInfectionForCities(List<City> cities);
	
	/**
	 * Retrieves the Infections for the argument country.
	 * @param country The country for which to retrieve the associated Infections.
	 * @return The Infections for the argument country.
	 */
	List<Infection> getInfectionsForCountry(Country country);
	
	/**
	 * Retrieves the Infections for the argument countries.
	 * @param countries The countries for which to retrieve the associated Infections.
	 * @return The Infections for the argument countries.
	 */
	List<Infection> getInfectionsForCountries(Collection<Country> countries);
}
