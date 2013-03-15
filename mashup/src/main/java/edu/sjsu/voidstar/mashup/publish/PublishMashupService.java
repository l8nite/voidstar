package edu.sjsu.voidstar.mashup.publish;

import javax.xml.ws.Endpoint;

import edu.sjsu.voidstar.mashup.service.MashupService;

public class PublishMashupService {
	public static void main (String[] args) {
		Endpoint.publish("http://localhost:8080/mashup", new MashupService());	
	}
}
