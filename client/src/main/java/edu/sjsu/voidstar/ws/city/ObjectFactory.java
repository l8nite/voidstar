
package edu.sjsu.voidstar.ws.city;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.city package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _City_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "City");
    private final static QName _GetCitiesByName_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCitiesByName");
    private final static QName _Country_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "Country");
    private final static QName _GetCityById_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityById");
    private final static QName _GetCitiesByNameResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCitiesByNameResponse");
    private final static QName _GetCitiesByCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCitiesByCountryResponse");
    private final static QName _GetCitiesByCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCitiesByCountry");
    private final static QName _GetCityByIdResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.city
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCitiesByNameResponse }
     * 
     */
    public GetCitiesByNameResponse createGetCitiesByNameResponse() {
        return new GetCitiesByNameResponse();
    }

    /**
     * Create an instance of {@link GetCitiesByCountryResponse }
     * 
     */
    public GetCitiesByCountryResponse createGetCitiesByCountryResponse() {
        return new GetCitiesByCountryResponse();
    }

    /**
     * Create an instance of {@link GetCitiesByName }
     * 
     */
    public GetCitiesByName createGetCitiesByName() {
        return new GetCitiesByName();
    }

    /**
     * Create an instance of {@link GetCitiesByCountry }
     * 
     */
    public GetCitiesByCountry createGetCitiesByCountry() {
        return new GetCitiesByCountry();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link GetCityById }
     * 
     */
    public GetCityById createGetCityById() {
        return new GetCityById();
    }

    /**
     * Create an instance of {@link GetCityByIdResponse }
     * 
     */
    public GetCityByIdResponse createGetCityByIdResponse() {
        return new GetCityByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCitiesByName")
    public JAXBElement<GetCitiesByName> createGetCitiesByName(GetCitiesByName value) {
        return new JAXBElement<GetCitiesByName>(_GetCitiesByName_QNAME, GetCitiesByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "Country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityById")
    public JAXBElement<GetCityById> createGetCityById(GetCityById value) {
        return new JAXBElement<GetCityById>(_GetCityById_QNAME, GetCityById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCitiesByNameResponse")
    public JAXBElement<GetCitiesByNameResponse> createGetCitiesByNameResponse(GetCitiesByNameResponse value) {
        return new JAXBElement<GetCitiesByNameResponse>(_GetCitiesByNameResponse_QNAME, GetCitiesByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCitiesByCountryResponse")
    public JAXBElement<GetCitiesByCountryResponse> createGetCitiesByCountryResponse(GetCitiesByCountryResponse value) {
        return new JAXBElement<GetCitiesByCountryResponse>(_GetCitiesByCountryResponse_QNAME, GetCitiesByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCitiesByCountry")
    public JAXBElement<GetCitiesByCountry> createGetCitiesByCountry(GetCitiesByCountry value) {
        return new JAXBElement<GetCitiesByCountry>(_GetCitiesByCountry_QNAME, GetCitiesByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByIdResponse")
    public JAXBElement<GetCityByIdResponse> createGetCityByIdResponse(GetCityByIdResponse value) {
        return new JAXBElement<GetCityByIdResponse>(_GetCityByIdResponse_QNAME, GetCityByIdResponse.class, null, value);
    }

}
