package edu.sjsu.voidstar.dao.service.soap;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
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
import edu.sjsu.voidstar.guice.annotations.HibernateService;

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
@Singleton
public class CitySoapService implements CityService {
	private static final Logger log = LoggerFactory.getLogger(CitySoapService.class);

	@Inject
	@HibernateService
	private CityService hibernateService;
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="City")
	public City getCityById(@WebParam(name="id") Integer id) {
		log.info("getCityById(): cityId = " + id);
		City city = hibernateService.getCityById(id);
		log.info("getCityById(): result = " + city);
		return city;
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="City")
	public List<City> getCitiesByName(@WebParam(name="name") String cityName) {
		log.info("getCityByName(): cityName = " + cityName);
		return hibernateService.getCitiesByName(cityName);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="City")
	public List<City> getCitiesByCountry(@WebParam(name="country", targetNamespace=Constants.Namespaces.DAO) Country country) {
		log.info("getCityByCountry(): country = " + country);
		return hibernateService.getCitiesByCountry(country);
	}
}