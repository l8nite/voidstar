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
package us.p.opulo.constants;

public class Constants {

	/*
	 * Filenames
	 */
	public static class Resources {
				
		public static class XML {
			public static final String PATH = "src/main/resources/xml";
			
			public static final String CITIES = PATH + "/Cities.xml";
			public static final String COUNTRIES = PATH + "/Countries.xml";
			public static final String COUNTRY_LANGUAGES = PATH + "/CountryLanguages.xml";
			public static final String INFECTIONS = PATH + "/Infections.xml";
			public static final String LANGUAGES = PATH + "/Languages.xml";
		}
		
		public static class XSD {
			public static final String PATH = "src/main/resources/xsd/dao/";
			
			public static final String CITIES = PATH + "/Cities.xsd";
			public static final String CITY = PATH + "/City.xsd";
			public static final String COUNTRIES = PATH + "/Countries.xsd";
			public static final String COUNTRY = PATH + "/Country.xsd";
			public static final String COUNTRY_LANGUAGES = PATH + "/CountryLanguages.xsd";
			public static final String COUNTRY_LANGUAGE = PATH + "/CountryLanguage.xsd";
			public static final String INFECTIONS = PATH + "/Infections.xsd";
			public static final String INFECTION = PATH + "/Infection.xsd";
			public static final String LANGUAGES = PATH + "/Languages.xsd";
			public static final String LANGUAGE = PATH + "/Language.xsd";
		}
		
		public static class WSDL {
			public static final String PATH = "wsdl/";
					
			public static final String CITY_SERVICE = PATH + "CitySoapService.wsdl";
			public static final String COUNTRY_SERVICE = PATH + "CountrySoapService.wsdl";
			public static final String COUNTRY_LANGUAGE_SERVICE = PATH + "CountryLanguageSoapService.wsdl";
			public static final String INFECTION_SERVICE = PATH + "InfectionSoapService.wsdl";
			public static final String LANGUAGE_SERVICE = PATH + "LanguageSoapService.wsdl";
		}
	}
	
	/*
	 * Web Service Constants
	 */
	public static class WebService {
		private static final String CITY_EXT = "/city";
		private static final String COUNTRY_EXT = "/country";
		private static final String COUNTRY_LANGUAGE_EXT = "/countrylanguage";
		private static final String INFECTION_EXT = "/infection";
		private static final String LANGUAGE_EXT = "/language";
	
	
		public static class Soap {
			public static final String ADDRESS = "http://localhost:8123";
			
			public static class Service {
				public static final String CITY = ADDRESS + CITY_EXT;
				public static final String COUNTRY = ADDRESS + COUNTRY_EXT;
				public static final String COUNTRY_LANGUAGE = ADDRESS + COUNTRY_LANGUAGE_EXT;
				public static final String INFECTION = ADDRESS + INFECTION_EXT;
				public static final String LANGUAGE = ADDRESS + LANGUAGE_EXT;
				
			}
			
			public static class WSDL {
				private static final String WSDL= "?wsdl";
				public static final String CITY = Service.CITY + WSDL;
				public static final String COUNTRY = Service.COUNTRY + WSDL;
				public static final String COUNTRY_LANGUAGE = Service.COUNTRY_LANGUAGE + WSDL;
				public static final String INFECTION = Service.INFECTION + WSDL;
				public static final String LANGUAGE = Service.LANGUAGE + WSDL;
				
			}
			
			public static class ServiceName {
				public static final String CITY_PORT_SERVICE = "CityPortService";
				public static final String CITY_SERVICE = "CityService";
				public static final String COUNTRY_PORT_SERVICE = "CountryPortService";
				public static final String COUNTRY_SERVICE = "CountryService";
				public static final String COUNTRY_LANGUAGE_PORT_SERVICE = "CountryLanguagePortService";
				public static final String COUNTRY_LANGUAGE_SERVICE = "CountryLanguageService";
				public static final String INFECTION_PORT_SERVICE = "InfectionPortService";
				public static final String INFECTION_SERVICE = "InfectionService";
				public static final String LANGUAGE_PORT_SERVICE = "LanguagePortService";
				public static final String LANGUAGE_SERVICE = "LanguageService";
			}
		}
	}
	/*
	 * Xml Constants
	 */
	public static class XML {		
		public static class Namespaces {
			public static final String NS = "http://p.opulo.us/";
			public static final String DAO = NS + "dao";
			
			public static class Soap {
				public static final String SOAP_NS = NS + "soap";
				public static final String CITY_SERVICE = SOAP_NS + "/city";
				public static final String COUNTRY_SERVICE = SOAP_NS + "/country";
				public static final String COUNTRY_LANGUAGE_SERVICE = SOAP_NS + "/countrylanguage";
				public static final String INFECTION_SERVICE = SOAP_NS + "/infection";
				public static final String LANGUAGE_SERVICE = SOAP_NS + "/language";
			}		
		}
	}
}
