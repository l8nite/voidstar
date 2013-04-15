/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.query;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.service.InfectionService;

import com.google.inject.Singleton;

/**
 * A library of methods used to query the Infection table.
 * @author Jason Campos
 */
@Singleton
public class InfectionQueryService implements InfectionService {
	
	@Inject
	@HibernateService
	private InfectionService service;

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
