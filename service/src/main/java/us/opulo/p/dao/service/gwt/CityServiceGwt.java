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

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.util.StringUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class CityServiceGwt extends RemoteServiceServlet implements CityService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CityServiceGwt.class);
	
	@Inject
	@HibernateService
	CityService hibernateService;
	
	@Override
	public List<City> getAllCities() {
		log.info("getAllCities()");
		return hibernateService.getAllCities();
	}
	
	@Override
	public City getCityWithId(Integer cityId) {
		log.info("getCityWithId(): cityId = " + cityId);
		return hibernateService.getCityWithId(cityId);
	}
	
	@Override
	public List<City> getCitiesWithIds(Collection<Integer> cityIds) {
		log.info("getCitiesWithIds: cityIds = " + StringUtil.joinCollection(cityIds, ','));
		return hibernateService.getCitiesWithIds(cityIds);
	}
	
	@Override
	public List<City> getCitiesWithName(String cityName) {
		log.info("getCitiesWithName(): cityName = " + cityName);
		return hibernateService.getCitiesWithName(cityName);
	}
	
	@Override
	public List<City> getCitiesWithNames(Collection<String> cityNames) {
		log.info("getCitiesWithNames(): cityNames = " + StringUtil.joinCollection(cityNames, ','));
		return hibernateService.getCitiesWithNames(cityNames);
	}
	
	@Override
	public List<City> getCitiesInCountry(Country country) {
		log.info("getCitiesInCountry(): country = " + country);
		return hibernateService.getCitiesInCountry(country);
	}
	
	@Override
	public List<City> getCitiesInCountries(Collection<Country> countries) {
		log.info("getCitiesInCountries(): countries = " + countries);
		return hibernateService.getCitiesInCountries(countries);
	}
}