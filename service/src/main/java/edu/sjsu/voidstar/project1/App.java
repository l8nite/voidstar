package edu.sjsu.voidstar.project1;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.World;
import edu.sjsu.voidstar.guice.CoreModule;


public class App {

	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new CoreModule());
		ZombieInfection z = injector.getInstance(ZombieInfection.class);
		
		// z.reportInfectionProgress();
		z.startInfection();
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(World.getPopulation()));
		System.out.println("Panic! The virus is spreading!");
		Thread.sleep(5000);
		List<City> allCities = City.getCities();
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
