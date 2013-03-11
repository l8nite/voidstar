package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;

public interface CountryLanguageService {
	List<CountryLanguage> getAll();

	List<CountryLanguage> getByLanguage(Language language);

	List<CountryLanguage> getByCountry(Country country);
}
