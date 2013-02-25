package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * Populates the database with the objects unmarshalled from the XML files.
 * @author Jason Campos
 */
public class Populate {
	private static final Logger log = LoggerFactory.getLogger(Populate.class);
	
	public static void main(String ... args) throws JAXBException, FileNotFoundException {
		
		// Each table needs its own unmarshaller
		log.info("Preparing unmarshallers...");
		EntityUnmarshaller<Cities> uCities = new EntityUnmarshaller<>(Cities.class);
		EntityUnmarshaller<Countries> uCountries = new EntityUnmarshaller<>(Countries.class);
		EntityUnmarshaller<CountryLanguages> uCountryLanguages = new EntityUnmarshaller<>(CountryLanguages.class);
		EntityUnmarshaller<Infections> uInfections = new EntityUnmarshaller<>(Infections.class);
		EntityUnmarshaller<Languages> uLanguages = new EntityUnmarshaller<>(Languages.class);
		
		// Set up file objects 
		log.info("Loading XML...");
		File fCities = new File(XML.CITIES);
		File fCountries = new File(XML.COUNTRIES);
		File fCountryLanguages = new File(XML.COUNTRY_LANGUAGES);
		File fInfections = new File(XML.INFECTIONS);
		File fLanguages = new File(XML.LANGUAGES);
		
		// Perform the unmarshal step
		log.info("Creating unmarshallers...");
		Cities cities = uCities.unmarshall(fCities);
		Countries countries = uCountries.unmarshall(fCountries);
		CountryLanguages countryLanguages = uCountryLanguages.unmarshall(fCountryLanguages);
		Infections infections = uInfections.unmarshall(fInfections);
		Languages languages = uLanguages.unmarshall(fLanguages);
		
		log.info("Establishing connection...");
		HibernateSession.get();
		HibernateSession.beginTransaction();
		try {			
			// Save the entities 
			log.info("Saving countries...");
			for (Country country: countries.getEntities()) {
				country.save();
			}
			log.info("Countries saved!");
			
			log.info("Saving languages...");
			for (Language language : languages.getEntities()) {
				language.save();
			}
			log.info("Languages saved!");
			
			log.info("Saving cities...");
			for (City city : cities.getEntities()) {
				city.save();
			}
			log.info("Cities saved!");
			
			log.info("Saving CountryLanguages...");
			for (CountryLanguage countryLanguage : countryLanguages.getEntities()) {
				countryLanguage.save();
			}
			log.info("CountryLanguages saved!");
			
			log.info("Saving infections...");
			for (Infection infection : infections.getEntities()) {
				infection.save();
			}
		
			log.info("Committing transaction...");
			HibernateSession.commitTransaction();
			log.info("Complete!");
		} catch (Exception e){
			HibernateSession.rollbackTransaction();
			log.error(e.getMessage(), e);
		}	
	}
}
