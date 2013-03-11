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

import edu.sjsu.voidstar.constants.Constants.Names;
import edu.sjsu.voidstar.constants.Constants.Resources.WSDL;
import edu.sjsu.voidstar.constants.Constants.XML.Namespaces;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CountryService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Namespaces.Soap.COUNTRY_SERVICE,
		wsdlLocation = WSDL.COUNTRY_SERVICE,
		serviceName = Names.Service.COUNTRY_PORT_SERVICE,
		name = Names.Service.COUNTRY_SERVICE
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
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public Country getCountryByCode(@WebParam(name="code") String countryCode) {
		log.info("getCountryByCode(): countryCode = " + countryCode);
		return hibernateService.getCountryByCode(countryCode);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Country")
	public List<Country> getCountriesByContinent(@WebParam(name="continent") String continent) {
		log.info("getCountriesByContinent(): continent = " + continent);
		return hibernateService.getCountriesByContinent(continent);
	}
}
