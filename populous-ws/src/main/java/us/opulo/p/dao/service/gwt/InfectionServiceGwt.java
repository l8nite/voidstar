/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.util.StringUtil;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class InfectionServiceGwt extends RemoteServiceServlet implements InfectionService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InfectionServiceGwt.class);
	
	@Inject
	@HibernateService
	InfectionService hibernateService;

	@Override
	public List<Infection> getAllInfections() {
		log.info("getAllInfections()");
		return hibernateService.getAllInfections();
	}

	@Override
	public Infection getInfectionForCity(City city) {
		log.info("getInfectionForCity(): city = " + city);
		return hibernateService.getInfectionForCity(city);
	}

	@Override
	public List<Infection> getInfectionForCities(List<City> cities) {
		log.info("getInfectionForCities(): cities = " + StringUtil.joinCollection(cities, ','));
		return hibernateService.getInfectionForCities(cities);
	}

	@Override
	public List<Infection> getInfectionsForCountry(Country country) {
		log.info("getInfectionsForCountry(): country = " + country);
		return hibernateService.getInfectionsForCountry(country);
	}

	@Override
	public List<Infection> getInfectionsForCountries(Collection<Country> countries) {
		log.info("getInfectionsForCountries(): countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getInfectionsForCountries(countries);
	}
}