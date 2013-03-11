package edu.sjsu.voidstar.mashup.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.ws.dao.Country;
import edu.sjsu.voidstar.ws.mashup.MashupPortService;
import edu.sjsu.voidstar.ws.soap.city.CityPortService;
import edu.sjsu.voidstar.ws.soap.country.CountryPortService;
import edu.sjsu.voidstar.ws.soap.country.CountryService;

import javax.xml.ws.WebServiceRef;

@WebService(targetNamespace = "http://ws.voidstar.sjsu.edu/mashup", serviceName = "MashupPortService", name = "MashupService")
public class MashupService {
	@WebServiceRef(wsdlLocation = "http://localhost:8123/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();

	private static final Logger log = LoggerFactory
			.getLogger(MashupService.class);

	@WebMethod
	public String getMostSpokenLanguageInCountry(
			@WebParam(name = "countryCode") String countryCode) {
		// get country from CountryService
		CountryService countryService = countryPortService
				.getCountryServicePort();
		Country country = countryService.getCountryByCode(countryCode);
		log.info("getMostSpokenLanguageInCountry(" + countryCode + ")");

		// TODO do something with languages

		return country.getHeadOfState();
	}
}
