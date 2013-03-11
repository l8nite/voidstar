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
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;

@WebService(
		targetNamespace = Namespaces.Soap.COUNTRY_LANGUAGE_SERVICE,
		wsdlLocation = WSDL.COUNTRY_LANGUAGE_SERVICE,
		serviceName = Names.Service.COUNTRY_LANGUAGE_PORT_SERVICE,
		name = Names.Service.COUNTRY_LANGUAGE_SERVICE
)
@SOAPBinding(
		style = SOAPBinding.Style.DOCUMENT, 
		use = SOAPBinding.Use.LITERAL, 
		parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
)
@Singleton
public class CountryLanguageSoapService implements CountryLanguageService {
	private static final Logger log = LoggerFactory.getLogger(CountryLanguageSoapService.class);
	
	@Inject
	@HibernateService
	private CountryLanguageService hibernateService;
	
	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesByLanguage(@WebParam(name="language") Language language) {
		log.info("getByLanguage: language = " + language);
		return hibernateService.getCountryLanguagesByLanguage(language);
	}

	@Override
	@WebMethod
	@WebResult(targetNamespace=Namespaces.DAO, name="CountryLanguage")
	public List<CountryLanguage> getCountryLanguagesByCountry(Country country) {
		log.info("getByCountry: country = " + country);
		return hibernateService.getCountryLanguagesByCountry(country);
	}
}
