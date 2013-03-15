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
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.constants.Constants.Resources.XML;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.library.DAOLibrary;
import us.opulo.p.guice.CoreModule;
import us.opulo.p.jaxb.marshallers.EntityMarshaller;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generates XML for all HEntity objects persisted in the database. 
 * @author Jason Campos
 */
public class GenerateXml {
	private static final Logger log = LoggerFactory.getLogger(GenerateXml.class);
	
	public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException {
		Injector injector = Guice.createInjector(new CoreModule());
		DAOLibrary library = injector.getInstance(DAOLibrary.class);
		
		// Initialize all the marshallers
		log.info("Intializing marshallers...");
		EntityMarshaller<City> cities = EntityMarshaller.create(City.class);
		EntityMarshaller<Country> countries = EntityMarshaller.create(Country.class);
		EntityMarshaller<CountryLanguage> countryLanguages = EntityMarshaller.create(CountryLanguage.class);
		EntityMarshaller<Infection> infections = EntityMarshaller.create(Infection.class);
		EntityMarshaller<Language> languages = EntityMarshaller.create(Language.class);
		
		// Populate marshal objects
		log.info("Populating marshallers...");
		cities.addAll(library.fetchAll(City.class));
		countries.addAll(library.fetchAll(Country.class));
		countryLanguages.addAll(library.fetchAll(CountryLanguage.class));
		infections.addAll(library.fetchAll(Infection.class));
		languages.addAll(library.fetchAll(Language.class));
		
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
