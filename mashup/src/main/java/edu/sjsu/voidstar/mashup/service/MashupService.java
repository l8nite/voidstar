package edu.sjsu.voidstar.mashup.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.ws.dao.Country;
import edu.sjsu.voidstar.ws.dao.Language;
import edu.sjsu.voidstar.ws.soap.country.CountryPortService;
import edu.sjsu.voidstar.ws.soap.country.CountryService;
import edu.sjsu.voidstar.ws.soap.language.LanguagePortService;
import edu.sjsu.voidstar.ws.soap.language.LanguageService;

import javax.xml.ws.WebServiceRef;

@WebService(targetNamespace = "http://ws.voidstar.sjsu.edu/mashup", serviceName = "MashupPortService", name = "MashupService")
public class MashupService {
	@WebServiceRef(wsdlLocation = "http://localhost:8123/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/language?wsdl")
	static LanguagePortService languagePortService = new LanguagePortService();

	private static final Logger log = LoggerFactory.getLogger(MashupService.class);

	@WebMethod
	public String getLanguagesSpokenInCountry(@WebParam(name = "countryCode") String countryCode) {
		log.info("getLanguagesSpokenInCountry(" + countryCode + ")");

		CountryService countryService = countryPortService.getCountryServicePort();
		Country country = countryService.getCountryByCode(countryCode);

		LanguageService languageService = languagePortService.getLanguageServicePort();
		List<Language> languages = languageService.getLanguagesByCountry(country);

		return languages.toString();
	}

	@WebMethod
	public String getNumberOfZombiesInCity(@WebParam(name = "cityName") String cityName) {
		// CityService.getCityByName(cityName)
		// InfectionService.getInfectionByCity(city)
		log.info("getNumberOfZombiesInCity(" + cityName + ")");
		return cityName;
	}

	@WebMethod
	public String getCountriesWhichSpeakLanguage(@WebParam(name = "languageName") String languageName) {
		log.info("getCountriesWhichSpeakLanguage(" + languageName + ")");
		return languageName;
	}
}
