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
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.service.InfectionService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		 targetNamespace=Namespaces.Soap.INFECTION_SERVICE,
		 wsdlLocation = WSDL.INFECTION_SERVICE,
		 serviceName = Names.Service.INFECTION_PORT_SERVICE,
		 name = Names.Service.INFECTION_SERVICE
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class InfectionSoapService implements InfectionService {
	private static final Logger log = LoggerFactory.getLogger(InfectionSoapService.class);
	
	@Inject
	@HibernateService
	private InfectionService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public Infection getInfectionByCity(@WebParam(name="city", targetNamespace=Namespaces.DAO) City city) {
		log.info("getInfectionByCity(): city = " + city);
		return hibernateService.getInfectionByCity(city);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Infection")
	public List<Infection> getInfectionsByCountry(@WebParam(name="country", targetNamespace=Namespaces.DAO) Country country) {
		log.info("getInfectionByCountry(): country = " + country);
		return hibernateService.getInfectionsByCountry(country);
	}
}