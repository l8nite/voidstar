package us.opulo.p.core;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Provider;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.InfectionEvent;
import us.opulo.p.dao.InfectionEventDetail;
import us.opulo.p.dao.Strain;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.query.WorldQueryService;
import us.opulo.p.hibernate.SessionManager;

/**
 * @author Jason Campos, Shaun Guth
 */
public class ZombieInfection {
	
	private static final Logger log = LoggerFactory.getLogger(ZombieInfection.class);
	
	Provider<City> cityProvider;
	Provider<Strain> strainProvider;
	Provider<Date> dateProvider;
	Provider<Double> percentProvider;

	InfectionService infectionService;
	
	private City genesis;
	private int infectedWorldPopulation = 0;
	private Set<City> infectedCities = new HashSet<>();
	
	@Inject
	public ZombieInfection (Provider<City> cityProvider, 
			Provider<Strain> strainProvider, 
			Provider<Date> dateProvider, 
			Provider<Double> percentProvider, 
			@HibernateService InfectionService infectionService ) 
	{
		this.cityProvider = cityProvider;
		this.strainProvider = strainProvider;
		this.dateProvider = dateProvider;
		this.percentProvider = percentProvider;
		this.infectionService = infectionService;
	}

	public void startInfection() {
		initializeGenesis();
		infect(genesis);
	}

	public void spreadInfection() {
		infect(cityProvider.get());
	}
	
	private void initializeGenesis() {
		log.info("Choosing random city for virulent strain genesis");
		genesis = cityProvider.get();
		log.info("City chosen: " + genesis.toString() + "\n");
	}

	private void infect(City city) {
		Session session = SessionManager.get();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Infection infection = infectionService.getInfectionForCity(city);
			Date infectionDate = dateProvider.get();
			Strain strain = strainProvider.get();
					
			if (infection == null) {
				infection = new Infection(city, strain);
			}
			
			// Log the event
			InfectionEvent event = new InfectionEvent(infection, infectionDate);
			InfectionEventDetail eventDetails = new InfectionEventDetail(event);
			
			Integer population = city.getPopulation();
			Integer infected = infection.getZombies();
			
			eventDetails.setHealthyBefore(population - infected);
			eventDetails.setInfectedBefore(infected);
			
			String inOrTo = infected == 0 ? "to" : "in";
	
			// Randomly infect a new number of people
			Integer newInfections = infected + (int) (percentProvider.get() * (population - infected));;
			
			// cap # of newInfections at remaining healthy population 
			if (newInfections + infected > population) {
				newInfections = population - infected;
			}
	
			String peoplePerson = newInfections == 1 ? "person" : "people";
			
			log.info("The infection spreads " + inOrTo + " " + city.toString() + "!");
			log.info("The virus has infected " + newInfections + " new " + peoplePerson + ".");
	
			infected += newInfections;
			infection.setZombies(infected);
	
			eventDetails.setInfectedAfter(infected);
			eventDetails.setHealthyAfter(population - infected);
			
			// Update the total number of infections to include the new
			infectedWorldPopulation += newInfections;
			infectedCities.add(city);
			
			double percentInfected = (infected * 100.0f) / population;
			log.info(String.format("In this city: %d/%d (%.2f%%) of the population is infected!%n", infected, population, percentInfected));
			
			// Save the new entities
			session.saveOrUpdate(infection);
			session.save(event);
			session.save(eventDetails);
			
			tx.commit();
		} catch (HibernateException e) {
			log.error("An unexpected error occurred: " + e.getMessage(), e);
			
			if (tx != null) {
				tx.rollback();
			}
		}
	}


	
	public void reportInfectionProgress() {
		log.info("-------------- WORLD NEWS FLASH!!! --------------");
		reportPopulationInfected();
		reportInfectedCountries();	
		log.info("-------------------------------------------------");
	}

	private void reportPopulationInfected() {
		double percentInfected = (infectedWorldPopulation * 100f) / new WorldQueryService().getPopulation();
		String citiesOrCity = infectedCities.size() == 1 ? "city has" : "cities have";
		log.info(infectedCities.size() + " " + citiesOrCity + " been infected!");
		log.info(String.format("The world population is %.2f%% infected %n", percentInfected));
	}
	
	private void reportInfectedCountries() {
		log.info("Most Infected Countries: ");		
		int countriesToDisplay = 5;
		
		for(Entry<Country,Float> infectedCountry: getSortedInfectionsByCountry().entrySet()) {
			Country country = infectedCountry.getKey();
			Float infectionPercentage = infectedCountry.getValue();
		
			log.info(String.format("%3.2f%% - %s (%s)", infectionPercentage, country));
			
			if(--countriesToDisplay == 0) {
				break;
			}
		}
	}
	
	private TreeMap<Country,Float> getSortedInfectionsByCountry() {
		@SuppressWarnings("unchecked")
		// get all countries and their associated populations (infected, total)
		List<Object[]> rawCountryInfections = (List<Object[]>) SessionManager.get()
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
