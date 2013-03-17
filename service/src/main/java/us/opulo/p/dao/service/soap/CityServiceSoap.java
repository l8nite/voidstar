/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.soap;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.constants.Constants.WebService.Soap.ServiceName;
import us.opulo.p.constants.Constants.XML.Namespaces;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.guice.CoreModule;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.guice.webservice.GuiceManaged;
import us.opulo.p.util.StringUtil;

@WebService(
		targetNamespace = Namespaces.Soap.CITY_SERVICE,
		serviceName = ServiceName.CITY_PORT_SERVICE,
		name = ServiceName.CITY_SERVICE
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@GuiceManaged( modules = { CoreModule.class } )
@Singleton
public class CityServiceSoap implements CityService {
	private static final Logger log = LoggerFactory.getLogger(CityServiceSoap.class);

	@Inject
	@HibernateService
	private CityService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getAllCities() {
		log.info("getAllCities()");
		return hibernateService.getAllCities();
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public City getCityWithId(@WebParam(name="id") Integer id) {
		log.info("getCityById(): cityId = " + id);
		return hibernateService.getCityWithId(id);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesWithIds(@WebParam(name="ids") Collection<Integer> cityIds) {
		log.info("getCitiesById(): ids = " + StringUtil.joinCollection(cityIds, ','));
		return hibernateService.getCitiesWithIds(cityIds);
	}

	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesWithName(@WebParam(name="name") String cityName) {
		log.info("getCityByName(): cityName = " + cityName);
		return hibernateService.getCitiesWithName(cityName);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesWithNames(@WebParam(name="names") Collection<String> cityNames) {
		log.info("getCitiesByName(): cityNames = " + StringUtil.joinCollection(cityNames, ','));
		return hibernateService.getCitiesWithNames(cityNames);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesInCountry(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getCityByCountry(): country = " + country);
		return hibernateService.getCitiesInCountry(country);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesInCountries(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Collection<Country> countries) {
		log.info("getCitiesByCountry: countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getCitiesInCountries(countries);
	}
}