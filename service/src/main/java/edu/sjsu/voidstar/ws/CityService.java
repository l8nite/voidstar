package edu.sjsu.voidstar.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@WebService
public class CityService {
	@WebMethod
	public City getCityById(Integer id) {
		return (City) HibernateSession.get().createCriteria(City.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}