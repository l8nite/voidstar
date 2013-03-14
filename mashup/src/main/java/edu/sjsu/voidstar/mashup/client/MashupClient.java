package edu.sjsu.voidstar.mashup.client;

import javax.xml.ws.WebServiceRef;

import edu.sjsu.voidstar.ws.mashup.MashupPortService;
import edu.sjsu.voidstar.ws.mashup.MashupService;

public class MashupClient {

	@WebServiceRef(wsdlLocation = "http://localhost:8124/mashup?wsdl")
	static MashupPortService mashupPortService = new MashupPortService();

	public static void main(String[] args) {
		MashupClient client = new MashupClient();
		client.runMashupQueries();
	}

	public void runMashupQueries() {
		MashupService service = mashupPortService.getMashupServicePort();
		
		System.out.println("City services are working... " + service.testCityMethods());
		System.out.println("CountryLanguage services are working... " + service.testCountryLanguageMethods());
		System.out.println("Country services are working... " + service.testCountryMethods());
		System.out.println("Infection services are working..." + service.testInfectionMethods());

		System.out.println(service.getLanguagesSpokenInCountry("USA"));
		
		System.out.println(service.getCountriesWhichSpeakLanguage("English"));
		
		System.out.println(service.getZombiesOnContinent("North America"));
		
		System.out.println(service.getZombiesInCity("San Francisco"));
		
		System.out.println(service.getZombiesInCity("San Jose"));
	}
}
