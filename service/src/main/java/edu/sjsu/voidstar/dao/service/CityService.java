package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;

public interface CityService {
	City getCityById(Integer cityId);

	List<City> getCitiesByName(String cityName);

	List<City> getCitiesByCountry(Country country);
}