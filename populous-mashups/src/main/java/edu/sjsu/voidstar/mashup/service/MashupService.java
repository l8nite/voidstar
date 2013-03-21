package edu.sjsu.voidstar.mashup.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

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
	@Resource
	WebServiceContext webServiceContext;
	
	@WebServiceRef
	static CountryPortService countryPortService = new CountryPortService();

	@WebServiceRef
	static LanguagePortService languagePortService = new LanguagePortService();

	@WebServiceRef
	static CountryLanguagePortService countryLanguagePortService = new CountryLanguagePortService();

	@WebServiceRef
	static CityPortService cityPortService = new CityPortService();

	@WebServiceRef
	static InfectionPortService infectionPortService = new InfectionPortService();
	
	@WebServiceRef
	static GeoIPService geoIPService = new GeoIPService();
	
	

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

		Language language = _getLanguageNamed(languageName);
		
		if (language == null) {
			return "No language found named '" + languageName + "'";
		}
		
		List<CountryLanguage> countryLanguages = _getCountryLanguagesForLanguage(language);
		
		if (countryLanguages.isEmpty()) {
			return "No countries found where " + languageName + " is spoken";
		}

		List<Country> countriesWhereLanguageIsSpoken;
		countriesWhereLanguageIsSpoken = _getCountriesForCountryLanguages(countryLanguages);

		Collections.sort(countriesWhereLanguageIsSpoken, new Comparator<Country>(){
			public int compare(Country arg0, Country arg1) {
				return (arg0.getName().compareTo(arg1.getName()));
			}
		});

		StringBuilder result = new StringBuilder();
		for (Country c : countriesWhereLanguageIsSpoken) {
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
		List<Infection> infections = infectionService.getInfectionForCities(cities);
		
		HashMap<Integer, Infection> infectionForCityId = new HashMap<Integer, Infection>();
		for (Infection infection : infections) {
			infectionForCityId.put(infection.getCityID(), infection);
		}

		ArrayList<String> countryCodes = new ArrayList<String>();
		for (City city : cities) {
			countryCodes.add(city.getCountryCode());
		}
		
		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countries = countryService.getCountriesWithCodes(countryCodes);
		
		HashMap<String, Country> countryForCode = new HashMap<String, Country>();
		for (Country country : countries) {
			countryForCode.put(country.getCode(), country);
		}

		StringBuilder sb = new StringBuilder();
		for (City city : cities) {
			Country country = countryForCode.get(city.getCountryCode());
			sb.append(city.getName() + ", " + city.getDistrict() + " " + country.getName() + " - ");

			Infection infection = infectionForCityId.get(city.getID());
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
	@WebMethod
	public String getZombiesInCountriesWhereLanguageIsSpoken(@WebParam(name = "languageName") String languageName)
	{
		log.info("getZombiesInCountriesWhereLanguageIsSpoken(" + languageName + ")");
		
		Language language = _getLanguageNamed(languageName);
		
		if (language == null) {
			return "No language found named '" + languageName + "'";
		}
		
		List<CountryLanguage> countryLanguages = _getCountryLanguagesForLanguage(language);
		
		if (countryLanguages.isEmpty()) {
			return "No countries found where " + languageName + " is spoken";
		}

		List<Country> countriesWhereLanguageIsSpoken;
		countriesWhereLanguageIsSpoken = _getCountriesForCountryLanguages(countryLanguages);
			
		InfectionService infectionService = infectionPortService.getInfectionServicePort();		
		List<Infection> infections = infectionService.getInfectionsForCountries(countriesWhereLanguageIsSpoken);
			
		if(infections.isEmpty()) {
			return "No zombies found in countries where " + languageName + " is spoken.";
		}
		
		Long zombieCount = 0L;
		for(Infection infection : infections) {
			zombieCount += infection.getZombies();
		}
		
		StringBuilder result = new StringBuilder(zombieCount + " zombies total in countries which speak " + languageName + ": (");
		
		for (Country c : countriesWhereLanguageIsSpoken) {
			result.append(c.getName() + ", ");
		}

		// Strip trailing comma
		return result.substring(0, result.length() - 2) + ")";
	}
	
	// 6
	@WebMethod
	public String getZombiesBasedOnGeoIPLookup()
	{
		MessageContext messageContext = webServiceContext.getMessageContext();
		HttpServletRequest request = (HttpServletRequest)messageContext.get(MessageContext.SERVLET_REQUEST);

		GeoIPServiceSoap geoService = geoIPService.getGeoIPServiceSoap();

		GeoIP geoIP = geoService.getGeoIP(request.getRemoteAddr());
		String countryCode = geoIP.getCountryCode();
		
		CountryService countryService = countryPortService.getCountryServicePort();
		Country country = countryService.getCountryWithCode(countryCode);
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		List<Infection> infections = infectionService.getInfectionsForCountry(country);
		
		Long zombieCount = 0L;
		for(Infection infection : infections) {
			zombieCount += infection.getZombies();
		}
		
		StringBuilder response = new StringBuilder("Your IP: " + request.getRemoteAddr());
		response.append(" - resolved to " + country.getName());
		response.append(" (infected with " + zombieCount + " zombies!)");
		
		return response.toString();
	}

	// #7 
	@WebMethod 
	public List<String> getCountriesWithTheMostZombies(@WebParam(name = "maxResults") Integer maxResults) {
		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countries = countryService.getAllCountries();
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		Map<Country,Integer> infectionsInCountry = new HashMap<Country,Integer>();
		
		for(Country country : countries) {
			List<Infection> infections = infectionService.getInfectionsForCountry(country);
			Integer zombies = 0;
			
			for(Infection infection : infections) {
				zombies += infection.getZombies();
			}
			
			infectionsInCountry.put(country, zombies);
		}
		
		Map<Country,Integer> sortedInfectionsByCountry = 
				new TreeMap<Country,Integer>(new InfectionsInCountryComparator(infectionsInCountry));

		sortedInfectionsByCountry.putAll(infectionsInCountry);
		
		List<String> result = new ArrayList<String>();
		int resultCount = 1;
		for(Entry<Country,Integer> entry : sortedInfectionsByCountry.entrySet()) {
			result.add(entry.getKey().getName() + " has " + entry.getValue() + " zombies");
			
			resultCount++;
			if(maxResults > 0 && resultCount > maxResults) {
				break;
			}
		}
		return result;
	}
	
	// #8
	@WebMethod
	public List<String> getCitiesWithTheMostZombies(@WebParam(name = "maxResults") Integer maxResults) {
		CityService cityService = cityPortService.getCityServicePort();
		CountryService countryService = countryPortService.getCountryServicePort();
		
		List<City> cities = cityService.getAllCities();
		
		// Map each city to its ID
		Map<Integer,City> citiesByCode = new HashMap<Integer,City>();
		for(City city : cities) {
			citiesByCode.put(city.getID(), city);
		}
		
		InfectionService infectionService = infectionPortService.getInfectionServicePort();
		
		List<Infection> infections = infectionService.getAllInfections();
		Collections.sort(infections, new Comparator<Infection>() {
			// Order by number of zombies desc
			public int compare(Infection o1, Infection o2) {
				return o2.getZombies().compareTo(o1.getZombies());
			}
		});
		
		List<String> result = new ArrayList<String>();
		int resultCount = 1;
		for(Infection infection : infections) {
			City infectedCity = cities.get(infection.getCityID());
			Country country = countryService.getCountryWithCode(infectedCity.getCountryCode());
			result.add(infectedCity.getName() + ", " + country.getName() + "(" + country.getContinent() + ") has " + infection.getZombies() + " zombies");
			
			resultCount++;
			if(maxResults > 0 && resultCount > maxResults) {
				break;
			}
		}
		return result;	
	}
	
	// helper methods 

	private Language _getLanguageNamed(String languageName) {
		LanguageService languageService = languagePortService.getLanguageServicePort();
		Language language = languageService.getLanguageWithName(languageName);

		return language;
	}
	
	private List<CountryLanguage> _getCountryLanguagesForLanguage(Language language) {
		CountryLanguageService countryLanguageService = countryLanguagePortService.getCountryLanguageServicePort();
		List<CountryLanguage> countryLanguages = countryLanguageService.getCountryLanguagesForLanguage(language);

		return countryLanguages;
	}
	
	private List<Country> _getCountriesForCountryLanguages(List<CountryLanguage> countryLanguages) {	
		List<String> countryCodes = new ArrayList<String>();

		for(CountryLanguage countryLanguage : countryLanguages) {
			countryCodes.add(countryLanguage.getCountryCode());
		}

		CountryService countryService = countryPortService.getCountryServicePort();
		List<Country> countries = countryService.getCountriesWithCodes(countryCodes);

		return countries;
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

		List<City> allCities = service.getAllCities();
		System.out.println("getAllCities returned " + allCities.size() + " results");
		
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
		
		countryLanguages = clService.getAllCountryLanguages();
		System.out.println("getAllCountryLanguages() returned " + countryLanguages.size() + " result");
		
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
		
		countries = countryService.getAllCountries();
		System.out.println("getAlLCountries() returned " + countries.size() + " results");
		
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
		
		infections = infectionService.getAllInfections();
		System.out.println("getAllInfections() returned " + infections.size() + " results");
		
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
		
		language = languageService.getLanguageWithName("English");
		System.out.println("getLanguageWithName() returned " + language);
		
		languages = languageService.getLanguagesWithNames(Arrays.asList("Cantonese", "Vietnamese"));
		System.out.println("getLanguagesWithNames() returned " + languages.size() + " results");
		
		languages = languageService.getLanguagesInCountry(country);
		System.out.println("getLanguagesInCountry() returned " + languages.size() + " results");
		
		languages = languageService.getLanguagesInCountries(countries);
		System.out.println("getLanguagesInCountries() returned " + languages.size() + " results");
		
		languages = languageService.getAllLanguages();
		System.out.println("getAllLanguages() returned " + languages.size() + " results");
		
		return "woot";
		
	}
	
	private class InfectionsInCountryComparator implements Comparator<Country> {
		
		private Map<Country,Integer> infections;
		
		public InfectionsInCountryComparator(Map<Country,Integer> infections) {
			this.infections = infections;
		}

		public int compare(Country o1, Country o2) {
			return infections.get(o2).compareTo(infections.get(o1));
		}
	}
}
 