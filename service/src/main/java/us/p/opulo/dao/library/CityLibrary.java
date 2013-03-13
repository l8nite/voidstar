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
package us.p.opulo.dao.library;

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
	public City getCityById(Integer cityId) {
		return service.getCityById(cityId);
	}

	@Override
	public List<City> getCitiesByName(String cityName) {
		return service.getCitiesByName(cityName);
	}

	@Override
	public List<City> getCitiesByCountry(Country country) {
		return service.getCitiesByCountry(country);
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
