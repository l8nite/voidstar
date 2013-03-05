package edu.sjsu.voidstar.project3;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.ws.CityService;

public class PublishServices {
	public static void main(String[] args) {
		CityService cityService = new CityService();
		Endpoint.publish("http://localhost:8123/city", cityService);
	}
}
