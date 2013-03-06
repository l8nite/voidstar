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

@WebService(serviceName="InfectionPortService", name="InfectionService", targetNamespace= Constants.Soap.NAMESPACE)
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class InfectionSoapService {

	@WebMethod
	@WebResult(name="Infection", targetNamespace=Constants.Soap.NAMESPACE)
	public Infection getInfectionByCity(@WebParam(name="City", targetNamespace=Constants.Soap.NAMESPACE) City city) {
		return InfectionService.getForCity(city);
	}
	
	@WebMethod
	@WebResult(name="Infections", targetNamespace=Constants.Soap.NAMESPACE)
	public List<Infection> getInfectionsForCountry(@WebParam(name="Country", targetNamespace=Constants.Soap.NAMESPACE) Country country) {
		return InfectionService.getForCountry(country);
	}
}
