/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.project1;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import us.opulo.p.dao.City;
import us.opulo.p.dao.library.DAOLibrary;
import us.opulo.p.dao.library.WorldLibrary;
import us.opulo.p.guice.ServerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class App {

	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new ServerModule());
		ZombieInfection z = injector.getInstance(ZombieInfection.class);
		DAOLibrary library = injector.getInstance(DAOLibrary.class);
		WorldLibrary world = injector.getInstance(WorldLibrary.class);
		
		// z.reportInfectionProgress();
		z.startInfection();
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(world.getPopulation()));
		System.out.println("Panic! The virus is spreading!");
		Thread.sleep(5000);
		List<City> allCities = library.getCityLibrary().getAllCities();
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
