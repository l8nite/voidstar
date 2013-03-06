package edu.sjsu.voidstar.dao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.hibernate.HibernateSession;

public class InfectionService {
	
	public static Infection findOrCreateForCity(City city) {
		Infection infection = getForCity(city);

		if (infection == null) {
			infection = new Infection();
			infection.setCity(city);
		}

		return infection;
	}
	
	public static Infection getForCity (City city) {
		return (Infection) HibernateSession.get().createCriteria(Infection.class)
				.add(Restrictions.eq("city.id", city.getId()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static List<Infection> getForCountry(Country country) {
		return (List<Infection>) HibernateSession.get().createCriteria(Infection.class)
				.add(Subqueries.in("city", 
						DetachedCriteria.forClass(City.class)
							.add(Restrictions.eq("country", country))
						)
				)
				.list();
				
	}
}
