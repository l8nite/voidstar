package edu.sjsu.voidstar.project3;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.soap.CitySoapService;

public class PublishServices {
	public static void main(String[] args) {
		CitySoapService cityService = new CitySoapService();
		Endpoint.publish("http://localhost:8123/city", cityService);
	}
}
