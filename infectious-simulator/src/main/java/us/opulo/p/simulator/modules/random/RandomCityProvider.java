package us.opulo.p.simulator.modules.random;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.City;
import us.opulo.p.dao.service.CityService;

/**
 * Provides a random City to the requestor
 * @author Jason Campos
 */
@Singleton
public class RandomCityProvider implements Provider<City> {

	List<City> allCities;
	Random random;

	@Inject
	public RandomCityProvider(@HibernateService CityService cityService) {
		super();
		allCities = cityService.getAllCities();
		random = new Random();
	}

	@Override
	public City get() {
		return allCities.get(random.nextInt(allCities.size()));
	}

}
