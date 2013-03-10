package edu.sjsu.voidstar.constants;


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
			public static final String COUNTRIES = PATH + "/Countries.xsd";
			public static final String COUNTRY_LANGUAGES = PATH + "/CountryLanguages.xsd";
			public static final String INFECTIONS = PATH + "/Infections.xsd";
			public static final String LANGUAGES = PATH + "/Languages.xsd";
		}
		
		public static class WSDL {
			public static final String PATH = "wsdl/";
					
			public static final String CITY_SERVICE = PATH + "CitySoapService.wsdl";
			public static final String COUNTRY_SERVICE = PATH + "CountrySoapService.wsdl";
			public static final String INFECTION_SERVICE = PATH + "InfectionSoapService.wsdl";
			public static final String LANGUAGE_SERVICE = PATH + "LanguageSoapService.wsdl";
		}
	}
	
	/*
	 * Soap Constants
	 */
	public static class Namespaces {
		public static final String NS = "http://ws.voidstar.sjsu.edu/";
		public static final String DAO = NS + "dao";
		
		public static class Soap {
			public static final String SOAP_NS = NS + "soap";
			public static final String CITY_SERVICE = SOAP_NS + "/city";
			public static final String COUNTRY = SOAP_NS + "/country";
			public static final String INFECTION_SERVICE = SOAP_NS + "/infection";
			public static final String LANGUAGE_SERVICE = SOAP_NS + "/language";
		}
	}
}
