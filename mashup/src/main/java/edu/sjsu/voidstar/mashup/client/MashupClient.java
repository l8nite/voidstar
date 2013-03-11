package edu.sjsu.voidstar.mashup.client;

import javax.xml.ws.WebServiceRef;

import edu.sjsu.voidstar.ws.mashup.MashupPortService;
import edu.sjsu.voidstar.ws.mashup.MashupService;

public class MashupClient {

	@WebServiceRef(wsdlLocation = "http://localhost:8123/mashup?wsdl")
	static MashupPortService mashupPortService = new MashupPortService();

	public static void main(String[] args) {
		MashupClient client = new MashupClient();
		client.runMashupQueries();
	}

	public void runMashupQueries() {
		MashupService service = mashupPortService.getMashupServicePort();
		String mostSpoken = service.getMostSpokenLanguageInCountry("USA");
		System.out.println(mostSpoken);
	}
}
