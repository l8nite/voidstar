package edu.sjsu.voidstar.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.sjsu.voidstar.constants.Constants;
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CityService;

@WebService(serviceName="CityPortService", name="CityService", targetNamespace= Constants.Soap.NAMESPACE)
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class CitySoapService {
	
	@WebMethod
	@WebResult(name="City", targetNamespace=Constants.Soap.NAMESPACE)
	public City getCityById(@WebParam(name="cityId") Integer cityId) {
		return CityService.getCityById(cityId);
	}
	
	@WebMethod
	@WebResult(name="City", targetNamespace=Constants.Soap.NAMESPACE)
	public List<City> getCityByName(@WebParam(name="cityName") String cityName) {
		return CityService.getCitiesByName(cityName);
	}
	
	@WebMethod
	@WebResult(name="City", targetNamespace=Constants.Soap.NAMESPACE)
	public List<City> getCityByCountry(@WebParam(name="country") Country country) {
		return CityService.getCitiesByCountry(country);
	}
}