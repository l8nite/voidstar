package us.p.opulo.dao.library;

import java.util.List;

import javax.inject.Inject;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

public class InfectionLibrary implements InfectionService {
	
	@Inject
	@HibernateService
	private InfectionService service;
	
	@Inject
	private HibernateSession session;

	@Override
	public Infection getInfectionByCity(City city) {
		return service.getInfectionByCity(city);
	}

	@Override
	public List<Infection> getInfectionsByCountry(Country country) {
		return service.getInfectionsByCountry(country);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
