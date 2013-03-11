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
import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

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
@Singleton
public class LanguageSoapService implements LanguageService {
	private static final Logger log = LoggerFactory.getLogger(LanguageSoapService.class);
	
	@Inject
	@HibernateService
	private LanguageService hibernateService;
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public Language getLanguageById(@WebParam(name="id") Integer id
	) {
		log.info("getLanguageById(): id = " + id);
		return hibernateService.getLanguageById(id);
	}
	
	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public Language getLanguageByName(@WebParam(name="name") String name) {
		log.info("getLanguageByName(): name = " + name);
		return hibernateService.getLanguageByName(name);
	}

	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCountry(@WebParam(targetNamespace=Constants.Namespaces.DAO, name="country") Country country) {
		log.info("getLanguagesByCountry(): country = " + country);
		return hibernateService.getLanguagesByCountry(country);
	}

	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCity(City city) {
		log.info("getLanguagesByCity(): city = " + city);
		return hibernateService.getLanguagesByCity(city);
	}

	@WebMethod
	@WebResult(targetNamespace=Constants.Namespaces.DAO, name="Language")
	public List<Object[]> getSortedLanguagesByCountry(Country country) {
		log.info("getSortedLanguagesByCountry(): country = " + country);
		return hibernateService.getSortedLanguagesByCountry(country);
	}
}
