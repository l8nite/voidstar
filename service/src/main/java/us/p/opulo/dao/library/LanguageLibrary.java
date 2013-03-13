package us.p.opulo.dao.library;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class LanguageLibrary implements LanguageService {

	@Inject 
	@HibernateService
	private LanguageService service;
	
	@Inject 
	private HibernateSession session;

	@Override
	public Language getLanguageById(Integer id) {
		return service.getLanguageById(id);
	}

	@Override
	public Language getLanguageByName(String name) {
		return service.getLanguageByName(name);
	}

	@Override
	public List<Language> getLanguagesByCountry(Country country) {
		return service.getLanguagesByCountry(country);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
