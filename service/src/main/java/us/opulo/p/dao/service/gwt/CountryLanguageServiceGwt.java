package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Language;
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
		log.info("getAllCountryLanguages()");
		return hibernateService.getAllCountryLanguages();
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguage(Language language) {
		log.info("getCountryLanguagesForLanguage(): language = " + language);
		return hibernateService.getCountryLanguagesForLanguage(language);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForLanguages(Collection<Language> languages) {
		log.info("getCountryLanguagesForLanguages(): languages = " + StringUtil.joinCollection(languages, ','));
		return hibernateService.getCountryLanguagesForLanguages(languages);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountry(Country country) {
		log.info("getCountryLanguagesForCountry(): country = " + country);
		return hibernateService.getCountryLanguagesForCountry(country);
	}

	@Override
	public List<CountryLanguage> getCountryLanguagesForCountries(Collection<Country> countries) {
		log.info("getCountryLanguagesForCountries(): countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getCountryLanguagesForCountries(countries);
	}
}