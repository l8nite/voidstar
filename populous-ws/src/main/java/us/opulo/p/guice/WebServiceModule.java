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

import us.opulo.p.annotations.SoapService;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.dao.service.soap.CityServiceSoap;
import us.opulo.p.dao.service.soap.CountryLanguageServiceSoap;
import us.opulo.p.dao.service.soap.CountryServiceSoap;
import us.opulo.p.dao.service.soap.InfectionServiceSoap;
import us.opulo.p.dao.service.soap.LanguageServiceSoap;

/**
 * Guice web service bindings.
 * @author Jason Campos
 */
public class WebServiceModule extends ServerModule {

	@Override
	protected void configure() {
		// Load server bindings
		super.configure();
		
		// Soap Services
		bind(CityService.class).annotatedWith(SoapService.class).to(CityServiceSoap.class);
		bind(CountryService.class).annotatedWith(SoapService.class).to(CountryServiceSoap.class);
		bind(CountryLanguageService.class).annotatedWith(SoapService.class).to(CountryLanguageServiceSoap.class);
		bind(InfectionService.class).annotatedWith(SoapService.class).to(InfectionServiceSoap.class);
		bind(LanguageService.class).annotatedWith(SoapService.class).to(LanguageServiceSoap.class);
	}	
}
