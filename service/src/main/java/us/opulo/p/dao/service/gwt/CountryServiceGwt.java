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

import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.util.StringUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class CountryServiceGwt extends RemoteServiceServlet implements CountryService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CountryServiceGwt.class);
	
	@Inject
	@HibernateService
	CountryService hibernateService;

	@Override
	public List<Country> getAllCountries() {
		log.info("getAllCountries()");
		return hibernateService.getAllCountries();
	}

	@Override
	public Country getCountryWithCode(String countryCode) {
		log.info("getCountryWithCode(): countryCode = " + countryCode);
		return hibernateService.getCountryWithCode(countryCode);
	}

	@Override
	public List<Country> getCountriesWithCodes(Collection<String> countryCodes) {
		log.info("getCountriesWithCodes(): countryCodes = " + StringUtil.joinCollection(countryCodes, ','));
		return hibernateService.getCountriesWithCodes(countryCodes);
	}

	@Override
	public List<Country> getCountriesOnContinent(String continent) {
		log.info("getCountriesOnContinent(): continent = " + continent);
		return hibernateService.getCountriesOnContinent(continent);
	}

	@Override
	public List<Country> getCountriesOnContinents(Collection<String> continents) {
		log.info("getCountriesOnContinent(): continent = " + StringUtil.joinCollection(continents,  ','));
		return hibernateService.getCountriesOnContinents(continents);
	}
}