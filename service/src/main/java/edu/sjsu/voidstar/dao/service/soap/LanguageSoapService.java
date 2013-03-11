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
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		 targetNamespace= Namespaces.Soap.LANGUAGE_SERVICE,
		 wsdlLocation = WSDL.LANGUAGE_SERVICE,
		 serviceName = Names.Service.LANGUAGE_PORT_SERVICE,
		 name = Names.Service.LANGUAGE_SERVICE
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
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public Language getLanguageById(@WebParam(name="id") Integer id
	) {
		log.info("getLanguageById(): id = " + id);
		return hibernateService.getLanguageById(id);
	}
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public Language getLanguageByName(@WebParam(name="name") String name) {
		log.info("getLanguageByName(): name = " + name);
		return hibernateService.getLanguageByName(name);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCountry(@WebParam(targetNamespace=Namespaces.DAO, name="country") Country country) {
		log.info("getLanguagesByCountry(): country = " + country);
		return hibernateService.getLanguagesByCountry(country);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="Language")
	public List<Language> getLanguagesByCity(City city) {
		log.info("getLanguagesByCity(): city = " + city);
		return hibernateService.getLanguagesByCity(city);
	}
}
