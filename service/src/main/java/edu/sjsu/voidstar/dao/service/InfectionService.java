package edu.sjsu.voidstar.dao.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.hibernate.HibernateSession;

public class InfectionService {
	public static Infection forCity(City city) {
		Criteria criteria = HibernateSession.get().createCriteria(
				Infection.class);
		criteria.add(Restrictions.eq("city.id", city.getId()));

		Infection infection = (Infection) criteria.uniqueResult();

		if (infection == null) {
			infection = new Infection();
			infection.setCity(city);
		}

		return infection;
	}
}
