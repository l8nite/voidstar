package edu.sjsu.voidstar.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.sjsu.voidstar.constants.Constants;
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CityService;

@WebService(
		targetNamespace=Constants.Namespaces.Services.CITY,
		serviceName="CityPortService",
		name="CityService"
)
public class CitySoapService {
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO)
	public City getCityById(@WebParam(name="cityId") Integer cityId) {
		return CityService.getCityById(cityId);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO)
	public List<City> getCityByName(@WebParam(name="cityName") String cityName) {
		return CityService.getCitiesByName(cityName);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO)
	public List<City> getCityByCountry(@WebParam(targetNamespace=Constants.Namespaces.DAO, name="country") Country country) {
		return CityService.getCitiesByCountry(country);
	}
}