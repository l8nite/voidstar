package edu.sjsu.voidstar.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.constants.Constants;
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CityService;

@WebService(
		targetNamespace = Constants.Namespaces.Soap.CITY_SERVICE,
		wsdlLocation = Constants.Resources.WSDL.CITY_SERVICE,
		serviceName = "CityPortService",
		name = "CityService"
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
public class CitySoapService {
	private static final Logger log = LoggerFactory.getLogger(CitySoapService.class);
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="City")
	public City getCityById(@WebParam(name="cityId") Integer cityId) {
		log.info("getCityById(): cityId = " + cityId);
		City city = CityService.getCityById(cityId);
		log.info("getCityById(): result = " + city);
		return city;
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Cities")
	public List<City> getCityByName(@WebParam(name="cityName") String cityName) {
		log.info("getCityByName(): cityName = " + cityName);
		return CityService.getCitiesByName(cityName);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Cities")
	public List<City> getCityByCountry(@WebParam(name="country", targetNamespace=Constants.Namespaces.DAO) Country country) {
		log.info("getCityByCountry(): country = " + country);
		return CityService.getCitiesByCountry(country);
	}
}