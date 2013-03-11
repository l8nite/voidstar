package edu.sjsu.voidstar.guice;

import com.google.inject.AbstractModule;

import edu.sjsu.voidstar.dao.service.CityService;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.dao.service.CountryService;
import edu.sjsu.voidstar.dao.service.InfectionService;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.dao.service.hibernate.CityHibernateService;
import edu.sjsu.voidstar.dao.service.hibernate.CountryHibernateService;
import edu.sjsu.voidstar.dao.service.hibernate.CountryLanguageHibernateService;
import edu.sjsu.voidstar.dao.service.hibernate.InfectionHibernateService;
import edu.sjsu.voidstar.dao.service.hibernate.LanguageHibernateService;
import edu.sjsu.voidstar.dao.service.soap.CitySoapService;
import edu.sjsu.voidstar.dao.service.soap.CountrySoapService;
import edu.sjsu.voidstar.dao.service.soap.InfectionSoapService;
import edu.sjsu.voidstar.dao.service.soap.LanguageSoapService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;
import edu.sjsu.voidstar.guice.annotations.SoapService;

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
		bind(InfectionService.class).annotatedWith(SoapService.class).to(InfectionSoapService.class);
		bind(LanguageService.class).annotatedWith(SoapService.class).to(LanguageSoapService.class);
	}	
}
