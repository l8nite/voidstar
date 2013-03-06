package edu.sjsu.voidstar.dao.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.hibernate.HibernateSession;

public class CountryService {
	
	public static Country getCountryByCode(String countryCode) {
		return (Country) HibernateSession.get().createCriteria(Country.class)
				.add(Restrictions.eq("code", countryCode))
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Country> getCountriesByContinent(String continent) {
		return (List<Country>) HibernateSession.get().createCriteria(Country.class)
				.add(Restrictions.eq("continent", continent))
				.list();
	}
}
