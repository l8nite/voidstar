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
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CountryService;

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
public class CountrySoapService {
	private static final Logger log = LoggerFactory.getLogger(CountrySoapService.class);
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO)
	public Country getCountryByCode(@WebParam(name="countryCode") String countryCode) {
		log.info("getCountryByCode(): countryCode = " + countryCode);
		return CountryService.getCountryByCode(countryCode);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO)
	public List<Country> getCountryByContinent(@WebParam(name="continent") String continent) {
		log.info("getCityByContinent(): continent = " + continent);
		return CountryService.getCountriesByContinent(continent);
	}
}
