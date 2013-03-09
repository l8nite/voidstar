package edu.sjsu.voidstar.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;

@WebService(name="CityService")
public class CityPort {
	
	@WebMethod
	@WebResult(name="City")
	public City getCityById(@WebParam(name="cityId") Integer cityId) {
		return City.getCityById(cityId);
	}
	
	@WebMethod
	@WebResult(name="Cities")
	public List<City> getCitiesByName(@WebParam(name="cityName") String cityName) {
		return City.getCitiesByName(cityName);
	}
	
	@WebMethod
	@WebResult(name="Cities")
	public List<City> getCitiesByCountry(@WebParam(name="country") Country country) {
		return City.getCitiesByCountry(country);
	}
}