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
package us.p.opulo.project1;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import us.p.opulo.dao.City;
import us.p.opulo.dao.World;
import us.p.opulo.dao.library.DAOLibrary;
import us.p.opulo.guice.CoreModule;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class App {

	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new CoreModule());
		ZombieInfection z = injector.getInstance(ZombieInfection.class);
		DAOLibrary library = injector.getInstance(DAOLibrary.class);
		World world = injector.getInstance(World.class);
		
		// z.reportInfectionProgress();
		z.startInfection();
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(world.getPopulation()));
		System.out.println("Panic! The virus is spreading!");
		Thread.sleep(5000);
		List<City> allCities = library.getCityLibrary().getAll();
		Random r = new Random();
		for (int i = 1; i <= 1000; ++i) {
			z.infect(allCities.get(r.nextInt(allCities.size())));
			if (i % 100 == 0) {
				z.reportInfectionProgress();
				Thread.sleep(5000);
			}
		}
	}
}
