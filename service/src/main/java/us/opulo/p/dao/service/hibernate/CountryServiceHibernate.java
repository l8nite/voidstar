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

import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.hibernate.HibernateSession;

@Singleton
public class CountryServiceHibernate implements CountryService {
	
	@Inject
	HibernateSession session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		return session.get().createCriteria(Country.class).list();
	}
	
	@Override
	public Country getCountryWithCode(String countryCode) {
		return (Country) session.get().createCriteria(Country.class)
			.add(Restrictions.eq("code", countryCode))
			.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getCountriesWithCodes(Collection<String> countryCodes) {
		return session.get().createCriteria(Country.class)
			.add(Restrictions.in("code", countryCodes))
			.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getCountriesOnContinent(String continent) {
		return session.get().createCriteria(Country.class)
			.add(Restrictions.eq("continent", continent))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getCountriesOnContinents(Collection<String> continents) {
		return session.get().createCriteria(Country.class)
			.add(Restrictions.in("continent", continents))
			.list();
	}
}
