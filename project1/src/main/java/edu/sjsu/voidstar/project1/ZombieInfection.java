package edu.sjsu.voidstar.project1;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

public class ZombieInfection {
	private City genesis;

	private Long worldPopulation;
	private Integer infectedWorldPopulation = 0;

	public City getGenesisCity() {
		this.sanitize();
		List<City> allCities = City.getCities();

		System.out.println("World population: " + NumberFormat.getNumberInstance(Locale.US).format(allCities.size()));

		// get a random City record from the City table
		System.out.println("Choosing random city for virulent strain genesis");

		Random r = new Random();
		genesis = allCities.get(r.nextInt(allCities.size()));

		System.out.println("City chosen: " + genesis.getFullCityName() + "\n");

		return genesis;
	}

	public void infect(City city) {
		Infection infection = Infection.forCity(city);

		String inOrTo = infection.getZombies() == 0 ? "to" : "in";

		System.out.println("The infection spreads " + inOrTo + " "
				+ city.getFullCityName() + "!");

		Integer population = city.getPopulation();
		Integer infected = infection.getZombies();

		Random generator = new Random();
		Integer newInfections = (int) (generator.nextDouble() * (population - infected));
		String peoplePerson = newInfections == 1 ? "person" : "people";
		System.out.println("The virus has infected " + newInfections + " new "
				+ peoplePerson + ".");

		infected += newInfections;
		infectedWorldPopulation += newInfections;

		infection.setZombies(infected);
		Integer percentInfected = (int)(infected * 100.0f / population);
		System.out.println("In this city: " + infected + "/" + population
				+ " or " + percentInfected
				+ "% of the population are infected!\n");

		// save the infected city data back into the database
		HibernateSession.beginTransaction();
		infection.save();
		HibernateSession.commitTransaction();
	}

	public void reportInfectionProgress() {
		System.out.println("-------------- WORLD NEWS FLASH!!! --------------");
		Integer percentInfected = (int)(infectedWorldPopulation * 100.0f / worldPopulation);

		Criteria criteria = HibernateSession.get().createCriteria(
				Infection.class);
		criteria.add(Restrictions.gt("zombies", 0));
		criteria.setProjection(Projections.projectionList().add(
				Projections.countDistinct("city.id")));
		Long citiesInfected = (Long) criteria.uniqueResult();

		String citiesOrCity = citiesInfected == 1 ? "city has" : "cities have";
		System.out.println(citiesInfected + " " + citiesOrCity
				+ " been infected!");
		System.out.println("The world population is " + percentInfected
				+ "% infected!");
		System.out.println("-------------------------------------------------");
	}

	private void sanitize() {
		System.out.println("Sanitizing infected cities");
		HibernateSession.get().createQuery("delete from Infection")
				.executeUpdate();
	}
}
