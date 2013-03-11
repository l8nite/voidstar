package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@Singleton
public class LanguageHibernateService implements LanguageService {
	
	@HibernateService
	CountryLanguageService countryLanguageService;

	@Override
	public Language getLanguageById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language getLanguageByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getLanguagesByCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
