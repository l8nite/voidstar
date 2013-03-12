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
package us.p.opulo.guice;

import com.google.inject.AbstractModule;

import us.p.opulo.dao.service.CityService;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.dao.service.CountryService;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.dao.service.hibernate.CityHibernateService;
import us.p.opulo.dao.service.hibernate.CountryHibernateService;
import us.p.opulo.dao.service.hibernate.CountryLanguageHibernateService;
import us.p.opulo.dao.service.hibernate.InfectionHibernateService;
import us.p.opulo.dao.service.hibernate.LanguageHibernateService;
import us.p.opulo.dao.service.soap.CitySoapService;
import us.p.opulo.dao.service.soap.CountryLanguageSoapService;
import us.p.opulo.dao.service.soap.CountrySoapService;
import us.p.opulo.dao.service.soap.InfectionSoapService;
import us.p.opulo.dao.service.soap.LanguageSoapService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.guice.annotations.SoapService;

public class CoreModule extends AbstractModule {

	@Override
	protected void configure() {
		
		// Hibernate Services
		bind(CityService.class).annotatedWith(HibernateService.class).to(CityHibernateService.class);
		bind(CountryService.class).annotatedWith(HibernateService.class).to(CountryHibernateService.class);
		bind(CountryLanguageService.class).annotatedWith(HibernateService.class).to(CountryLanguageHibernateService.class);
		bind(InfectionService.class).annotatedWith(HibernateService.class).to(InfectionHibernateService.class);
		bind(LanguageService.class).annotatedWith(HibernateService.class).to(LanguageHibernateService.class);
		
		// Soap Services
		bind(CityService.class).annotatedWith(SoapService.class).to(CitySoapService.class);
		bind(CountryService.class).annotatedWith(SoapService.class).to(CountrySoapService.class);
		bind(CountryLanguageService.class).annotatedWith(SoapService.class).to(CountryLanguageSoapService.class);
		bind(InfectionService.class).annotatedWith(SoapService.class).to(InfectionSoapService.class);
		bind(LanguageService.class).annotatedWith(SoapService.class).to(LanguageSoapService.class);
	}	
}
