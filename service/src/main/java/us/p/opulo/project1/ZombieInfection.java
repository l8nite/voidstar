/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.World;
import us.p.opulo.dao.library.DAOLibrary;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

import com.google.common.base.Joiner;

public class ZombieInfection {
	private City genesis;
	
	private int infectedWorldPopulation = 0;
	private Set<City> infectedCities = new HashSet<>();
	
	@Inject
	@HibernateService
	InfectionService infectionService;
	
	@Inject
	@HibernateService
	CountryLanguageService countryLanguageService;
	
	@Inject
	private HibernateSession session;
	
	@Inject 
	DAOLibrary library;
	
	@Inject World world;
	
	public ZombieInfection() {
	}
	
	public void startInfection() {
		sanitize();
		initializeGenesis();
		infect(genesis);
	}

	private void initializeGenesis() {
		System.out.println("Choosing random city for virulent strain genesis");
		genesis = library.getCityLibrary().getRandomCity();
		System.out.println("City chosen: " + genesis + "\n");
	}
	
	public Set<City> getInfectedCities() {
		@SuppressWarnings("unchecked")
		List<City> infectedCities = (List<City>) session.get()
				.createCriteria(Infection.class)
				.add(Restrictions.gt("zombies", 0))
				.list();		
		
		// Defensively copy the infected cities to an unmodifiable list to prevent stupidity
		this.infectedCities = Collections.unmodifiableSet(new HashSet<>(infectedCities));
		return this.infectedCities;
	}

	public void infect(City city) {
		Infection infectedCity = infectionService.getInfectionByCity(city);
		
		if (infectedCity == null) {
			infectedCity = new Infection(city);
			infectedCity.save();
		}
		
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
		
		System.out.println("The infection spreads " + inOrTo + " " + city + "!");
		System.out.println("The virus has infected " + newInfections + " new " + peoplePerson + ".");

		infected += newInfections;
		infectedCity.setZombies(infected);

		// Update the total number of infections to include the new
		infectedWorldPopulation += newInfections;
		infectedCities.add(city);
		
		double percentInfected = (infected * 100.0f) / population;
		System.out.println(String.format("In this city: %d/%d (%.2f%%) of the population is infected!%n", infected, population, percentInfected));
		
		// save the infected city data back into the database
		session.beginTransaction();
		infectedCity.save();
		session.commitTransaction();
	}

	public void reportInfectionProgress() {
		System.out.println("-------------- WORLD NEWS FLASH!!! --------------");
		reportPopulationInfected();
		reportInfectedCountries();
		//reportTopLanguages();		
		System.out.println("-------------------------------------------------");
	}

	private void reportPopulationInfected() {
		double percentInfected = (infectedWorldPopulation * 100f) / world.getPopulation();
		String citiesOrCity = infectedCities.size() == 1 ? "city has" : "cities have";
		System.out.println(infectedCities.size() + " " + citiesOrCity + " been infected!");
		System.out.println(String.format("The world population is %.2f%% infected %n", percentInfected));
	}
	
	private void reportInfectedCountries() {
		System.out.println("Most Infected Countries: ");		
		int countriesToDisplay = 5;
		
		
		for(Map.Entry<Country,Float> infectedCountry: getSortedInfectionsByCountry().entrySet()) {
			Country country = infectedCountry.getKey();
			Float infectionPercentage = infectedCountry.getValue();
			List<Language> popularLanguages = country.getMostPopularLanguages();
			List<String> popularLanguageNames = new ArrayList<String>();
			for (Language l : popularLanguages) {
				popularLanguageNames.add(l.getLanguage());
			}

			System.out.println(String.format("%3.2f%% - %s (%s)", infectionPercentage, country, Joiner.on(", ").join(popularLanguageNames)));
			
			if(--countriesToDisplay == 0) {
				break;
			}
		}
		
		System.out.println();
	}
	
	private TreeMap<Country,Float> getSortedInfectionsByCountry() {
		@SuppressWarnings("unchecked")
		// get all countries and their associated populations (infected, total)
		List<Object[]> rawCountryInfections = (List<Object[]>) session.get()
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
	
	@SuppressWarnings("unused")
	private void reportTopLanguages() {
		System.out.println("World's Popular Languages: ");		
		int languagesToDisplay = 3;
		
		for(Map.Entry<Language,Long> infectedLanguage: getSortedMostSpoken().entrySet()) {
			Language language = infectedLanguage.getKey();
			long speakers = infectedLanguage.getValue();
			long infectedSpeakersWorldwide = 0L;
			
			// Calculate an estimated number of speakers remaining in the world
			List<CountryLanguage> countryLanguages = countryLanguageService.getCountryLanguagesByLanguage(language);
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
			
			for(Map.Entry<Country,Double> r : speakersInfectedByCountry.entrySet()) {
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
		Long infections = (Long) session.get()
				.createCriteria(Infection.class)
				.createAlias("city", "city")
				.createAlias("city.country", "country")
				.add(Restrictions.eq("city.country", country))
				.setProjection(Projections.sum("zombies"))
				.uniqueResult();
		
		return infections != null ? infections : 0L;
	}

	private void sanitize() {
		System.out.println("Sanitizing infected cities");
		session.get().createQuery("delete from Infection")
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
	
	public TreeMap<Language,Long> getSortedMostSpoken() {
		@SuppressWarnings("unchecked")
		List<CountryLanguage> countryLanguages = (List<CountryLanguage>) session.get()
				.createCriteria(CountryLanguage.class)
				.list();
		
		// Initialize keys. Sort the map later
		Map<Language,Long> unsortedLanguages = new HashMap<>();
			
		// Calculate the approximate number of speakers per language
		for(CountryLanguage cl : countryLanguages) {
			Country c = cl.getCountry(); // TODO: n+1 leak. 
			Language l = cl.getLanguage(); // TODO: n+1 leak. 
			
			Long speakers = unsortedLanguages.get(l);
			
			if(speakers == null) {
				speakers = 0L;
			}
			
			// TODO: cast to long then box to Long - better way?
			speakers += (long) (c.getPopulation() * ( cl.getPercentage() / 100 ));
			unsortedLanguages.put(l, speakers);
		}
		
		TreeMap<Language,Long> sortedLanguages = new TreeMap<>(new MostSpokenLanguageComparator(unsortedLanguages));
		sortedLanguages.putAll(unsortedLanguages);
		return sortedLanguages;
	}
	
	class MostSpokenLanguageComparator implements Comparator<Language> {
		Map<Language,Long> languageSpeakers;
	
		public MostSpokenLanguageComparator(Map<Language,Long> languageSpeakers) {
			this.languageSpeakers = languageSpeakers;
		}
		
		@Override
		public int compare(Language o1, Language o2) {
			return languageSpeakers.get(o2).compareTo(languageSpeakers.get(o1));
		}
	}
}
