package edu.sjsu.voidstar.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.sjsu.voidstar.constants.Constants;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.service.CountryService;

@WebService(serviceName="CountryPortService", name="CountryService", targetNamespace= Constants.Namespaces.Services.COUNTRY)
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class CountrySoapService {
	
	@WebMethod
	@WebResult(name="Country", targetNamespace=Constants.Namespaces.DAO)
	public Country getCountryByCode(@WebParam(name="countryCode") String countryCode) {
		return CountryService.getCountryByCode(countryCode);
	}
	
	@WebMethod
	@WebResult(name="Countries", targetNamespace=Constants.Namespaces.DAO)
	public List<Country> getCountryByContinent(@WebParam(name="continent") String continent) {
		return CountryService.getCountriesByContinent(continent);
	}
}
