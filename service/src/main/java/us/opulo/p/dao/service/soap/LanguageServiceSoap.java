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
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.util.StringUtil;

@WebService(
		 targetNamespace= Namespaces.Soap.LANGUAGE_SERVICE,
		 serviceName = ServiceName.LANGUAGE_PORT_SERVICE,
		 name = ServiceName.LANGUAGE_SERVICE
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class LanguageServiceSoap implements LanguageService {
	private static final Logger log = LoggerFactory.getLogger(LanguageServiceSoap.class);
	
	@Inject
	@HibernateService
	private LanguageService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getAllLanguages() {
		log.info("getAllLanguages()");
		return hibernateService.getAllLanguages();
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public Language getLanguageWithId(@WebParam(name="id") Integer id) {
		log.info("getLanguageWithId(): id = " + id);
		return hibernateService.getLanguageWithId(id);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesWithIds(@WebParam(name="ids") Collection<Integer> ids) {
		log.info("getLanguagesWithIds(): ids = " + StringUtil.joinCollection(ids, ','));
		return hibernateService.getLanguagesWithIds(ids);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public Language getLanguageWithName(@WebParam(name="name") String name) {
		log.info("getLanguageWithName(): name = " + name);
		return hibernateService.getLanguageWithName(name);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesWithNames(@WebParam(name="names") Collection<String> names) {
		log.info("getLanguagesWithNames(): names = " + StringUtil.joinCollection(names, ','));
		return hibernateService.getLanguagesWithNames(names);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesInCountry(@WebParam(targetNamespace=Namespaces.DAO, name="Country") Country country) {
		log.info("getLanguagesInCountry(): country = " + country);
		return hibernateService.getLanguagesInCountry(country);
	}


	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesInCountries(@WebParam(targetNamespace=Namespaces.DAO, name="Country") Collection<Country> countries) {
		log.info("getLanguagesInCountries(): countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getLanguagesInCountries(countries);
	}
}
