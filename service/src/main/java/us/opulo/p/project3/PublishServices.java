/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.project3;

import javax.inject.Inject;
import javax.xml.ws.Endpoint;

import com.google.inject.Guice;
import com.google.inject.Injector;

import us.opulo.p.dao.service.CityService;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.guice.CoreModule;
import us.opulo.p.guice.annotations.SoapService;

public class PublishServices {
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CoreModule());
		injector.getInstance(WebService.class).run();
	}
	
	private static class WebService {
		@Inject
		@SoapService
		CityService cityService;
		
		@Inject
		@SoapService
		CountryService countryService;
		
		@Inject
		@SoapService
		CountryLanguageService countryLanguageService;
		
		@Inject
		@SoapService
		InfectionService infectionService;
		
		@Inject
		@SoapService
		LanguageService languageService;
		
		public void run() {
			Endpoint.publish("http://localhost:8123/city", cityService);
			Endpoint.publish("http://localhost:8123/country", countryService);
			Endpoint.publish("http://localhost:8123/countrylanguage", countryLanguageService);
			Endpoint.publish("http://localhost:8123/infection", infectionService);
			Endpoint.publish("http://localhost:8123/language", languageService);
		}
	}
}