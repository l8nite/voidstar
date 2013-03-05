package edu.sjsu.voidstar.project3;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.ws.CityPort;

public class PublishServices {
	public static void main(String[] args) {
		CityPort cityService = new CityPort();
		Endpoint.publish("http://localhost:8123/city", cityService);
	}
}
