package us.p.opulo.dao.service;

import java.util.List;

import us.p.opulo.dao.Country;

public interface CountryService {
	Country getCountryByCode(String countryCode);
	List<Country> getCountriesByContinent(String continent);
}
