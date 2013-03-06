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
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.service.InfectionService;

@WebService(serviceName="InfectionPortService", name="InfectionService", targetNamespace= Constants.Namespaces.Services.INFECTION)
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class InfectionSoapService {

	@WebMethod
	@WebResult(name="Infection", targetNamespace=Constants.Namespaces.DAO)
	public Infection getInfectionByCity(@WebParam(name="City", targetNamespace=Constants.Namespaces.DAO) City city) {
		return InfectionService.getForCity(city);
	}
	
	@WebMethod
	@WebResult(name="Infections", targetNamespace=Constants.Namespaces.DAO)
	public List<Infection> getInfectionsForCountry(@WebParam(name="Country", targetNamespace=Constants.Namespaces.DAO) Country country) {
		return InfectionService.getForCountry(country);
	}
}
