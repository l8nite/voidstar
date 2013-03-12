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

import us.p.opulo.constants.Constants.Names;
import us.p.opulo.constants.Constants.Resources.WSDL;
import us.p.opulo.constants.Constants.XML.Namespaces;
import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.guice.annotations.HibernateService;

@WebService(
		 targetNamespace=Namespaces.Soap.INFECTION_SERVICE,
		 wsdlLocation = WSDL.INFECTION_SERVICE,
		 serviceName = Names.Service.INFECTION_PORT_SERVICE,
		 name = Names.Service.INFECTION_SERVICE
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class InfectionSoapService implements InfectionService {
	private static final Logger log = LoggerFactory.getLogger(InfectionSoapService.class);
	
	@Inject
	@HibernateService
	private InfectionService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public Infection getInfectionByCity(@WebParam(name="city", targetNamespace=Namespaces.DAO) City city) {
		log.info("getInfectionByCity(): city = " + city);
		return hibernateService.getInfectionByCity(city);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionsByCountry(@WebParam(name="country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getInfectionByCountry(): country = " + country);
		return hibernateService.getInfectionsByCountry(country);
	}
}