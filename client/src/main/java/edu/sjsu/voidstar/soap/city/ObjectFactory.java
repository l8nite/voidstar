
package edu.sjsu.voidstar.soap.city;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.soap.city package. 
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

    private final static QName _GetCityByCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByCountryResponse");
    private final static QName _City_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "City");
    private final static QName _GetCityByCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByCountry");
    private final static QName _Country_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "Country");
    private final static QName _GetCityById_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityById");
    private final static QName _GetCityByIdResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByIdResponse");
    private final static QName _GetCityByName_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByName");
    private final static QName _GetCityByNameResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.soap.city
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCityByNameResponse }
     * 
     */
    public GetCityByNameResponse createGetCityByNameResponse() {
        return new GetCityByNameResponse();
    }

    /**
     * Create an instance of {@link GetCityByCountry }
     * 
     */
    public GetCityByCountry createGetCityByCountry() {
        return new GetCityByCountry();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link GetCityByName }
     * 
     */
    public GetCityByName createGetCityByName() {
        return new GetCityByName();
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
     * Create an instance of {@link GetCityByCountryResponse }
     * 
     */
    public GetCityByCountryResponse createGetCityByCountryResponse() {
        return new GetCityByCountryResponse();
    }

    /**
     * Create an instance of {@link GetCityByIdResponse }
     * 
     */
    public GetCityByIdResponse createGetCityByIdResponse() {
        return new GetCityByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByCountryResponse")
    public JAXBElement<GetCityByCountryResponse> createGetCityByCountryResponse(GetCityByCountryResponse value) {
        return new JAXBElement<GetCityByCountryResponse>(_GetCityByCountryResponse_QNAME, GetCityByCountryResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByCountry")
    public JAXBElement<GetCityByCountry> createGetCityByCountry(GetCityByCountry value) {
        return new JAXBElement<GetCityByCountry>(_GetCityByCountry_QNAME, GetCityByCountry.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByIdResponse")
    public JAXBElement<GetCityByIdResponse> createGetCityByIdResponse(GetCityByIdResponse value) {
        return new JAXBElement<GetCityByIdResponse>(_GetCityByIdResponse_QNAME, GetCityByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByName")
    public JAXBElement<GetCityByName> createGetCityByName(GetCityByName value) {
        return new JAXBElement<GetCityByName>(_GetCityByName_QNAME, GetCityByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCityByNameResponse")
    public JAXBElement<GetCityByNameResponse> createGetCityByNameResponse(GetCityByNameResponse value) {
        return new JAXBElement<GetCityByNameResponse>(_GetCityByNameResponse_QNAME, GetCityByNameResponse.class, null, value);
    }

}
