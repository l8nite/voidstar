package edu.sjsu.voidstar.project3;

import javax.inject.Inject;
import javax.xml.ws.Endpoint;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.sjsu.voidstar.dao.service.CityService;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.dao.service.CountryService;
import edu.sjsu.voidstar.dao.service.InfectionService;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.CoreModule;
import edu.sjsu.voidstar.guice.annotations.SoapService;

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
