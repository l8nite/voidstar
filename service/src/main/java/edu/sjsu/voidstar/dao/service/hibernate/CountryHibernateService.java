package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CountryService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class CountryHibernateService implements CountryService {
	
	@Override
	public Country getCountryByCode(String countryCode) {
		return (Country) HibernateSession.get().createCriteria(Country.class)
				.add(Restrictions.eq("code", countryCode))
				.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getCountriesByContinent(String continent) {
		return (List<Country>) HibernateSession.get().createCriteria(Country.class)
				.add(Restrictions.eq("continent", continent))
				.list();
	}
}
