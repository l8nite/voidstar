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

import edu.sjsu.voidstar.constants.Constants.Names.Service;
import edu.sjsu.voidstar.constants.Constants.Resources.WSDL;
import edu.sjsu.voidstar.constants.Constants.XML.Namespaces;
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CityService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Namespaces.Soap.CITY_SERVICE,
		wsdlLocation = WSDL.CITY_SERVICE,
		serviceName = Service.CITY_PORT_SERVICE,
		name = Service.CITY_SERVICE
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
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="id")
	public City getCityById(@WebParam(name="id") Integer id) {
		log.info("getCityById(): cityId = " + id);
		City city = hibernateService.getCityById(id);
		log.info("getCityById(): result = " + city);
		return city;
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesByName(@WebParam(name="name") String cityName) {
		log.info("getCityByName(): cityName = " + cityName);
		return hibernateService.getCitiesByName(cityName);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="City")
	public List<City> getCitiesByCountry(@WebParam(name="country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getCityByCountry(): country = " + country);
		return hibernateService.getCitiesByCountry(country);
	}
}