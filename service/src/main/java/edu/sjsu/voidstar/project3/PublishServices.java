package edu.sjsu.voidstar.project3;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.soap.CitySoapService;
import edu.sjsu.voidstar.soap.CountrySoapService;
import edu.sjsu.voidstar.soap.InfectionSoapService;


public class PublishServices {
	public static void main(String[] args) {
		// TODO: Need to edit the service class annotations to generate the correct WSDLs.
		Endpoint.publish("http://localhost:8123/city", new CitySoapService());
		Endpoint.publish("http://localhost:8123/country", new CountrySoapService());
		Endpoint.publish("http://localhost:8123/infection", new InfectionSoapService());
	}
}
