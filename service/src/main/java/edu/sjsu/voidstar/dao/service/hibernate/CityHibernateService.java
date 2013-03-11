package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CityService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class CityHibernateService implements CityService {
	
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByCountry(Country country) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("country", country)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByName(String name) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("name", name)).list();
	}
	
	public City getCityById(Integer id) {
		return (City) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}
