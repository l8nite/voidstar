package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;

public interface CountryLanguageService {
	List<CountryLanguage> getCountryLanguagesByLanguage(Language language);
	List<CountryLanguage> getCountryLanguagesByCountry(Country country);
}
