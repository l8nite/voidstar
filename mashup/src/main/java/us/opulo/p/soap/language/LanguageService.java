
package us.opulo.p.soap.language;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "LanguageService", targetNamespace = "http://p.opulo.us/soap/language")
@XmlSeeAlso({
    us.opulo.p.soap.language.ObjectFactory.class,
    us.opulo.p.dao.ObjectFactory.class
})
public interface LanguageService {


    /**
     * 
     * @param id
     * @return
     *     returns us.opulo.p.dao.Language
     */
    @WebMethod
    @WebResult(name = "Language", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getLanguageById", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguageById")
    @ResponseWrapper(localName = "getLanguageByIdResponse", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguageByIdResponse")
    public Language getLanguageById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param name
     * @return
     *     returns us.opulo.p.dao.Language
     */
    @WebMethod
    @WebResult(name = "Language", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getLanguageByName", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguageByName")
    @ResponseWrapper(localName = "getLanguageByNameResponse", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguageByNameResponse")
    public Language getLanguageByName(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param country
     * @return
     *     returns java.util.List<us.opulo.p.dao.Language>
     */
    @WebMethod
    @WebResult(name = "Language", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getLanguagesByCountry", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguagesByCountry")
    @ResponseWrapper(localName = "getLanguagesByCountryResponse", targetNamespace = "http://p.opulo.us/soap/language", className = "us.opulo.p.soap.language.GetLanguagesByCountryResponse")
    public List<Language> getLanguagesByCountry(
        @WebParam(name = "Country", targetNamespace = "http://p.opulo.us/dao")
        Country country);

}
