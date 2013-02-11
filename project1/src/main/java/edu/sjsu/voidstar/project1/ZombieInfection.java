package edu.sjsu.voidstar.project1;

import java.util.ArrayList;
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

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.google.common.base.Joiner;

import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project1.dao.World;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

public class ZombieInfection {
	private City genesis;
	
	private int infectedWorldPopulation = 0;
	private Set<City> infectedCities = new HashSet<>();
	
	public ZombieInfection() {
	}
	
	public void startInfection() {
		sanitize();
		initializeGenesis();
		infect(genesis);
	}

	private void initializeGenesis() {
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
		String inOrTo = infected == 0 ? "to" : "in";

		// Randomly infect a new number of people
		Random generator = new Random();
		Integer newInfections = infected + (int) (generator.nextDouble() * (population - infected));;
		
		// cap # of newInfections at remaining healthy population 
		if (newInfections + infected > population) {
			newInfections = population - infected;
		}

		String peoplePerson = newInfections == 1 ? "person" : "people";
		
		System.out.println("The infection spreads " + inOrTo + " " + city.getFullCityName() + "!");
		System.out.println("The virus has infected " + newInfections + " new " + peoplePerson + ".");

		infected += newInfections;
		infectedCity.setZombies(infected);

		// Update the total number of infections to include the new
		infectedWorldPopulation += newInfections;
		infectedCities.add(city);
		
		double percentInfected = (infected * 100.0f) / population;
		System.out.println(String.format("In this city: %d/%d (%.2f%%) of the population is infected!%n", infected, population, percentInfected));
		
		// save the infected city data back into the database
		HibernateSession.beginTransaction();
		infectedCity.save();
		HibernateSession.commitTransaction();
	}

	public void reportInfectionProgress() {
		System.out.println("-------------- WORLD NEWS FLASH!!! --------------");
		reportPopulationInfected();
		reportInfectedCountries();
		//reportTopLanguages();		
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
		
		
		for(Entry<Country,Float> infectedCountry: getSortedInfectionsByCountry().entrySet()) {
			Country country = infectedCountry.getKey();
			Float infectionPercentage = infectedCountry.getValue();
			List<Language> popularLanguages = country.getMostPopularLanguages();
			List<String> popularLanguageNames = new ArrayList<String>();
			for (Language l : popularLanguages) {
				popularLanguageNames.add(l.getLanguage());
			}

			System.out.println(String.format("% 3.2f%% - %s (%s)", infectionPercentage, country, Joiner.on(", ").join(popularLanguageNames)));
			
			if(--countriesToDisplay == 0) {
				break;
			}
		}
		
		System.out.println();
	}
	
	private TreeMap<Country,Float> getSortedInfectionsByCountry() {
		@SuppressWarnings("unchecked")
		// get all countries and their associated populations (infected, total)
		List<Object[]> rawCountryInfections = (List<Object[]>) HibernateSession.get()
				.createCriteria(City.class, "city")
				.createAlias("country",  "country", Criteria.LEFT_JOIN)
				.createAlias("city.infection", "infection", Criteria.LEFT_JOIN)
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("country"))
						.add(Projections.sum("infection.zombies").as("infectedPopulation"))
						.add(Projections.sum("city.population").as("totalPopulation"))
				)
				.list();
		
		// Add the results to an unsorted map that can be used to build a comparator
		Map<Country,Float> unsortedCountryInfections = new HashMap<Country,Float>();
		for (Object[] o : rawCountryInfections) {
			Country country = (Country) o[0];
			Long infectedPopulation = (Long)o[1];
			if (infectedPopulation == null) { 
				infectedPopulation = 0L;
			}
			Long totalPopulation = (Long)o[2];
			Float percentInfected = infectedPopulation * 1.0f / totalPopulation * 100.0f; 
			unsortedCountryInfections.put(country,percentInfected);
		}

		// Add to sorted map
		TreeMap<Country,Float> sortedCountryInfections = new TreeMap<>( new InfectionPercentagePerCountryComparator(unsortedCountryInfections));
		sortedCountryInfections.putAll(unsortedCountryInfections);
		
		// API vs Stupid-proof... return a tree map instead of an unmodifiable in order to 
		// give the implication that the resulting map is sorted.
		return sortedCountryInfections;
	}
	
	private void reportTopLanguages() {
		System.out.println("World's Popular Languages: ");		
		int languagesToDisplay = 3;
		
		for(Entry<Language,Long> infectedLanguage: Language.getSortedMostSpoken().entrySet()) {
			Language language = infectedLanguage.getKey();
			long speakers = infectedLanguage.getValue();
			long infectedSpeakersWorldwide = 0L;
			
			// Calculate an estimated number of speakers remaining in the world
			List<CountryLanguage> countryLanguages = CountryLanguage.get(language);
			Map<Country,Double> speakersInfectedByCountry = new HashMap<>();
			
			for(CountryLanguage cl : countryLanguages) {
				// number of infected speakers is the number of infected in the country * percentage of speakers of the language
				// TODO: would be better to query for all countries at once instead of one at a time
				Country country = cl.getCountry();
				long infectedInCountry = getNumberInfected(country);
				double speakersInCountry = country.getPopulation() * (cl.getPercentage() / 100);
				double estSpeakersInfected = infectedInCountry * ( cl.getPercentage() / 100);
				double estPercentInfected = 100.0 * (estSpeakersInfected / speakersInCountry);
				
				// It is possible for more than 100% to be infected since this is only an estimate
				if (estPercentInfected > 100) {
					estPercentInfected = 100;
				}
					
				if(Double.isNaN(estPercentInfected)) {
					estPercentInfected = 0;
				}
				
				speakersInfectedByCountry.put(country, estPercentInfected);
				infectedSpeakersWorldwide += estSpeakersInfected;
			}
			
			double percentInfectedWorldwide = 100.0 * (infectedSpeakersWorldwide / speakers);
			System.out.println(String.format(language.toString().toUpperCase() + " %.2f%% infected worldwide", percentInfectedWorldwide));
			
			for(Entry<Country,Double> r : speakersInfectedByCountry.entrySet()) {
				System.out.println(String.format("%s - %.2f%% of speakers infected", r.getKey(), r.getValue()));	
			}
			
			System.out.println();
			
			if(--languagesToDisplay == 0) {
				break;
			}
		}
		
		System.out.println();
	}

	private long getNumberInfected(Country country) {
		Long infections = (Long) HibernateSession.get()
				.createCriteria(Infection.class)
				.createAlias("city", "city")
				.createAlias("city.country", "country")
				.add(Restrictions.eq("city.country", country))
				.setProjection(Projections.sum("zombies"))
				.uniqueResult();
		
		return infections != null ? infections : 0L;
	}

	private static void sanitize() {
		System.out.println("Sanitizing infected cities");
		HibernateSession.get().createQuery("delete from Infection")
				.executeUpdate();
	}
	
	private class InfectionPercentagePerCountryComparator implements Comparator<Country> {
		
		Map<Country,Float> zombiesPerCountry;
		
		public InfectionPercentagePerCountryComparator(Map<Country, Float> unsortedCountryInfections) {
			this.zombiesPerCountry = unsortedCountryInfections;
		}

		@Override
		public int compare(Country o1, Country o2) {
			return zombiesPerCountry.get(o2).compareTo(zombiesPerCountry.get(o1));
		}
	}
}
