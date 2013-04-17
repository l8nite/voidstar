package us.opulo.p.core;

import java.text.NumberFormat;
import java.util.Locale;

import us.opulo.p.dao.service.query.WorldQueryService;
import us.opulo.p.hibernate.SessionManager;
import us.opulo.p.modules.random.RandomInfectionModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector(new RandomInfectionModule());
		WorldQueryService worldService = new WorldQueryService();
		sanitize();
		
		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(worldService.getPopulation()));
		ZombieInfection zombieInfection = injector.getInstance(ZombieInfection.class);
		
		System.out.println("Panic! The virus is spreading!");

		for (int i = 1; i <= 1000; ++i) {	
			zombieInfection.spreadInfection();
			if (i % 100 == 0) {
				zombieInfection.reportInfectionProgress();
				Thread.sleep(2000);
			}
		}
	}
	
	private static void sanitize() {
		System.out.println("Sanitizing infected cities");
		SessionManager.get().createQuery("delete from Infection")
				.executeUpdate();
	}
}
