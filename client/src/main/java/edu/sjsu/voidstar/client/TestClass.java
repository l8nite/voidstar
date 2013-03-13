package edu.sjsu.voidstar.client;

import javax.xml.ws.WebServiceRef;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.soap.city.CityPortService;
import us.opulo.p.soap.city.CityService;
import us.opulo.p.soap.country.CountryPortService;
import us.opulo.p.soap.country.CountryService;
import us.opulo.p.soap.infection.InfectionPortService;
import us.opulo.p.soap.infection.InfectionService;


public class TestClass {
	@WebServiceRef(wsdlLocation="http://localhost:8123/city?wsdl")
	static CityPortService cityPortService = new CityPortService();
	
	@WebServiceRef(wsdlLocation="http://localhost:8123/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();
	
	@WebServiceRef(wsdlLocation="http://localhost:8123/infection?wsdl")
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
