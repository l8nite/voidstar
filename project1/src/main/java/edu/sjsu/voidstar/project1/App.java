package edu.sjsu.voidstar.project1;

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

		for (int i = 1; i <= 1000; ++i) {
			z.infect(City.getRandom());
			if (i % 100 == 0) {
				z.reportInfectionProgress();
				Thread.sleep(5000);
			}
		}
	}
}
