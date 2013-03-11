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
import edu.sjsu.voidstar.dao.Language;

@WebService(
		 targetNamespace= Constants.Namespaces.Soap.LANGUAGE_SERVICE,
		 wsdlLocation = Constants.Resources.WSDL.LANGUAGE_SERVICE,
		 serviceName = "LanguagePortService",
		 name = "LanguageService"
)
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
public class LanguageSoapService {
	private static final Logger log = LoggerFactory.getLogger(LanguageSoapService.class);
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public Language getLanguageById(@WebParam(name="id") Integer id) {
		log.info("getLanguageById(): id = " + id);
		return null;
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public Language getLanguageByName(@WebParam(name="name") String name) {
		log.info("getLanguageByName(): name = " + name);
		return null;
	}

	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCity(@WebParam(targetNamespace=Constants.Namespaces.DAO, name="city") City city) {
		log.info("getLanguageByCity(): city = " + city);
		return null;
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCountry(@WebParam(name="country", targetNamespace=Constants.Namespaces.DAO) Country country) {
		log.info("getLanguageByCountry(): country = " + country);
		return null;
	}
}
