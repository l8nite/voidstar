package edu.sjsu.voidstar.service.client;

import java.util.List;

import javax.xml.ws.WebServiceRef;

import us.opulo.p.dao.City;
import us.opulo.p.soap.city.CityPortService;
import us.opulo.p.soap.city.CityService;

public class ServiceClient {

	@WebServiceRef
	static CityPortService cityPortService = new CityPortService();

	public static void main(String[] args) {
		ServiceClient client = new ServiceClient();
		client.runTestQueries();
	}

	public void runTestQueries() {
		CityService cityService = cityPortService.getCityServicePort();
		
		List<City> cities = cityService.getCitiesWithName("Fremont");
		System.out.println(cities);
	}
}
