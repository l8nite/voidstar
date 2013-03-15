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

@Singleton
public class World {

	@Inject
	DAOLibrary library;
	
	public long getPopulation() {
		long worldPopulation = 0;
		for(City city: library.getCityLibrary().getAllCities()) {
			worldPopulation += city.getPopulation();
		}
		return worldPopulation;
	}
}
