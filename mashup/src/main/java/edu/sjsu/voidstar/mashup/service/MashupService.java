package edu.sjsu.voidstar.mashup.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.Language;
import us.opulo.p.soap.city.CityPortService;
import us.opulo.p.soap.city.CityService;
import us.opulo.p.soap.country.CountryPortService;
import us.opulo.p.soap.country.CountryService;
import us.opulo.p.soap.countrylanguage.CountryLanguagePortService;
import us.opulo.p.soap.countrylanguage.CountryLanguageService;
import us.opulo.p.soap.infection.InfectionPortService;
import us.opulo.p.soap.infection.InfectionService;
import us.opulo.p.soap.language.LanguagePortService;
import us.opulo.p.soap.language.LanguageService;

@WebService(targetNamespace = "http://ws.voidstar.sjsu.edu/mashup", serviceName = "MashupPortService", name = "MashupService")
public class MashupService {
	@WebServiceRef(wsdlLocation = "http://localhost:8123/country?wsdl")
	static CountryPortService countryPortService = new CountryPortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/language?wsdl")
	static LanguagePortService languagePortService = new LanguagePortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/countrylanguage?wsdl")
	static CountryLanguagePortService countryLanguagePortService = new CountryLanguagePortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/city?wsdl")
	static CityPortService cityPortService = new CityPortService();

	@WebServiceRef(wsdlLocation = "http://localhost:8123/infection?wsdl")
	static InfectionPortService infectionPortService = new InfectionPortService();

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

	//2
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
	public String getZombiesOnContinent(String continent) {
		log.info("getZombiesOnContinent(" + continent + ")");
		String nothing = "No zombies found on continent " + continent;
		
		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countriesOnContinent = countryService.getCountriesByContinent(continent);
		
		if(countriesOnContinent.isEmpty()) {
			return nothing;
		}
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		List<Infection> zombieInfections = new ArrayList<Infection>();
		for(Country country: countriesOnContinent) {
			zombieInfections.addAll(infectionService.getInfectionsByCountry(country));
		}
		
		if(zombieInfections.isEmpty()) {
			
			return nothing;
		}
		
		Long zombieCount = 0L;
		for(Infection infection : zombieInfections) {
			zombieCount += infection.getZombies();
		}
		
		return "There are " + zombieCount + " zombies in " + continent;
	}

	@WebMethod
	public String getNumberOfZombiesInCity(@WebParam(name = "cityName") String cityName) {
		// CityService.getCityByName(cityName)
		// InfectionService.getInfectionByCity(city)
		log.info("getNumberOfZombiesInCity(" + cityName + ")");
		return cityName;
	}
	
	@WebMethod
	public String testCityMethods() {
		CityService service = cityPortService.getCityServicePort();
		
		City city = service.getCityWithId(3877);
		System.out.println("getCitiesWithId return " + city);		
		
		List<City> citiesById = service.getCitiesWithIds(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("getCitiesWithIds returned " + citiesById.size() + " results");
		
		List<City> citiesByName = service.getCitiesWithName("San Jose");
		System.out.println("getCitiesWithName returned " + citiesByName.size() + "results");
		
		citiesByName = service.getCitiesWithNames(Arrays.asList("Sunnyvale", "Santa Clara", "San Jose"));
		System.out.println("getCitiesWithNames returned " + citiesByName.size() + " results");
		
		CountryService cs = countryPortService.getCountryServicePort();
		List<Country> countries = cs.getCountriesByContinent("North America");
		
		List<City> citiesByCountry = service.getCitiesInCountry(countries.get(0));
		System.out.println("getCitiesInCountry returned " + citiesByCountry.size() + " results");
		
		citiesByCountry = service.getCitiesInCountries(countries);
		System.out.println("getCitiesInCountries returned " + citiesByCountry.size() + " results");

 		return "woot";
	}
}
 