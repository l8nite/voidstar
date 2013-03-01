package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.constants.Constants.Files.XML;
import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project1.hibernate.HibernateService;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityUnmarshaller;

/**
 * Populates the database with the objects unmarshalled from the XML files.
 * 
 * @author Jason Campos
 */
public class Populate {
	private static final Logger log = LoggerFactory.getLogger(Populate.class);

	public static void main(String... args) throws JAXBException, IOException {

		// Each table needs its own unmarshaller
		log.info("Preparing unmarshallers...");
		EntityUnmarshaller<City> uCities = EntityUnmarshaller
				.create(City.class);
		EntityUnmarshaller<Country> uCountries = EntityUnmarshaller
				.create(Country.class);
		EntityUnmarshaller<CountryLanguage> uCountryLanguages = EntityUnmarshaller
				.create(CountryLanguage.class);
		EntityUnmarshaller<Infection> uInfections = EntityUnmarshaller
				.create(Infection.class);
		EntityUnmarshaller<Language> uLanguages = EntityUnmarshaller
				.create(Language.class);

		// Set up file objects
		log.info("Loading XML...");
		File fCities = new File(XML.CITIES);
		File fCountries = new File(XML.COUNTRIES);
		File fCountryLanguages = new File(XML.COUNTRY_LANGUAGES);
		File fInfections = new File(XML.INFECTIONS);
		File fLanguages = new File(XML.LANGUAGES);

		// Perform the unmarshal step
		log.info("Creating unmarshallers...");
		List<City> cities = uCities.unmarshall(fCities);
		List<Country> countries = uCountries.unmarshall(fCountries);
		List<CountryLanguage> countryLanguages = uCountryLanguages
				.unmarshall(fCountryLanguages);
		List<Infection> infections = uInfections.unmarshall(fInfections);
		List<Language> languages = uLanguages.unmarshall(fLanguages);

		log.info("Establishing connection...");
		
		// populate tables
		HibernateSession.get();
		HibernateSession.beginTransaction();

		// Delete existing table data to avoid constraint violations
		System.out.println("WARNING: About to drop all table data... press ENTER to continue, ^C to quit.");
		System.in.read();
		HibernateService.deleteAll(City.class);
		HibernateService.deleteAll(Country.class);
		HibernateService.deleteAll(CountryLanguage.class);
		HibernateService.deleteAll(Infection.class);
		HibernateService.deleteAll(Language.class);

		try {
			// Save the entities
			log.info("Saving countries...");
			for (Country country : countries) {
				country.save();
			}
			log.info("Countries saved!");

			log.info("Saving languages...");
			for (Language language : languages) {
				language.save();
			}
			log.info("Languages saved!");

			log.info("Saving cities...");
			for (City city : cities) {
				city.save();
			}
			log.info("Cities saved!");

			log.info("Saving CountryLanguages...");
			for (CountryLanguage countryLanguage : countryLanguages) {
				countryLanguage.save();
			}
			log.info("CountryLanguages saved!");

			log.info("Saving infections...");
			for (Infection infection : infections) {
				infection.save();
			}

			log.info("Committing transaction...");
			HibernateSession.commitTransaction();
			log.info("Complete!");
		} catch (Exception e) {
			HibernateSession.rollbackTransaction();
			log.error(e.getMessage(), e);
		}
	}
}
