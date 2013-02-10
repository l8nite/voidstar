package edu.sjsu.voidstar.project1;

import java.util.List;
import java.util.Random;

import edu.sjsu.voidstar.project1.dao.City;

/**
 * Hello world!
 * 
 */
public class App {

	public static void main(String[] args) throws InterruptedException {				
		ZombieInfection z = new ZombieInfection();
		
		City genesis = z.getGenesisCity();
		z.infect(genesis);
		
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
