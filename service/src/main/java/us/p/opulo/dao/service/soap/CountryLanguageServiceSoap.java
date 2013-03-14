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

import us.p.opulo.constants.Constants.WebService.Soap.*;
import us.p.opulo.constants.Constants.XML.Namespaces;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Namespaces.Soap.COUNTRY_LANGUAGE_SERVICE,
		serviceName = ServiceName.COUNTRY_LANGUAGE_PORT_SERVICE,
		name = ServiceName.COUNTRY_LANGUAGE_SERVICE
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class CountryLanguageServiceSoap implements CountryLanguageService {
	private static final Logger log = LoggerFactory.getLogger(CountryLanguageServiceSoap.class);
	
	@Inject
	@HibernateService
	private CountryLanguageService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesForLanguage(@WebParam(name="Language", targetNamespace=Namespaces.DAO) Language language) {
		log.info("getCountryLanguagesForLanguage(): language = " + language);
		return hibernateService.getCountryLanguagesForLanguage(language);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesForLanguages(@WebParam(name="Language", targetNamespace=Namespaces.DAO) Collection<Language> languages) {
		log.info("getCountryLanguagesForLanguages(): size = " + languages.size());
		return hibernateService.getCountryLanguagesForLanguages(languages);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesForCountry(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getCountryLanguagesForCountry: country = " + country);
		return hibernateService.getCountryLanguagesForCountry(country);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesForCountries(@WebParam(name="Country", targetNamespace=Namespaces.DAO) Collection<Country> countries) {
		log.info("getCountryLanguagesForCountries(): size = " + countries.size());
		return hibernateService.getCountryLanguagesForCountries(countries);
	}
}
