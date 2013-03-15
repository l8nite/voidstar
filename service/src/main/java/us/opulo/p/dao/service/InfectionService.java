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

public interface InfectionService {
	List<Infection> getAllInfections();
	
	Infection getInfectionForCity(City city);
	List<Infection> getInfectionForCities(List<City> cities);
	
	List<Infection> getInfectionsForCountry(Country country);
	List<Infection> getInfectionsForCountries(Collection<Country> countries);
}
