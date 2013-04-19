package us.opulo.p.simulator;

import java.text.SimpleDateFormat;
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
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.query.WorldQueryService;
import us.opulo.p.hibernate.SessionManager;

/**
 * @author Jason Campos, Shaun Guth
 */
public class ZombieEpidemic {
	
	private static final Logger log = LoggerFactory.getLogger(ZombieEpidemic.class);
	
	private final Provider<City> cityProvider;
	private final Provider<Date> dateProvider;
	private final Provider<Double> percentProvider;
	private final Provider<InfectionEventDetail> infectionEventDetailProvider;
	
	private InfectionService infectionService;
	private WorldQueryService worldQueryService;
	
	private int infectedWorldPopulation = 0;
	private Set<City> infectedCities = new HashSet<>();
	
	@Inject
	public ZombieEpidemic (Provider<City> cityProvider,  
			Provider<Date> dateProvider, 
			Provider<Double> percentProvider, 
			Provider<InfectionEventDetail> infectionEventDetailProvider,
			@HibernateService InfectionService infectionService,
			WorldQueryService worldQueryService) 
	{
		this.cityProvider = cityProvider;
		this.dateProvider = dateProvider;
		this.percentProvider = percentProvider;
		this.infectionService = infectionService;
		this.worldQueryService = worldQueryService;
		this.infectionEventDetailProvider = infectionEventDetailProvider;
	}

	// set epidemic start date to whatever the dateProvider gives us
	// then generate an identifier for this epidemic
	// then get the first city to infect, and infect it
	public void startInfection() {		
		City genesis = cityProvider.get();
		Date startDate = dateProvider.get();
		InfectionEventDetail details =infectionEventDetailProvider.get();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		log.info("Epidemic " + details.getEpidemic() + " starting on " + sdf.format(startDate) + " in " + genesis);
		
		infect(genesis, details, startDate);
	}

	public void spreadInfection() {
		infect(cityProvider.get(), infectionEventDetailProvider.get(), dateProvider.get());
	}

	// infects the given city, generates infection event
	private void infect(City city, InfectionEventDetail details, Date date) {
		Session session = SessionManager.get();
		Transaction tx = null;
		try {
			// see if there's an Infection table entry for this City
			Infection infection = infectionService.getInfectionForCity(city);

			if (infection == null) {
				infection = new Infection(city);
			}

			Integer population = city.getPopulation();
			Integer infectedBefore = infection.getZombies();
			Integer healthyBefore = population - infectedBefore;
			Integer infected = infectedBefore + (int) (percentProvider.get() * healthyBefore);
			
			// cap # of newInfections at remaining healthy population 
			if (infected + infectedBefore > population) {
				infected = population - infectedBefore;
			}
	
			String inOrTo = infected == 0 ? "to" : "in";
			log.info("The infection spreads " + inOrTo + " " + city.toString() + "!");
			
			String peoplePerson = infected == 1 ? "person" : "people";
			log.info("The virus has infected " + infected + " new " + peoplePerson + ".");
			
			Integer infectedAfter = infectedBefore + infected;
			Integer healthyAfter = population - infectedAfter;
	
			infection.setZombies(infectedAfter);
	
			InfectionEvent event = new InfectionEvent(city, details, date);
			event.setHealthyBefore(healthyBefore);
			event.setHealthyAfter(healthyAfter);
			event.setInfected(infected);
			event.setInfectedBefore(infectedBefore);
			event.setInfectedAfter(infectedAfter);
			
			// record event to database
			tx = session.beginTransaction();
			session.saveOrUpdate(infection);
			session.save(event);
			tx.commit();

			// update the total number of infections to include the newly infected
			infectedWorldPopulation += infected;
			infectedCities.add(city);

			// report on the percentage of the population that is infected 
			double percentInfected = (infectedAfter * 100.0f) / population;
			log.info(String.format("In this city: %d/%d (%.2f%%) of the population is infected!%n", infectedAfter, population, percentInfected));
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
		double percentInfected = (infectedWorldPopulation * 100f) / worldQueryService.getPopulation();
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
		
			log.info(String.format("%3.2f%% - %s", infectionPercentage, country));
			
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
