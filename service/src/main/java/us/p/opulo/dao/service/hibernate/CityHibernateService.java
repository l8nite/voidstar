package us.p.opulo.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CityService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CityHibernateService implements CityService {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByCountry(Country country) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("country", country)).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> getCitiesByName(String name) {
		return (List<City>) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("name", name)).list();
	}
	
	@Override
	public City getCityById(Integer id) {
		return (City) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}
