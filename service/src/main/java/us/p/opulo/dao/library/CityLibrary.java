/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.library;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

import com.google.inject.Singleton;

@Singleton
public class CityLibrary implements CityService {
	
	@Inject
	@HibernateService
	private CityService service;
	
	@Inject
	private HibernateSession session;
	
	@Override
	public City getCityWithId(Integer cityId) {
		return service.getCityWithId(cityId);
	}

	@Override
	public List<City> getCitiesWithIds(Collection<Integer> cityIds) {
		return service.getCitiesWithIds(cityIds);
	}

	@Override
	public List<City> getCitiesWithName(String cityName) {
		return service.getCitiesWithName(cityName);
	}

	@Override
	public List<City> getCitiesWithNames(Collection<String> cityNames) {
		return service.getCitiesWithNames(cityNames);
	}

	@Override
	public List<City> getCitiesInCountry(Country country) {
		return service.getCitiesInCountry(country);
	}

	@Override
	public List<City> getCitiesInCountries(Collection<Country> countries) {
		return service.getCitiesInCountries(countries);
	}
	
	/* ADDITIONAL NON-INTERFACE METHODS */
	
	public City getRandomCity() {
		List<City> allCities = getAll();
		return allCities.get(new Random().nextInt(allCities.size()));
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		return session.get()
				.createCriteria(City.class)
				.list();
	}
}
