package us.opulo.p.simulator;

import java.text.NumberFormat;
import java.util.Locale;

import us.opulo.p.dao.service.query.WorldQueryService;
import us.opulo.p.simulator.modules.random.RandomEpidemicModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Simulator {
	
	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new RandomEpidemicModule());

		WorldQueryService worldService = new WorldQueryService();
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(worldService.getPopulation()));

		System.out.println("Panic! Zombies are coming!");

		ZombieEpidemic zombieEpidemic = injector.getInstance(ZombieEpidemic.class);

		for (int i = 1; i <= 1000; ++i) {	
			zombieEpidemic.spreadInfection();
			
			if (i % 100 == 0) {
				zombieEpidemic.reportInfectionProgress();
				Thread.sleep(2000);
			}
		}
	}
}
