
package us.opulo.p.soap.country;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import us.opulo.p.dao.Country;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CountryService", targetNamespace = "http://p.opulo.us/soap/country")
@XmlSeeAlso({
    us.opulo.p.dao.ObjectFactory.class,
    us.opulo.p.soap.country.ObjectFactory.class
})
public interface CountryService {


    /**
     * 
     * @param countryCodes
     * @return
     *     returns java.util.List<us.opulo.p.dao.Country>
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountriesWithCodes", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesWithCodes")
    @ResponseWrapper(localName = "getCountriesWithCodesResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesWithCodesResponse")
    @Action(input = "http://p.opulo.us/soap/country/CountryService/getCountriesWithCodesRequest", output = "http://p.opulo.us/soap/country/CountryService/getCountriesWithCodesResponse")
    public List<Country> getCountriesWithCodes(
        @WebParam(name = "countryCodes", targetNamespace = "")
        List<String> countryCodes);

    /**
     * 
     * @param continent
     * @return
     *     returns java.util.List<us.opulo.p.dao.Country>
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountriesOnContinent", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesOnContinent")
    @ResponseWrapper(localName = "getCountriesOnContinentResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesOnContinentResponse")
    @Action(input = "http://p.opulo.us/soap/country/CountryService/getCountriesOnContinentRequest", output = "http://p.opulo.us/soap/country/CountryService/getCountriesOnContinentResponse")
    public List<Country> getCountriesOnContinent(
        @WebParam(name = "continent", targetNamespace = "")
        String continent);

    /**
     * 
     * @param continents
     * @return
     *     returns java.util.List<us.opulo.p.dao.Country>
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountriesOnContinents", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesOnContinents")
    @ResponseWrapper(localName = "getCountriesOnContinentsResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountriesOnContinentsResponse")
    @Action(input = "http://p.opulo.us/soap/country/CountryService/getCountriesOnContinentsRequest", output = "http://p.opulo.us/soap/country/CountryService/getCountriesOnContinentsResponse")
    public List<Country> getCountriesOnContinents(
        @WebParam(name = "continents", targetNamespace = "")
        List<String> continents);

    /**
     * 
     * @param code
     * @return
     *     returns us.opulo.p.dao.Country
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getCountryWithCode", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountryWithCode")
    @ResponseWrapper(localName = "getCountryWithCodeResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetCountryWithCodeResponse")
    @Action(input = "http://p.opulo.us/soap/country/CountryService/getCountryWithCodeRequest", output = "http://p.opulo.us/soap/country/CountryService/getCountryWithCodeResponse")
    public Country getCountryWithCode(
        @WebParam(name = "code", targetNamespace = "")
        String code);

    /**
     * 
     * @return
     *     returns java.util.List<us.opulo.p.dao.Country>
     */
    @WebMethod
    @WebResult(name = "Country", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getAllCountries", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetAllCountries")
    @ResponseWrapper(localName = "getAllCountriesResponse", targetNamespace = "http://p.opulo.us/soap/country", className = "us.opulo.p.soap.country.GetAllCountriesResponse")
    @Action(input = "http://p.opulo.us/soap/country/CountryService/getAllCountriesRequest", output = "http://p.opulo.us/soap/country/CountryService/getAllCountriesResponse")
    public List<Country> getAllCountries();

}
