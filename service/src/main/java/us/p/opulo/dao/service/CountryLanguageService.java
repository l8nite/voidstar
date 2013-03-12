package us.p.opulo.dao.service;

import java.util.List;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;

public interface CountryLanguageService {
	List<CountryLanguage> getCountryLanguagesByLanguage(Language language);
	List<CountryLanguage> getCountryLanguagesByCountry(Country country);
}
