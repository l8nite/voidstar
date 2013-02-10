package edu.sjsu.voidstar.project1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
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
		reportPopulationInfected();
		reportInfectedCountries();
		reportFavoriteLanguages();		
		System.out.println("-------------------------------------------------");
	}

	private void reportPopulationInfected() {
		double percentInfected = (infectedWorldPopulation * 100f) / World.getPopulation();
		String citiesOrCity = infectedCities.size() == 1 ? "city has" : "cities have";
		System.out.println(infectedCities.size() + " " + citiesOrCity + " been infected!");
		System.out.println(String.format("The world population is %.2f%% infected %n", percentInfected));
	}
	
	private void reportInfectedCountries() {
		System.out.println("Most Infected Countries: ");		
		int countriesToDisplay = 5;
		
		
		for(Entry<Country,Long> infectedCountry: getSortedInfectionsByCountry().entrySet()) {
			Country country = infectedCountry.getKey();
			Long infections = infectedCountry.getValue();
			System.out.println(String.format("%s - %d infections", country, infections));
			
			if(--countriesToDisplay == 0) {
				break;
			}
		}
		
		System.out.println();
	}
	
	private TreeMap<Country,Long> getSortedInfectionsByCountry() {
		// Query the database for top zombies/country
		@SuppressWarnings("unchecked")
		List<Object[]> rawCountryInfections = (List<Object[]>) HibernateSession.get()
				.createCriteria(Infection.class)
				.createAlias("city", "city")
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("city.country"))
						.add(Projections.sum("zombies").as("zombieCount")))
				.addOrder(Order.desc("zombieCount"))
				.setMaxResults(5)
				.list();
		
		// Add the results to an usorted map that can be used to build a comparator
		Map<Country,Long> unsortedCountryInfections = new HashMap<Country,Long>();
		for (Object[] o : rawCountryInfections) {
			Country c = (Country) o[0];
			Long i = (Long) o[1];
			unsortedCountryInfections.put(c,i);
		}

		// Add to sorted map
		TreeMap<Country,Long> sortedCountryInfections = new TreeMap<>( new ZombiesPerCountryComparator(unsortedCountryInfections));
		sortedCountryInfections.putAll(unsortedCountryInfections);
		
		// API vs Stupid-proof... return a tree map instead of an unmodifiable in order to 
		// give the implication that the resulting map is sorted.
		return sortedCountryInfections;
	}
	
	private void reportFavoriteLanguages() {
		System.out.println("Zombies Favorite Languages: ");		
		int languagesToDisplay = 5;
		
		for(Entry<Language,Long> infectedLanguage: getSortedInfectionsByLanguage().entrySet()) {
			Language language = infectedLanguage.getKey();
			long infections = infectedLanguage.getValue();
			
			long languageSpeakers = Language.getSpeakers();
			
			System.out.println(String.format("%s - %d infected, %d remaining speakers", language, infections, languageSpeakers - infections));
			if(--languagesToDisplay == 0) {
				break;
			}
		}
		
		System.out.println();
	}

	private TreeMap<Language,Long> getSortedInfectionsByLanguage() {
		//TODO
		return new TreeMap<>();
	}


	private static void sanitize() {
		System.out.println("Sanitizing infected cities");
		HibernateSession.get().createQuery("delete from Infection")
				.executeUpdate();
	}
	
	private class ZombiesPerCountryComparator implements Comparator<Country> {
		
		Map<Country,Long> zombiesPerCountry;
		
		public ZombiesPerCountryComparator(Map<Country,Long> zombiesPerCountry) {
			this.zombiesPerCountry = zombiesPerCountry;
		}

		@Override
		public int compare(Country o1, Country o2) {
			// - to sort descending
			return -(zombiesPerCountry.get(o1).compareTo(zombiesPerCountry.get(o2)));
		}
	}
}
