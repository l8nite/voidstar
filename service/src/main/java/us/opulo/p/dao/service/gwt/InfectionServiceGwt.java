package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.guice.annotations.HibernateService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class InfectionServiceGwt extends RemoteServiceServlet implements InfectionService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InfectionServiceGwt.class);
	
	@Inject
	@HibernateService
	InfectionService hibernateService;

	@Override
	public List<Infection> getAllInfections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Infection getInfectionForCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Infection> getInfectionForCities(List<City> cities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Infection> getInfectionsForCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Infection> getInfectionsForCountries(
			Collection<Country> countries) {
		// TODO Auto-generated method stub
		return null;
	}
}