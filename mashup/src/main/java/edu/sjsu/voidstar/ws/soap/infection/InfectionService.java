
package edu.sjsu.voidstar.ws.soap.infection;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import edu.sjsu.voidstar.ws.dao.City;
import edu.sjsu.voidstar.ws.dao.Country;
import edu.sjsu.voidstar.ws.dao.Infection;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InfectionService", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/infection")
@XmlSeeAlso({
    edu.sjsu.voidstar.ws.dao.ObjectFactory.class,
    edu.sjsu.voidstar.ws.soap.infection.ObjectFactory.class
})
public interface InfectionService {


    /**
     * 
     * @param city
     * @return
     *     returns edu.sjsu.voidstar.ws.dao.Infection
     */
    @WebMethod
    @WebResult(name = "Infection", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
    @RequestWrapper(localName = "getInfectionByCity", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/infection", className = "edu.sjsu.voidstar.ws.soap.infection.GetInfectionByCity")
    @ResponseWrapper(localName = "getInfectionByCityResponse", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/infection", className = "edu.sjsu.voidstar.ws.soap.infection.GetInfectionByCityResponse")
    @Action(input = "http://ws.voidstar.sjsu.edu/InfectionService/getInfectionByCityRequest", output = "http://ws.voidstar.sjsu.edu/InfectionService/getInfectionByCityResponse")
    public Infection getInfectionByCity(
        @WebParam(name = "city", targetNamespace = "")
        City city);

    /**
     * 
     * @param country
     * @return
     *     returns java.util.List<edu.sjsu.voidstar.ws.dao.Infection>
     */
    @WebMethod
    @WebResult(name = "Infection", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
    @RequestWrapper(localName = "getInfectionsByCountry", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/infection", className = "edu.sjsu.voidstar.ws.soap.infection.GetInfectionsByCountry")
    @ResponseWrapper(localName = "getInfectionsByCountryResponse", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/infection", className = "edu.sjsu.voidstar.ws.soap.infection.GetInfectionsByCountryResponse")
    @Action(input = "http://ws.voidstar.sjsu.edu/CityService/getInfectionsByCountryRequest", output = "http://ws.voidstar.sjsu.edu/CityService/getInfectionsByCountryResponse")
    public List<Infection> getInfectionsByCountry(
        @WebParam(name = "Country", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
        Country country);

}
