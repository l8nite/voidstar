
package edu.sjsu.voidstar.ws.soap.city;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.soap.city package. 
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

    private final static QName _GetCityByCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityByCountryResponse");
    private final static QName _GetCityByNameResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityByNameResponse");
    private final static QName _GetCityByIdResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityByIdResponse");
    private final static QName _GetCityById_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityById");
    private final static QName _GetCityByCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityByCountry");
    private final static QName _GetCityByName_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/city", "getCityByName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.soap.city
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCityByName }
     * 
     */
    public GetCityByName createGetCityByName() {
        return new GetCityByName();
    }

    /**
     * Create an instance of {@link GetCityByIdResponse }
     * 
     */
    public GetCityByIdResponse createGetCityByIdResponse() {
        return new GetCityByIdResponse();
    }

    /**
     * Create an instance of {@link GetCityByNameResponse }
     * 
     */
    public GetCityByNameResponse createGetCityByNameResponse() {
        return new GetCityByNameResponse();
    }

    /**
     * Create an instance of {@link GetCityById }
     * 
     */
    public GetCityById createGetCityById() {
        return new GetCityById();
    }

    /**
     * Create an instance of {@link GetCityByCountry }
     * 
     */
    public GetCityByCountry createGetCityByCountry() {
        return new GetCityByCountry();
    }

    /**
     * Create an instance of {@link GetCityByCountryResponse }
     * 
     */
    public GetCityByCountryResponse createGetCityByCountryResponse() {
        return new GetCityByCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityByCountryResponse")
    public JAXBElement<GetCityByCountryResponse> createGetCityByCountryResponse(GetCityByCountryResponse value) {
        return new JAXBElement<GetCityByCountryResponse>(_GetCityByCountryResponse_QNAME, GetCityByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityByNameResponse")
    public JAXBElement<GetCityByNameResponse> createGetCityByNameResponse(GetCityByNameResponse value) {
        return new JAXBElement<GetCityByNameResponse>(_GetCityByNameResponse_QNAME, GetCityByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityByIdResponse")
    public JAXBElement<GetCityByIdResponse> createGetCityByIdResponse(GetCityByIdResponse value) {
        return new JAXBElement<GetCityByIdResponse>(_GetCityByIdResponse_QNAME, GetCityByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityById")
    public JAXBElement<GetCityById> createGetCityById(GetCityById value) {
        return new JAXBElement<GetCityById>(_GetCityById_QNAME, GetCityById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityByCountry")
    public JAXBElement<GetCityByCountry> createGetCityByCountry(GetCityByCountry value) {
        return new JAXBElement<GetCityByCountry>(_GetCityByCountry_QNAME, GetCityByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/city", name = "getCityByName")
    public JAXBElement<GetCityByName> createGetCityByName(GetCityByName value) {
        return new JAXBElement<GetCityByName>(_GetCityByName_QNAME, GetCityByName.class, null, value);
    }

}
