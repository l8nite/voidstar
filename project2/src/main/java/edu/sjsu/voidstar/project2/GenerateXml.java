package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.constants.Constants.Files.XML;
import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project1.hibernate.HibernateService;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityMarshaller;
import edu.sjsu.voidstar.project2.jaxb.tables.Cities;
import edu.sjsu.voidstar.project2.jaxb.tables.Countries;
import edu.sjsu.voidstar.project2.jaxb.tables.CountryLanguages;
import edu.sjsu.voidstar.project2.jaxb.tables.Infections;
import edu.sjsu.voidstar.project2.jaxb.tables.Languages;

/**
 * Generates XML for all HEntity objects persisted in the database. 
 * @author Jason Campos
 */
public class GenerateXml {
	private static final Logger log = LoggerFactory.getLogger(GenerateXml.class);
	
	public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException {
		
		// Initialize all the marshallers
		log.info("Intializing marshallers...");
		EntityMarshaller<City> cities = EntityMarshaller.create(Cities.class);
		EntityMarshaller<Country> countries = EntityMarshaller.create(Countries.class);
		EntityMarshaller<CountryLanguage> countryLanguages = EntityMarshaller.create(CountryLanguages.class);
		EntityMarshaller<Infection> infections = EntityMarshaller.create(Infections.class);
		EntityMarshaller<Language> languages = EntityMarshaller.create(Languages.class);
		
		// Populate marshal objects
		log.info("Populating marshallers...");
		cities.addAll(HibernateService.fetchAll(City.class));
		countries.addAll(HibernateService.fetchAll(Country.class));
		countryLanguages.addAll(HibernateService.fetchAll(CountryLanguage.class));
		infections.addAll(HibernateService.fetchAll(Infection.class));
		languages.addAll(HibernateService.fetchAll(Language.class));
		
		// Setup output files
		log.info("Initializing XML files...");
		File fCities = new File(XML.CITIES);
		File fCountries = new File(XML.COUNTRIES);
		File fCountryLanguages = new File(XML.COUNTRY_LANGUAGES);
		File fInfections = new File(XML.INFECTIONS);
		File fLanguages = new File(XML.LANGUAGES);
		
		// Create files if they do not exist
		if (!fCities.exists()) {
			log.info("Creating file: " + XML.CITIES);
			fCities.createNewFile();
		}
		
		if (!fCountries.exists()) {
			log.info("Creating file: " + XML.COUNTRIES);
			fCountries.createNewFile();
		}
		
		if (!fCountryLanguages.exists()) {
			log.info("Creating file: " + XML.COUNTRY_LANGUAGES);
			fCountryLanguages.createNewFile();
		}
		
		if (!fInfections.exists()) {
			log.info("Creating file: " + XML.INFECTIONS);
			fInfections.createNewFile();
		}
		
		if (!fLanguages.exists()) {
			log.info("Creating file: " + XML.LANGUAGES);
			fLanguages.createNewFile();
		}
		
		// Marshal to the XML files
		log.info("Marshalling output to files...");
		cities.marshal(new FileOutputStream(fCities));
		countries.marshal(new FileOutputStream(fCountries));
		countryLanguages.marshal(new FileOutputStream(fCountryLanguages));
		infections.marshal(new FileOutputStream(fInfections));
		languages.marshal(new FileOutputStream(fLanguages));
		
		log.info("Marshalling complete!");
	}
}
