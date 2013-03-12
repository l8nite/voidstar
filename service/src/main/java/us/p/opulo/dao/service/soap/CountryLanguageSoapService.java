package us.p.opulo.dao.service.soap;

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

import us.p.opulo.constants.Constants.Names;
import us.p.opulo.constants.Constants.Resources.WSDL;
import us.p.opulo.constants.Constants.XML.Namespaces;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.guice.annotations.HibernateService;

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
