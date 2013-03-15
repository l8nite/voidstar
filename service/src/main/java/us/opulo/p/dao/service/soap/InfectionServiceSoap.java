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

import us.opulo.p.constants.Constants.WebService.Soap.*;
import us.opulo.p.constants.Constants.XML.Namespaces;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.util.StringUtil;

@WebService(
		 targetNamespace=Namespaces.Soap.INFECTION_SERVICE,
		 serviceName = ServiceName.INFECTION_PORT_SERVICE,
		 name = ServiceName.INFECTION_SERVICE
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class InfectionServiceSoap implements InfectionService {
	private static final Logger log = LoggerFactory.getLogger(InfectionServiceSoap.class);
	
	@Inject
	@HibernateService
	private InfectionService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getAllInfections() {
		log.info("getAllInfections()");
		return hibernateService.getAllInfections();
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public Infection getInfectionForCity(@WebParam(name="City", targetNamespace=Namespaces.DAO) City city) {
		log.info("getInfectionForCity(): city = " + city);
		return hibernateService.getInfectionForCity(city);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionForCities(@WebParam(name="City", targetNamespace=Namespaces.DAO) List<City> cities) {
		log.info("getInfectionForCities(): cities = " + StringUtil.joinCollection(cities, ','));
		return hibernateService.getInfectionForCities(cities);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionsForCountry(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getInfectionForCountry(): country = " + country);
		return hibernateService.getInfectionsForCountry(country);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionsForCountries(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Collection<Country> countries) {
		log.info("getInfectionsForCountries(): countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getInfectionsForCountries(countries);
	}
}