package us.p.opulo.dao.service;

import java.util.List;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;

public interface CityService {
	City getCityById(Integer cityId);

	List<City> getCitiesByName(String cityName);

	List<City> getCitiesByCountry(Country country);
}