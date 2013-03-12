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
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;

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
}
