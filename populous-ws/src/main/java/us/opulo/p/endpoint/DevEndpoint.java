package us.opulo.p.endpoint;

import javax.xml.ws.Endpoint;

import us.opulo.p.dao.service.soap.CityServiceSoap;
import us.opulo.p.dao.service.soap.CountryLanguageServiceSoap;
import us.opulo.p.dao.service.soap.CountryServiceSoap;
import us.opulo.p.dao.service.soap.InfectionServiceSoap;
import us.opulo.p.dao.service.soap.LanguageServiceSoap;

/**
 * Serves soap requests at a localhost endpoint. For development purposes only.
 * @author Shaun Guth
 */
public class DevEndpoint {
	
	public static void main(String... args) {
		Endpoint.publish("http://localhost:8123/city", new CityServiceSoap());
		Endpoint.publish("http://localhost:8123/country", new CountryServiceSoap());
		Endpoint.publish("http://localhost:8123/countrylanguage", new CountryLanguageServiceSoap());
		Endpoint.publish("http://localhost:8123/infection", new InfectionServiceSoap());
		Endpoint.publish("http://localhost:8123/language", new LanguageServiceSoap());
	}
}
