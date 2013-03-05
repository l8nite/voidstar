package edu.sjsu.voidstar.dao.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.hibernate.HibernateSession;

public class CityService {
	
	@SuppressWarnings("unchecked")
	public static List<City> getCitiesByCountry(Country country) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("country", country)).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<City> getCitiesByName(String name) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("name", name)).list();
	}
	
	public static City getCityById(Long id) {
		return (City) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}
