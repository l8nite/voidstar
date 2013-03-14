/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
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

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;

public interface CityService {
	City getCityWithId(Integer cityId);
	List<City> getCitiesWithIds(Collection<Integer> cityIds);
	
	List<City> getCitiesWithName(String cityName);
	List<City> getCitiesWithNames(Collection<String> cityNames);
	
	List<City> getCitiesInCountry(Country country);
	List<City> getCitiesInCountries(Collection<Country> countries);
}