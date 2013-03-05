package edu.sjsu.voidstar.client;

import javax.xml.ws.WebServiceRef;

import edu.sjsu.voidstar.ws.City;
import edu.sjsu.voidstar.ws.CityService;
import edu.sjsu.voidstar.ws.CityServiceService;

public class CityClient {
	@WebServiceRef(wsdlLocation="http://localhost:8123/city?wsdl")
	static CityServiceService service;
	
	public static void main(String[] args) {
		service = new CityServiceService();
		CityClient client = new CityClient();
		client.doTest();
	}
	
	public void doTest() {
		CityService port = service.getCityServicePort();
		City fremont = port.getCityById(3877);
		System.out.println(fremont.getName());
	}
}
