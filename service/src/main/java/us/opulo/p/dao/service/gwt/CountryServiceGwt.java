package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.service.CountryService;
import us.opulo.p.guice.annotations.HibernateService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class CountryServiceGwt extends RemoteServiceServlet implements CountryService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CountryServiceGwt.class);
	
	@Inject
	@HibernateService
	CountryService hibernateService;

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getCountryWithCode(String countryCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getCountriesWithCodes(Collection<String> countryCodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getCountriesOnContinent(String continent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getCountriesOnContinents(Collection<String> continents) {
		// TODO Auto-generated method stub
		return null;
	}
}