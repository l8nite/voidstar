
package edu.sjsu.voidstar.ws.soap.city;

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


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CityService", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city")
@XmlSeeAlso({
    edu.sjsu.voidstar.ws.dao.ObjectFactory.class,
    edu.sjsu.voidstar.ws.soap.city.ObjectFactory.class
})
public interface CityService {


    /**
     * 
     * @param id
     * @return
     *     returns edu.sjsu.voidstar.ws.dao.City
     */
    @WebMethod
    @WebResult(name = "City", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
    @RequestWrapper(localName = "getCityById", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCityById")
    @ResponseWrapper(localName = "getCityByIdResponse", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCityByIdResponse")
    @Action(input = "http://ws.voidstar.sjsu.edu/CityService/getCityByIdRequest", output = "http://ws.voidstar.sjsu.edu/CityService/getCityByIdResponse")
    public City getCityById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param name
     * @return
     *     returns java.util.List<edu.sjsu.voidstar.ws.dao.City>
     */
    @WebMethod
    @WebResult(name = "City", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
    @RequestWrapper(localName = "getCitiesByName", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCitiesByName")
    @ResponseWrapper(localName = "getCitiesByNameResponse", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCitiesByNameResponse")
    @Action(input = "http://ws.voidstar.sjsu.edu/CityService/getCitiesByNameRequest", output = "http://ws.voidstar.sjsu.edu/CityService/getCitiesByNameResponse")
    public List<City> getCitiesByName(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param country
     * @return
     *     returns java.util.List<edu.sjsu.voidstar.ws.dao.City>
     */
    @WebMethod
    @WebResult(name = "City", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
    @RequestWrapper(localName = "getCitiesByCountry", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCitiesByCountry")
    @ResponseWrapper(localName = "getCitiesByCountryResponse", targetNamespace = "http://ws.voidstar.sjsu.edu/soap/city", className = "edu.sjsu.voidstar.ws.soap.city.GetCitiesByCountryResponse")
    @Action(input = "http://ws.voidstar.sjsu.edu/CitySer113vice/getCitiesByCountryRequest", output = "http://ws.voidstar.sjsu.edu/CityService/getCitiesByCountryResponse")
    public List<City> getCitiesByCountry(
        @WebParam(name = "Country", targetNamespace = "http://ws.voidstar.sjsu.edu/dao")
        Country country);

}
