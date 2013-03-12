
package edu.sjsu.voidstar.ws.soap.country;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import edu.sjsu.voidstar.ws.dao.Country;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CountryService", targetNamespace = "http://p.opulo.us/soap/country")
@XmlSeeAlso({
    edu.sjsu.voidstar.ws.dao.ObjectFactory.class,
    edu.sjsu.voidstar.ws.soap.country.ObjectFactory.class
})
public interface CountryService {


    /**
     * 
     * @param code
     * @return
     *     returns edu.sjsu.voidstar.ws.dao.Country
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountryByCode", targetNamespace = "http://p.opulo.us/soap/country", className = "edu.sjsu.voidstar.ws.soap.country.GetCountryByCode")
    @ResponseWrapper(localName = "getCountryByCodeResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "edu.sjsu.voidstar.ws.soap.country.GetCountryByCodeResponse")
    public Country getCountryByCode(
        @WebParam(name = "code", targetNamespace = "")
        String code);

    /**
     * 
     * @param continent
     * @return
     *     returns java.util.List<edu.sjsu.voidstar.ws.dao.Country>
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountriesByContinent", targetNamespace = "http://p.opulo.us/soap/country", className = "edu.sjsu.voidstar.ws.soap.country.GetCountriesByContinent")
    @ResponseWrapper(localName = "getCountriesByContinentResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "edu.sjsu.voidstar.ws.soap.country.GetCountriesByContinentResponse")
    public List<Country> getCountriesByContinent(
        @WebParam(name = "continent", targetNamespace = "")
        String continent);

}
