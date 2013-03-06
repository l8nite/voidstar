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
			public static final String PATH = "src/main/resources/xsd";
			
			public static final String CITIES = PATH + "/Cities.xsd";
			public static final String COUNTRIES = PATH + "/Countries.xsd";
			public static final String COUNTRY_LANGUAGES = PATH + "/CountryLanguages.xsd";
			public static final String INFECTIONS = PATH + "/Infections.xsd";
			public static final String LANGUAGES = PATH + "/Languages.xsd";
		}
		
		public static class WSDL {
			public static final String PATH = "wsdl/";
					
			public static final String CITY_SOAP_SERVICE = PATH + "CitySoapService.wsdl";
			public static final String COUNTRY_SOAP_SERVICE = PATH + "CountrySoapService.wsdl";
			public static final String INFECTION_SOAP_SERVICE = PATH + "InfectionSoapService.wsdl";
		}
	}
	
	/*
	 * Soap Constants
	 */
	public static class Namespaces {
		public static final String BASE_NAMESPACE = "http://ws.voidstar.sjsu.edu/";
		public static final String DAO = BASE_NAMESPACE + "dao/";
		
		public static class Services {
			public static final String SERVICES_NAMESPACE = BASE_NAMESPACE + "ws/";
			public static final String CITY = SERVICES_NAMESPACE + "city";
			public static final String COUNTRY = SERVICES_NAMESPACE + "country";
			public static final String INFECTION = SERVICES_NAMESPACE + "infection";
		}
	}
}
