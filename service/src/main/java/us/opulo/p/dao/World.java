/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.opulo.p.dao.library.DAOLibrary;

/**
 * Representation of all cities and countries in the world. This class is not persistent but rather 
 * provides convenience aggregation methods for all cities and/or countries.
 * 
 * @author Jason Campos, Shaun Guth
 */
@Singleton
public class World {

	@Inject
	private DAOLibrary library;
	
	/**
	 * @return The total number of people in the world.
	 */
	public long getPopulation() {
		long worldPopulation = 0;
		for(City city: library.getCityLibrary().getAllCities()) {
			worldPopulation += city.getPopulation();
		}
		return worldPopulation;
	}
}
