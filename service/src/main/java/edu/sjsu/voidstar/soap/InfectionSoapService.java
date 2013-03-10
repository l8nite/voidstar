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
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.service.InfectionService;

@WebService(
		 targetNamespace= Constants.Namespaces.Soap.INFECTION_SERVICE,
		 wsdlLocation = Constants.Resources.WSDL.INFECTION_SERVICE,
		 serviceName = "InfectionPortService",
		 name = "InfectionService"
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
public class InfectionSoapService {
	private static final Logger log = LoggerFactory.getLogger(InfectionSoapService.class);
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Infection")
	public Infection getInfectionByCity(@WebParam(name="city", targetNamespace=Constants.Namespaces.DAO) City city) {
		log.info("getInfectionByCity(): city = " + city);
		return InfectionService.getForCity(city);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionsByCountry(@WebParam(name="country", targetNamespace=Constants.Namespaces.DAO) Country country) {
		log.info("getInfectionByCountry(): country = " + country);
		return InfectionService.getForCountry(country);
	}
}
