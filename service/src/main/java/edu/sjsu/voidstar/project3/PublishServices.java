package edu.sjsu.voidstar.project3;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.soap.CitySoapService;
import edu.sjsu.voidstar.soap.CountrySoapService;
import edu.sjsu.voidstar.soap.InfectionSoapService;

public class PublishServices {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8123/city", new CitySoapService());
		Endpoint.publish("http://localhost:8124/country", new CountrySoapService());
		Endpoint.publish("http://localhost:8125/infection", new InfectionSoapService());
	}
}
