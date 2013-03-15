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

public interface CityService {
	List<City> getAllCities();
	
	City getCityWithId(Integer cityId);
	List<City> getCitiesWithIds(Collection<Integer> cityIds);
	
	List<City> getCitiesWithName(String cityName);
	List<City> getCitiesWithNames(Collection<String> cityNames);
	
	List<City> getCitiesInCountry(Country country);
	List<City> getCitiesInCountries(Collection<Country> countries);
}