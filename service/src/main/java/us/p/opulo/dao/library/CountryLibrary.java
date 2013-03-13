package us.p.opulo.dao.library;

import java.util.List;

import javax.inject.Inject;

import com.google.inject.Singleton;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.service.CountryService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CountryLibrary implements CountryService {
	
	@Inject
	@HibernateService
	private CountryService service;
	
	@Inject
	private HibernateSession session;

	@Override
	public Country getCountryByCode(String countryCode) {
		return service.getCountryByCode(countryCode);
	}

	@Override
	public List<Country> getCountriesByContinent(String continent) {
		return service.getCountriesByContinent(continent);
	}

	/* ADDITIONAL LIBRARY METHODS */

}
