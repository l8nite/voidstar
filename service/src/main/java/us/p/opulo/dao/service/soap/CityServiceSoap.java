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
package us.p.opulo.dao.service.soap;

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

import us.p.opulo.constants.Constants.Names.Service;
import us.p.opulo.constants.Constants.Resources.WSDL;
import us.p.opulo.constants.Constants.XML.Namespaces;
import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Namespaces.Soap.CITY_SERVICE,
		wsdlLocation = WSDL.CITY_SERVICE,
		serviceName = Service.CITY_PORT_SERVICE,
		name = Service.CITY_SERVICE
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class CityServiceSoap implements CityService {
	private static final Logger log = LoggerFactory.getLogger(CityServiceSoap.class);

	@Inject
	@HibernateService
	private CityService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public City getCityById(@WebParam(name="id") Integer id) {
		log.info("getCityById(): cityId = " + id);
		City city = hibernateService.getCityById(id);
		log.info("getCityById(): result = " + city);
		return city;
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesByName(@WebParam(name="name") String cityName) {
		log.info("getCityByName(): cityName = " + cityName);
		return hibernateService.getCitiesByName(cityName);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesByCountry(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getCityByCountry(): country = " + country);
		return hibernateService.getCitiesByCountry(country);
	}
}