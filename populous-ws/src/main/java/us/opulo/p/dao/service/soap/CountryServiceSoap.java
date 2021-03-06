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
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.constants.Constants.WebService.Soap.ServiceName;
import us.opulo.p.constants.Constants.XML.Namespaces;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.guice.GuiceManaged;
import us.opulo.p.guice.WebServiceModule;
import us.opulo.p.util.StringUtil;

/**
 * A SOAP web service which implements the CountryService interface. 
 * No additional methods are added to this class beyond what is specified in the interface. 
 * 
 * @author Jason Campos, Shaun Guth
 */
@WebService(
		targetNamespace = Namespaces.Soap.COUNTRY_SERVICE,
		serviceName = ServiceName.COUNTRY_PORT_SERVICE,
		name = ServiceName.COUNTRY_SERVICE
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@HandlerChain(file="handlerchain.xml")
@GuiceManaged( modules = { WebServiceModule.class } )
@Singleton
public class CountryServiceSoap implements CountryService {
	private static final Logger log = LoggerFactory.getLogger(CountryServiceSoap.class);
	
	@Inject
	@HibernateService
	private CountryService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public List<Country> getAllCountries() {
		log.info("getAllCountries()");
		return hibernateService.getAllCountries();
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public Country getCountryWithCode(@WebParam(name="code") String countryCode) {
		log.info("getCountryWithCode(): countryCode = " + countryCode);
		return hibernateService.getCountryWithCode(countryCode);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public List<Country> getCountriesWithCodes(@WebParam(name="countryCodes") Collection<String> countryCodes) {
		log.info("getCountriesWithCodes: countryCodes = " + StringUtil.joinCollection(countryCodes, ','));
		return hibernateService.getCountriesWithCodes(countryCodes);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public List<Country> getCountriesOnContinent(@WebParam(name="continent") String continent) {
		log.info("getCountriesByContinent(): continent = " + continent);
		return hibernateService.getCountriesOnContinent(continent);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public List<Country> getCountriesOnContinents(@WebParam(name="continents") Collection<String> continents) {
		log.info("getCountriesOnContinents(): continents = " + StringUtil.joinCollection(continents, ','));
		return hibernateService.getCountriesOnContinents(continents);
	}
}
