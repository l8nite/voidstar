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

import javax.inject.Singleton;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class InfectionHibernateService implements InfectionService {
	
	@Override
	public Infection getInfectionByCity (City city) {
		return (Infection) HibernateSession.get().createCriteria(Infection.class)
				.add(Restrictions.eq("city.id", city.getId()))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Infection> getInfectionsByCountry(Country country) {
		return (List<Infection>) HibernateSession.get().createCriteria(Infection.class)
				.add(Subqueries.in("city", 
						DetachedCriteria.forClass(City.class)
							.add(Restrictions.eq("country", country))
						)
				)
				.list();
				
	}
}
