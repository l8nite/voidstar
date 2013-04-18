package us.opulo.p.core;

import java.text.NumberFormat;
import java.util.Locale;

import us.opulo.p.dao.service.query.WorldQueryService;
import us.opulo.p.modules.random.RandomInfectionModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new RandomInfectionModule());

		WorldQueryService worldService = new WorldQueryService();
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(worldService.getPopulation()));

		System.out.println("Panic! Zombies are coming!");

		ZombieInfection zombieInfection = injector.getInstance(ZombieInfection.class);

		for (int i = 1; i <= 1000; ++i) {	
			zombieInfection.spreadInfection();
			
			if (i % 100 == 0) {
				zombieInfection.reportInfectionProgress();
				Thread.sleep(2000);
			}
		}
	}
}
