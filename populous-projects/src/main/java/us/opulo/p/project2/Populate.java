/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.project2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.constants.Constants.Resources.XML;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.library.DAOLibrary;
import us.opulo.p.guice.ServerModule;
import us.opulo.p.hibernate.HibernateSession;
import us.opulo.p.jaxb.marshallers.EntityUnmarshaller;

import com.google.inject.Guice;
import com.google.inject.Injector;

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
		EntityUnmarshaller<City> uCities = EntityUnmarshaller.create(City.class);
		EntityUnmarshaller<Country> uCountries = EntityUnmarshaller.create(Country.class);
		EntityUnmarshaller<CountryLanguage> uCountryLanguages = EntityUnmarshaller.create(CountryLanguage.class);
		EntityUnmarshaller<Infection> uInfections = EntityUnmarshaller.create(Infection.class);
		EntityUnmarshaller<Language> uLanguages = EntityUnmarshaller.create(Language.class);

		// Set up file objects
		log.info("Loading XML...");
		File fCities = new File(XML.CITIES);
		File fCountries = new File(XML.COUNTRIES);
		File fCountryLanguages = new File(XML.COUNTRY_LANGUAGES);
		File fInfections = new File(XML.INFECTIONS);
		File fLanguages = new File(XML.LANGUAGES);

		// Perform the unmarshal step
		log.info("Creating unmarshallers...");
		List<City> cities = uCities.unmarshal(fCities);
		List<Country> countries = uCountries.unmarshal(fCountries);
		List<CountryLanguage> countryLanguages = uCountryLanguages.unmarshal(fCountryLanguages);
		List<Infection> infections = uInfections.unmarshal(fInfections);
		List<Language> languages = uLanguages.unmarshal(fLanguages);

		log.info("Establishing connection...");
		
		Injector injector = Guice.createInjector(new ServerModule());
		HibernateSession session = injector.getInstance(HibernateSession.class);
		DAOLibrary library = injector.getInstance(DAOLibrary.class);
		
		// populate tables
		session.get();
		session.beginTransaction();

		// Delete existing table data to avoid constraint violations
		log.warn("About to drop all table data... press ENTER to continue, ^C to quit.");
		System.in.read();
		
		library.resetDatabase();

		try {
			// Save the entities
			log.info("Saving countries...");
			for (Country country : countries) {
				session.save(country);
			}
			log.info("Countries saved!");

			log.info("Saving languages...");
			for (Language language : languages) {
				session.save(language);
			}
			log.info("Languages saved!");

			log.info("Saving cities...");
			for (City city : cities) {
				session.save(city);
			}
			log.info("Cities saved!");

			log.info("Saving CountryLanguages...");
			for (CountryLanguage countryLanguage : countryLanguages) {
				session.save(countryLanguage);
			}
			log.info("CountryLanguages saved!");

			log.info("Saving infections...");
			for (Infection infection : infections) {
				session.save(infection);
			}

			log.info("Committing transaction...");
			session.commitTransaction();
			log.info("Complete!");
		} catch (Exception e) {
			session.rollbackTransaction();
			log.error(e.getMessage(), e);
		}
	}
}
