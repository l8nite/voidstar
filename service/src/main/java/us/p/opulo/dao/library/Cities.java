package us.p.opulo.dao.library;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class Cities implements CityService {

	@Inject
	@HibernateService
	private CityService service;
	
	@Inject
	private HibernateSession session;
	
	@Override
	public City getCityById(Integer cityId) {
		return service.getCityById(cityId);
	}

	@Override
	public List<City> getCitiesByName(String cityName) {
		return service.getCitiesByName(cityName);
	}

	@Override
	public List<City> getCitiesByCountry(Country country) {
		return service.getCitiesByCountry(country);
	}
	
	/* ADDITIONAL NON-INTERFACE METHODS */
	
	public City getRandomCity() {
		List<City> allCities = getAll();
		return allCities.get(new Random().nextInt(allCities.size()));
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		return session.get()
				.createCriteria(City.class)
				.list();
	}
}
