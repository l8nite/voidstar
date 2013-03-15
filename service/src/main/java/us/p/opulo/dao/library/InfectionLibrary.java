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

import javax.inject.Inject;

import com.google.inject.Singleton;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class InfectionLibrary implements InfectionService {
	
	@Inject
	@HibernateService
	private InfectionService service;
	
	@Inject
	private HibernateSession session;

	@Override
	public List<Infection> getAllInfections() {
		return service.getAllInfections();
	}
	
	@Override
	public Infection getInfectionForCity(City city) {
		return service.getInfectionForCity(city);
	}
	
	@Override
	public List<Infection> getInfectionForCities(List<City> cities) {
		return service.getInfectionForCities(cities);
	}

	@Override
	public List<Infection> getInfectionsForCountry(Country country) {
		return service.getInfectionsForCountry(country);
	}

	@Override
	public List<Infection> getInfectionsForCountries(Collection<Country> countries) {
		return service.getInfectionsForCountries(countries);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
