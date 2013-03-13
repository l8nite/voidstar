/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.p.opulo.dao.library.Cities;

@Singleton
public class World {

	@Inject
	Cities cities;
	
	public long getPopulation() {
		long worldPopulation = 0;
		for(City city: cities.getAll()) {
			worldPopulation += city.getPopulation();
		}
		return worldPopulation;
	}
}
