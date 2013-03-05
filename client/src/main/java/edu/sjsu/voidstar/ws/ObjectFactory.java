
package edu.sjsu.voidstar.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws package. 
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
    private final static QName _GetCityById_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityById");
    private final static QName _GetCityByIdResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCityByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCityByIdResponse }
     * 
     */
    public GetCityByIdResponse createGetCityByIdResponse() {
        return new GetCityByIdResponse();
    }

    /**
     * Create an instance of {@link GetCityById }
     * 
     */
    public GetCityById createGetCityById() {
        return new GetCityById();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
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

}
