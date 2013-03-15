/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.hibernate;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.hibernate.HibernateSession;

@Singleton
public class CityServiceHibernate implements CityService {
	
	@Inject
	private HibernateSession session;

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getAllCities() {
		return session.get().createCriteria(City.class).list();
	}
	
	@Override
	public City getCityWithId(Integer id) {
		return (City) session.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesWithIds(Collection<Integer> cityIds) {
		return session.get().createCriteria(City.class)
				.add(Restrictions.in("id", cityIds))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesWithName(String name) {
		return session.get().createCriteria(City.class)
				.add(Restrictions.eq("name", name)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesWithNames(Collection<String> cityNames) {
		return session.get().createCriteria(City.class)
				.add(Restrictions.in("name", cityNames))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesInCountry(Country country) {
		return session.get().createCriteria(City.class)
				.add(Restrictions.eq("country", country)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesInCountries(Collection<Country> countries) {
		return session.get().createCriteria(City.class)
				.add(Restrictions.in("country", countries))
				.list();
	}
}
