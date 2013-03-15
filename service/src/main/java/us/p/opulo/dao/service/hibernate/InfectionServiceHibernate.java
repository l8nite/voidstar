/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.service.hibernate;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class InfectionServiceHibernate implements InfectionService {
	
	@Inject
	HibernateSession session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Infection> getAllInfections() {
		return session.get().createCriteria(Infection.class).list();
	}
	
	@Override
	public Infection getInfectionForCity (City city) {
		return (Infection) session.get().createCriteria(Infection.class)
				.add(Restrictions.eq("city.id", city.getId()))
				.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Infection> getInfectionForCities(List<City> cities) {
		return session.get().createCriteria(Infection.class)
			.add(Restrictions.in("city", cities))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Infection> getInfectionsForCountry(Country country) {
		DetachedCriteria citiesInCountry = DetachedCriteria.forClass(City.class)
				.add(Restrictions.eq("country", country))
				.setProjection(Projections.property("id"));
		
		return session.get().createCriteria(Infection.class)
				.add(Subqueries.propertyIn("cityID", citiesInCountry))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Infection> getInfectionsForCountries(Collection<Country> countries) {
		DetachedCriteria citiesInCountries = DetachedCriteria.forClass(City.class)
				.add(Restrictions.in("country", countries))
				.setProjection(Projections.property("id"));
		
		return session.get().createCriteria(Infection.class)
				.add(Subqueries.propertyIn("cityID", citiesInCountries))
				.list();
	}
}
