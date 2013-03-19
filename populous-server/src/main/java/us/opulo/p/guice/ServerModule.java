/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.guice;

import us.opulo.p.dao.service.CityService;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.dao.service.hibernate.CityServiceHibernate;
import us.opulo.p.dao.service.hibernate.CountryLanguageServiceHibernate;
import us.opulo.p.dao.service.hibernate.CountryServiceHibernate;
import us.opulo.p.dao.service.hibernate.InfectionServiceHibernate;
import us.opulo.p.dao.service.hibernate.LanguageServiceHibernate;
import us.opulo.p.hibernate.HibernateConfig;
import us.opulo.p.hibernate.HibernateConfigImpl;
import us.opulo.p.hibernate.HibernateSession;
import us.opulo.p.hibernate.HibernateSessionImpl;

import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		// DB Connection
		bind(HibernateConfig.class).to(HibernateConfigImpl.class);
		bind(HibernateSession.class).to(HibernateSessionImpl.class);
				
		// Hibernate Services
		bind(CityService.class).annotatedWith(us.opulo.p.annotations.HibernateService.class).to(CityServiceHibernate.class);
		bind(CountryService.class).annotatedWith(us.opulo.p.annotations.HibernateService.class).to(CountryServiceHibernate.class);
		bind(CountryLanguageService.class).annotatedWith(us.opulo.p.annotations.HibernateService.class).to(CountryLanguageServiceHibernate.class);
		bind(InfectionService.class).annotatedWith(us.opulo.p.annotations.HibernateService.class).to(InfectionServiceHibernate.class);
		bind(LanguageService.class).annotatedWith(us.opulo.p.annotations.HibernateService.class).to(LanguageServiceHibernate.class);
		
	}	
}
