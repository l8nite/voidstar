/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.guice;

import us.p.opulo.dao.HEntity;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.dao.service.CountryService;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.dao.service.hibernate.CityServiceHibernate;
import us.p.opulo.dao.service.hibernate.CountryLanguageServiceHibernate;
import us.p.opulo.dao.service.hibernate.CountryServiceHibernate;
import us.p.opulo.dao.service.hibernate.InfectionServiceHibernate;
import us.p.opulo.dao.service.hibernate.LanguageServiceHibernate;
import us.p.opulo.dao.service.soap.CityServiceSoap;
import us.p.opulo.dao.service.soap.CountryLanguageServiceSoap;
import us.p.opulo.dao.service.soap.CountryServiceSoap;
import us.p.opulo.dao.service.soap.InfectionServiceSoap;
import us.p.opulo.dao.service.soap.LanguageServiceSoap;
import us.p.opulo.guice.annotations.SoapService;
import us.p.opulo.hibernate.HibernateConfig;
import us.p.opulo.hibernate.HibernateConfigImpl;
import us.p.opulo.hibernate.HibernateSession;
import us.p.opulo.hibernate.HibernateSessionImpl;

import com.google.inject.AbstractModule;

public class CoreModule extends AbstractModule {

	@Override
	protected void configure() {
		// DB Connection
		bind(HibernateConfig.class).to(HibernateConfigImpl.class);
		bind(HibernateSession.class).to(HibernateSessionImpl.class);
		
		// Hibernate Services
		bind(CityService.class).annotatedWith(us.p.opulo.guice.annotations.HibernateService.class).to(CityServiceHibernate.class);
		bind(CountryService.class).annotatedWith(us.p.opulo.guice.annotations.HibernateService.class).to(CountryServiceHibernate.class);
		bind(CountryLanguageService.class).annotatedWith(us.p.opulo.guice.annotations.HibernateService.class).to(CountryLanguageServiceHibernate.class);
		bind(InfectionService.class).annotatedWith(us.p.opulo.guice.annotations.HibernateService.class).to(InfectionServiceHibernate.class);
		bind(LanguageService.class).annotatedWith(us.p.opulo.guice.annotations.HibernateService.class).to(LanguageServiceHibernate.class);
		
		// Soap Services
		bind(CityService.class).annotatedWith(SoapService.class).to(CityServiceSoap.class);
		bind(CountryService.class).annotatedWith(SoapService.class).to(CountryServiceSoap.class);
		bind(CountryLanguageService.class).annotatedWith(SoapService.class).to(CountryLanguageServiceSoap.class);
		bind(InfectionService.class).annotatedWith(SoapService.class).to(InfectionServiceSoap.class);
		bind(LanguageService.class).annotatedWith(SoapService.class).to(LanguageServiceSoap.class);
		
		// TODO: Hibernate doesn't go through the factory classes for object creation
		// So the session has to be set statically. There must be a better way around this
		requestStaticInjection(HEntity.class);
	}	
}
