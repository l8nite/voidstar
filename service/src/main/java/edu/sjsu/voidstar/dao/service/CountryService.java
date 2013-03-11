package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.Country;

public interface CountryService {
	Country getCountryByCode(String countryCode) ;
	List<Country> getCountriesByContinent(String continent);
}
