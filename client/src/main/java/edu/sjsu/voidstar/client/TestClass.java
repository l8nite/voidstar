package edu.sjsu.voidstar.client;

import javax.xml.ws.WebServiceRef;

import edu.sjsu.voidstar.soap.city.City;
import edu.sjsu.voidstar.soap.city.CityPortService;
import edu.sjsu.voidstar.soap.city.CityService;
import edu.sjsu.voidstar.soap.country.Country;
import edu.sjsu.voidstar.soap.country.CountryPortService;
import edu.sjsu.voidstar.soap.country.CountryService;
import edu.sjsu.voidstar.soap.infection.Infection;
import edu.sjsu.voidstar.soap.infection.InfectionPortService;
import edu.sjsu.voidstar.soap.infection.InfectionService;

public class TestClass {
	@WebServiceRef(wsdlLocation="http://localhost:8123/city?wsdl")
	static CityPortService cityPortService = new CityPortService();
	
	@WebServiceRef(wsdlLocation="http://localhost:8124/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();
	
	@WebServiceRef(wsdlLocation="http://localhost:8125/infection?wsdl")
	static InfectionPortService infectionPortService = new InfectionPortService();
	
	public static void main(String[] args) {
		TestClass client = new TestClass();
		client.doTest();
	}
	
	public void doTest() {
		CityService cityService = cityPortService.getCityServicePort();
		City fremont = cityService.getCityById(3877);
		System.out.println(fremont);
		
		CountryService countryService = countryPortService.getCountryServicePort();
		Country country = countryService.getCountryByCode("usa");
		System.out.println(country);
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		Infection infection = infectionService.getInfectionByCity(fremont);
		System.out.println(infection);
	}
}
