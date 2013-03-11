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
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CountryService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Constants.Namespaces.Soap.COUNTRY,
		wsdlLocation = Constants.Resources.WSDL.COUNTRY_SERVICE,
		serviceName = "CountryPortService",
		name = "CountryService"
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class CountrySoapService implements CountryService {
	private static final Logger log = LoggerFactory.getLogger(CountrySoapService.class);
	
	@Inject
	@HibernateService
	private CountryService hibernateService;
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Country")
	public Country getCountryByCode(@WebParam(name="code") String countryCode) {
		log.info("getCountryByCode(): countryCode = " + countryCode);
		return hibernateService.getCountryByCode(countryCode);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Country")
	public List<Country> getCountriesByContinent(@WebParam(name="continent") String continent) {
		log.info("getCountriesByContinent(): continent = " + continent);
		return hibernateService.getCountriesByContinent(continent);
	}
}
