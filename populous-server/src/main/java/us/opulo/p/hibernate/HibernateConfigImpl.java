/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.HEntity;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.InfectionEvent;
import us.opulo.p.dao.InfectionEventDate;
import us.opulo.p.dao.InfectionEventDetail;
import us.opulo.p.dao.Language;
import us.opulo.p.util.Assertions;

/**
 * Contains configuration data for the Hibernate connection. 
 *
 * @author Jason Campos
 */
public class HibernateConfigImpl implements HibernateConfig {
	
	private static final Logger log = LoggerFactory.getLogger(HibernateConfigImpl.class);
	
	/**
	 * @return A list of classes that map to Hibernate entitities
	 */
	public List<Class<? extends HEntity>> getClasses() {
		List<Class<? extends HEntity>> entityClasses = new ArrayList<>();
		entityClasses.add(Country.class);
		entityClasses.add(City.class);
		entityClasses.add(CountryLanguage.class);
		entityClasses.add(Language.class);
		entityClasses.add(Infection.class);
		entityClasses.add(InfectionEvent.class);
		entityClasses.add(InfectionEventDetail.class);
		entityClasses.add(InfectionEventDate.class);
		verifyClassesAreAnnotated(entityClasses);
		return entityClasses;
	}
	
	/**
	 * @return Configuration properties for Hibernate.
	 */
	public Properties getProperties(){
		Properties properties = new Properties();
		
		InputStream input = null;
		try {
			input = getClass().getResource("/db.credentials").openStream();
			properties.load(input);
		} catch (IOException e) {
			log.error("Could not load database configuration file 'db.credentials'.", e);
			throw new RuntimeException(e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
		properties.put("hibernate.show.sql", true);
		return properties;
	}
	
	/*
	 * (non-Javadoc)
	 * Verifies that the argument classes contain the @Entity annotation
	 */
	private void verifyClassesAreAnnotated(List<Class<? extends HEntity>> entityClasses) {
		for(Class<? extends HEntity> entityClass : entityClasses) {
			Assertions.assertAnnotationPresent(entityClass, javax.persistence.Entity.class);
		}
	}
}
