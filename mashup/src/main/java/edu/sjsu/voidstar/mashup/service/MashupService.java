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
		Country country = countryService.getCountryWithCode(countryCode);
		
		StringBuilder result = new StringBuilder();
		
		if(country == null ) {
			return "Could not find country with code '" + countryCode + "'";
		}
		
		LanguageService languageService = languagePortService.getLanguageServicePort();
		List<Language> languages = languageService.getLanguagesInCountry(country);

		for(Language l : languages) {
			result.append(l.getLanguage() + ", ");
		}
		
		// Strip trailing comma
		return result.length() == 0
				? "No languages spoken in " + country
				: result.substring(0, result.length() - 2);
	}

	//2
	@WebMethod
	public String getCountriesWhichSpeakLanguage(@WebParam(name = "languageName") String languageName) {
		log.info("getCountriesWhichSpeakLanguage(" + languageName + ")");
		
		LanguageService languageService = languagePortService.getLanguageServicePort();
		Language language = languageService.getLanguageWithName(languageName);
		
		StringBuilder result = new StringBuilder();
		
		if(language == null) {
			return "Could not find language '" + languageName + "'";
		}
		
		
		CountryLanguageService countryLanguageService = countryLanguagePortService.getCountryLanguageServicePort();
		List<CountryLanguage> countryLanguages = countryLanguageService.getCountryLanguagesForLanguage(language);
		
		if (countryLanguages.isEmpty()) {
			return language + " is not spoken in any countries";
		}
		
		List<String> countryCodes = new ArrayList<String>();
		for(CountryLanguage countryLanguage : countryLanguages) {
			countryCodes.add(countryLanguage.getCountryCode());
		}
		
		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countries = countryService.getCountriesWithCodes(countryCodes);
		
		if(countries.isEmpty()) {
			return "Could not find the countries in which " + language + " is spoken";
		}
		
		Collections.sort(countries, new Comparator<Country>(){
			public int compare(Country arg0, Country arg1) {
				return (arg0.getName().compareTo(arg1.getName()));
			}
		});
		
		for (Country c : countries) {
			result.append(c.getName() + ", ");
		}
		
		// Strip trailing comma
		return result.substring(0, result.length() - 2);	
				
	}
	
	// 3
	@WebMethod
	public String getZombiesOnContinent(String continent) {
		log.info("getZombiesOnContinent(" + continent + ")");
		String nothing = "No zombies found on continent " + continent;
		
		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countriesOnContinent = countryService.getCountriesOnContinent(continent);
		
		if(countriesOnContinent.isEmpty()) {
			return nothing;
		}
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		List<Infection> infections = infectionService.getInfectionsForCountries(countriesOnContinent);
			
		if(infections.isEmpty()) {
			return nothing;
		}
		
		Long zombieCount = 0L;
		for(Infection infection : infections) {
			zombieCount += infection.getZombies();
		}
		
		return "There are " + zombieCount + " zombies in " + continent;
	}

	// 4
	@WebMethod
	public String getZombiesInCity(@WebParam(name = "cityName") String cityName) {
		CityService cityService = cityPortService.getCityServicePort();
		List<City> cities = cityService.getCitiesWithName(cityName);
		
		if (cities.isEmpty()) {
			return "no cities found with that name";
		}
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		CountryService countryService = countryPortService.getCountryServicePort();
		StringBuilder sb = new StringBuilder();

		for (City city : cities) {
			Infection infection = infectionService.getInfectionForCity(city);
			Country country = countryService.getCountryWithCode(city.getCountryCode());
			
			sb.append(city.getName() + ", " + city.getDistrict() + " " + country.getName() + " - ");
			if (infection != null) {
				 sb.append(infection.getZombies() + " infected\n");
			}
			else {
				sb.append("not infected\n");
			}
		}
		
		return sb.toString();
	}
	
	// 5
	public String getZombiesInCountriesWhereLanguageIsSpoken(@WebParam(name = "language") String language)
	{
		return null;
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
		List<Country> countries = cs.getCountriesOnContinent("North America");
		
		List<City> citiesByCountry = service.getCitiesInCountry(countries.get(0));
		System.out.println("getCitiesInCountry returned " + citiesByCountry.size() + " results");
		
		citiesByCountry = service.getCitiesInCountries(countries);
		System.out.println("getCitiesInCountries returned " + citiesByCountry.size() + " results");

 		return "woot";
	}
	
	@WebMethod
	public String testCountryLanguageMethods() {
		LanguageService languageService = languagePortService.getLanguageServicePort();
		CountryService countryService = countryPortService.getCountryServicePort();
		CountryLanguageService clService = countryLanguagePortService.getCountryLanguageServicePort();
		
		List<Country> countries = countryService.getCountriesOnContinent("North America");
		List<Language> languages = languageService.getLanguagesInCountry(countries.get(0));
		
		List<CountryLanguage> countryLanguages = clService.getCountryLanguagesForLanguage(languages.get(0));
		System.out.println("getCountryLanguagesForLanguage() returned " + countryLanguages.size() + " result");
			
		countryLanguages = clService.getCountryLanguagesForLanguages(languages);
		System.out.println("getCountryLanguagesForLanguages() returned " + countryLanguages.size() + " result");
		
		countryLanguages = clService.getCountryLanguagesForCountry(countries.get(0));
		System.out.println("getCountryLanguagesForCountry() returned " + countryLanguages.size() + " result");
		
		countryLanguages = clService.getCountryLanguagesForCountries(countries);
		System.out.println("getCountryLanguagesForCountries() returned " + countryLanguages.size() + " result");
		
		return "woot";
	}
	
	@WebMethod
	public String testCountryMethods() {
		CountryService countryService = countryPortService.getCountryServicePort();
		
		Country country = countryService.getCountryWithCode("usa");
		System.out.println("getCountryWithCode() returned " + country);
		
		List<Country> countries = countryService.getCountriesWithCodes(Arrays.asList("usa", "mex"));
		System.out.println("getCountryWithCodes() returned " + countries.size() + " results");
		
		countries = countryService.getCountriesOnContinent("North America");
		System.out.println("getCountryWithCodes() returned " + countries.size() + " results");
		
		countries = countryService.getCountriesOnContinents(Arrays.asList("North America", "South America"));
		System.out.println("getCountryOnContinents() returned " + countries.size() + " results");
		
		return "woot";
	}
	
	@WebMethod
	public String testInfectionMethods() {
		CountryService countryService = countryPortService.getCountryServicePort();
		CityService cityService = cityPortService.getCityServicePort();
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		
		Country country = countryService.getCountryWithCode("usa");
		List<Country> countries = countryService.getCountriesOnContinent("North America");
		
		City city = cityService.getCityWithId(3877);
		List<City> cities = cityService.getCitiesInCountry(country);
		
		Infection infection = infectionService.getInfectionForCity(city);
		System.out.println("getInfectionForCity returned " + infection);
		
		List<Infection> infections = infectionService.getInfectionForCities(cities);
		System.out.println("getInfectionsForCities returned " + infections.size() + " results");
		
		infections = infectionService.getInfectionsForCountry(country);
		System.out.println("getInfectionsForCountry() returned " + infections.size() + " results");
		
		infections = infectionService.getInfectionsForCountries(countries);
		System.out.println("getInfectionsForCountries() returned " + infections.size() + " results");
		return "woot";
	}
	
	@WebMethod
	public String testLanguageMethods() {
		CountryService countryService = countryPortService.getCountryServicePort();
		LanguageService languageService = languagePortService.getLanguageServicePort();
		
		Country country = countryService.getCountryWithCode("usa");
		List<Country> countries = countryService.getCountriesOnContinent("Asia");
		
		Language language = languageService.getLanguageWithId(1);
		System.out.println("getLanguageWithId returned " + language);
		
		List<Language> languages = languageService.getLanguagesWithIds(Arrays.asList(1, 2, 3));
		System.out.println("getLanguagesWithIds returned " + languages.size() + " results");
		
		language = languageService.getLanguageWithName("Cantonese");
		System.out.println("getLanguageWithName() returned " + language);
		
		languages = languageService.getLanguagesWithNames(Arrays.asList("Cantonese", "Vietnamese"));
		System.out.println("getLanguagesWithNames() returned " + languages.size() + " results");
		
		languages = languageService.getLanguagesInCountry(country);
		System.out.println("getLanguagesInCountry() returned " + languages.size() + " results");
		
		languages = languageService.getLanguagesInCountries(countries);
		System.out.println("getLanguagesInCountries() returned " + languages.size() + " results");
		return "woot";
		
	}
}
 