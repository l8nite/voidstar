package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.service.InfectionService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class InfectionHibernateService implements InfectionService {
	
	public Infection findOrCreateForCity(City city) {
		Infection infection = getInfectionByCity(city);

		if (infection == null) {
			infection = new Infection();
			infection.setCity(city);
		}

		return infection;
	}
	
	public Infection getInfectionByCity (City city) {
		return (Infection) HibernateSession.get().createCriteria(Infection.class)
				.add(Restrictions.eq("city.id", city.getId()))
				.uniqueResult();
	}

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
