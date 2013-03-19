/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.library;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.Table;

import us.opulo.p.dao.HEntity;
import us.opulo.p.hibernate.HibernateSession;
import us.opulo.p.util.Assertions;

@Singleton
public class DAOLibrary {

	@Inject private CityLibrary cityLib;
	@Inject private CountryLanguageLibrary countryLanguageLib;
	@Inject private CountryLibrary countryLib;
	@Inject private InfectionLibrary infectionLib;
	@Inject private LanguageLibrary languageLib;
	
	@Inject private HibernateSession session;
	
	public CityLibrary getCityLibrary() {
		return cityLib;
	}
	
	public CountryLanguageLibrary getCountryLanguageLibrary() {
		return countryLanguageLib;
	}
	
	public CountryLibrary getCountryLibrary() {
		return countryLib;
	}
	
	public InfectionLibrary getInfectionLibrary() {
		return infectionLib;
	}
	
	public LanguageLibrary getLanguageLibrary() {
		return languageLib;
	}
	
	/**
	 * Fetches all entities from the database for the argument entityClass.
	 * @param entityClass
	 * @return A list of all persisted objects matching the argument entityClass.
	 */
	@SuppressWarnings("unchecked")
	public <T extends HEntity> List<T> fetchAll(Class<T> entityClass) {
		return session.get()
				.createCriteria(entityClass)
				.list();
	}
	
	/**
	 * Deletes all entities in the database for the argument class.
	 * @param entityClass The entity class which should have all entries from the database removed.
	 * @return The number of deleted entries
	 */
	public <T extends HEntity> int deleteAll(Class<T> entityClass) {
		Assertions.assertAnnotationPresent(entityClass,Table.class);
		
		String tableName = entityClass.getAnnotation(Table.class).name();
		return session.get()
				.createQuery("delete from " + tableName)
				.executeUpdate();
	}

	/**
	 * Deletes all rows from the database for every entity class loaded from the configuration.
	 */
	public void resetDatabase() {
		for(Class<? extends HEntity> c : session.getConfig().getClasses()) {
			deleteAll(c);
		}
	}
}
