package edu.sjsu.voidstar.mashup.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;
import us.opulo.p.soap.country.CountryPortService;
import us.opulo.p.soap.country.CountryService;
import us.opulo.p.soap.countrylanguage.CountryLanguagePortService;
import us.opulo.p.soap.countrylanguage.CountryLanguageService;
import us.opulo.p.soap.language.LanguagePortService;
import us.opulo.p.soap.language.LanguageService;

@WebService(targetNamespace = "http://p.opulo.us/mashup", serviceName = "MashupPortService", name = "MashupService")
public class MashupService {
	@WebServiceRef(wsdlLocation = "http://localhost:8123/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/language?wsdl")
	static LanguagePortService languagePortService = new LanguagePortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/countrylanguage?wsdl")
	static CountryLanguagePortService countryLanguagePortService = new CountryLanguagePortService();

	private static final Logger log = LoggerFactory.getLogger(MashupService.class);

	// 1 
	@WebMethod
	public String getLanguagesSpokenInCountry(@WebParam(name = "countryCode") String countryCode) {
		log.info("getLanguagesSpokenInCountry(" + countryCode + ")");

		CountryService countryService = countryPortService.getCountryServicePort();
		Country country = countryService.getCountryByCode(countryCode);
		
		StringBuilder result = new StringBuilder();
		
		if(country != null ) {
			LanguageService languageService = languagePortService.getLanguageServicePort();
			List<Language> languages = languageService.getLanguagesByCountry(country);
	
			
			for(Language l : languages) {
				result.append(l.getLanguage() + ", ");
			}
		}
		
		// Strip trailing comma
		return result.length() > 0 ? result.substring(0, result.length() - 2) : "";
	}

	@WebMethod
	public String getCountriesWhichSpeakLanguage(@WebParam(name = "languageName") String languageName) {
		log.info("getCountriesWhichSpeakLanguage(" + languageName + ")");
		
		LanguageService languageService = languagePortService.getLanguageServicePort();
		Language language = languageService.getLanguageByName(languageName);
		
		StringBuilder result = new StringBuilder();
		
		if(language != null) {
			CountryLanguageService cls = countryLanguagePortService.getCountryLanguageServicePort();
			List<CountryLanguage> countryLanguages = cls.getCountryLanguagesByLanguage(language);
			
			if (!countryLanguages.isEmpty()) {
				CountryService cs = countryPortService.getCountryServicePort();
				List<Country> countries = new ArrayList<Country>();
				
				for(CountryLanguage cl : countryLanguages) {
					Country country = cs.getCountryByCode(cl.getCountryCode());
					if (country != null) {
						countries.add(country);
					}
				}
				
				if(!countries.isEmpty()) {
					Collections.sort(countries, new Comparator<Country>(){
						public int compare(Country arg0, Country arg1) {
							return (arg0.getName().compareTo(arg1.getName()));
						}
					});
					for (Country c : countries) {
						result.append(c.getName() + ", ");
					}
				}
			}
		}
		// Strip trailing comma
		return result.length() > 0 ? result.substring(0, result.length() - 2) : "";	
	}
	
	@WebMethod
	public String getNumberOfZombiesInCity(@WebParam(name = "cityName") String cityName) {
		// CityService.getCityByName(cityName)
		// InfectionService.getInfectionByCity(city)
		log.info("getNumberOfZombiesInCity(" + cityName + ")");
		return cityName;
	}

}
 