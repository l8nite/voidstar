package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import edu.sjsu.voidstar.constants.Constants.Files.XML;
import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityUnmarshaller;
import edu.sjsu.voidstar.project2.jaxb.tables.Cities;
import edu.sjsu.voidstar.project2.jaxb.tables.Countries;
import edu.sjsu.voidstar.project2.jaxb.tables.CountryLanguages;
import edu.sjsu.voidstar.project2.jaxb.tables.Infections;
import edu.sjsu.voidstar.project2.jaxb.tables.Languages;

public class Populate {

	public static void main(String ... args) throws JAXBException, FileNotFoundException {
		
		// Each table needs its own unmarshaller
		EntityUnmarshaller<Cities> uCities = new EntityUnmarshaller<>(Cities.class);
		EntityUnmarshaller<Countries> uCountries = new EntityUnmarshaller<>(Countries.class);
		EntityUnmarshaller<CountryLanguages> uCountryLanguages = new EntityUnmarshaller<>(CountryLanguages.class);
		EntityUnmarshaller<Infections> uInfections = new EntityUnmarshaller<>(Infections.class);
		EntityUnmarshaller<Languages> uLanguages = new EntityUnmarshaller<>(Languages.class);
		
		// Set up file objects 
		File fCities = new File(XML.CITIES);
		File fCountries = new File(XML.COUNTRIES);
		File fCountryLanguages = new File(XML.COUNTRY_LANGUAGES);
		File fInfections = new File(XML.INFECTIONS);
		File fLanguages = new File(XML.LANGUAGES);
		
		// Perform the unmarshal step
		Cities cities = uCities.unmarshall(fCities);
		Countries countries = uCountries.unmarshall(fCountries);
		CountryLanguages countryLanguages = uCountryLanguages.unmarshall(fCountryLanguages);
		Infections infections = uInfections.unmarshall(fInfections);
		Languages languages = uLanguages.unmarshall(fLanguages);
		
		HibernateSession.get();
		HibernateSession.beginTransaction();
		try {
			// Save the entities
			for (City city : cities.getEntities()) { 
				city.save();
			}
			
			for (Country country: countries.getEntities()) {
				country.save();
			}
			
			for (CountryLanguage countryLangauge : countryLanguages.getEntities()) {
				countryLangauge.save();
			}
			
			for (Infection infection : infections.getEntities()) {
				infection.save();
			}
			
			for (Language language : languages.getEntities()) { 
				language.save();
			}
			
			HibernateSession.commitTransaction();
		} catch (Exception e){
			HibernateSession.rollbackTransaction();
			System.err.print(e);
		}
	}
}
