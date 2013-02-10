package edu.sjsu.voidstar.project1;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.World;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

public class ZombieInfection {
	private City genesis;
	
	private int infectedWorldPopulation = 0;
	private Set<City> infectedCities = new HashSet<>();
	
	public ZombieInfection() {
		// Sanitize any previous infection
		sanitize();
	
		// Set the genesis city
		initializeGensis();
		
		// begin the infection
		infect(genesis);
	}

	private void initializeGensis() {
		// Select genesis city 
		System.out.println("Choosing random city for virulent strain genesis");
		genesis = City.getRandomCity();
		System.out.println("City chosen: " + genesis.getFullCityName() + "\n");
	}
	
	public Set<City> getInfectedCities() {
		@SuppressWarnings("unchecked")
		List<City> infectedCities = (List<City>) HibernateSession.get()
				.createCriteria(Infection.class)
				.add(Restrictions.gt("zombies", 0))
				.list();		
		
		// Defensively copy the infected cities to an unmodifiable list to prevent stupidity
		this.infectedCities = Collections.unmodifiableSet(new HashSet<>(infectedCities));
		return this.infectedCities;
	}

	public void infect(City city) {
		Infection infectedCity = Infection.forCity(city);
		Integer population = city.getPopulation();
		Integer infected = infectedCity.getZombies();
		String inOrTo = infectedCity.getZombies() == 0 ? "to" : "in";

		// Randomly infect a new number of people
		Random generator = new Random();
		Integer newInfections = (int) (generator.nextDouble() * (population - infected));
		String peoplePerson = newInfections == 1 ? "person" : "people";
		
		System.out.println("The infection spreads " + inOrTo + " " + city.getFullCityName() + "!");
		System.out.println("The virus has infected " + newInfections + " new " + peoplePerson + ".");

		infected += newInfections;
		infectedCity.setZombies(infected);

		// Update the total number of infections to include the new
		infectedWorldPopulation += newInfections;
		infectedCities.add(city);
		
		double percentInfected = (infected * 100.0f) / population;
		System.out.println(String.format("In this city: %d/%d or %.2f%% of the population are infected!%n", infected, population, percentInfected));
		
		// save the infected city data back into the database
		HibernateSession.beginTransaction();
		infectedCity.save();
		HibernateSession.commitTransaction();
	}

	public void reportInfectionProgress() {
		System.out.println("-------------- WORLD NEWS FLASH!!! --------------");
		double percentInfected = (infectedWorldPopulation * 100f) / World.getPopulation();
		
		String citiesOrCity = infectedCities.size() == 1 ? "city has" : "cities have";
		System.out.println(infectedCities.size() + " " + citiesOrCity + " been infected!");
		
		System.out.println(String.format("The world population is %.2f%% infected %n", percentInfected));
		System.out.println("-------------------------------------------------");
	}

	private static void sanitize() {
		System.out.println("Sanitizing infected cities");
		HibernateSession.get().createQuery("delete from Infection")
				.executeUpdate();
	}
}
