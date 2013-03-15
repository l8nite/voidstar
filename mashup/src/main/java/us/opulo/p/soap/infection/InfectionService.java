
package us.opulo.p.soap.infection;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Infection;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InfectionService", targetNamespace = "http://p.opulo.us/soap/infection")
@XmlSeeAlso({
    us.opulo.p.dao.ObjectFactory.class,
    us.opulo.p.soap.infection.ObjectFactory.class
})
public interface InfectionService {


    /**
     * 
     * @param city
     * @return
     *     returns us.opulo.p.dao.Infection
     */
    @WebMethod
    @WebResult(name = "Infection", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getInfectionByCity", targetNamespace = "http://p.opulo.us/soap/infection", className = "us.opulo.p.soap.infection.GetInfectionByCity")
    @ResponseWrapper(localName = "getInfectionByCityResponse", targetNamespace = "http://p.opulo.us/soap/infection", className = "us.opulo.p.soap.infection.GetInfectionByCityResponse")
    @Action(input = "http://p.opulo.us/InfectionService/getInfectionByCityRequest", output = "http://p.opulo.us/InfectionService/getInfectionByCityResponse")
    public Infection getInfectionByCity(
        @WebParam(name = "City", targetNamespace = "http://p.opulo.us/dao")
        City city);

    /**
     * 
     * @param country
     * @return
     *     returns java.util.List<us.opulo.p.dao.Infection>
     */
    @WebMethod
    @WebResult(name = "Infection", targetNamespace = "http://p.opulo.us/dao")
    @RequestWrapper(localName = "getInfectionsByCountry", targetNamespace = "http://p.opulo.us/soap/infection", className = "us.opulo.p.soap.infection.GetInfectionsByCountry")
    @ResponseWrapper(localName = "getInfectionsByCountryResponse", targetNamespace = "http://p.opulo.us/soap/infection", className = "us.opulo.p.soap.infection.GetInfectionsByCountryResponse")
    @Action(input = "http://p.opulo.us/CityService/getInfectionsByCountryRequest", output = "http://p.opulo.us/CityService/getInfectionsByCountryResponse")
    public List<Infection> getInfectionsByCountry(
        @WebParam(name = "Country", targetNamespace = "http://p.opulo.us/dao")
        Country country);

}
