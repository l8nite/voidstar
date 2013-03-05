package edu.sjsu.voidstar.client;

import javax.xml.ws.WebServiceRef;

import edu.sjsu.voidstar.soap.city.City;
import edu.sjsu.voidstar.soap.city.CityPortService;
import edu.sjsu.voidstar.soap.city.CityService;

public class CityClient {
	@WebServiceRef(wsdlLocation="http://localhost:8123/city?wsdl")
	static CityPortService portService = new CityPortService();
	
	public static void main(String[] args) {
		CityClient client = new CityClient();
		client.doTest();
	}
	
	public void doTest() {
		CityService service = portService.getCityServicePort();
		City fremont = service.getCityById(3877);
		System.out.println(fremont.getName());
	}
}
