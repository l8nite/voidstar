package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.dao.service.CountryLanguageService;
import us.opulo.p.guice.annotations.HibernateService;
import us.opulo.p.util.StringUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class CountryLanguageServiceGwt extends RemoteServiceServlet implements CountryLanguageService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CountryLanguageServiceGwt.class);
	
	@Inject
	@HibernateService
	CountryLanguageService hibernateService;

	@Override
	public List<CountryLanguage> getAllCountryLanguages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguage(
			Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguages(
			Collection<Language> languages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountries(
			Collection<Country> countries) {
		// TODO Auto-generated method stub
		return null;
	}
}