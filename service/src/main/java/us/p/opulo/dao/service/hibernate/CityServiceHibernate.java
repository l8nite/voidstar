/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao.service.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CityServiceHibernate implements CityService {
	
	@Inject
	private HibernateSession session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByCountry(Country country) {
		return (List<City>) session.get().createCriteria(City.class)
				.add(Restrictions.eq("country", country)).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByName(String name) {
		return (List<City>) session.get().createCriteria(City.class)
				.add(Restrictions.eq("name", name)).list();
	}
	
	@Override
	public City getCityById(Integer id) {
		return (City) session.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}