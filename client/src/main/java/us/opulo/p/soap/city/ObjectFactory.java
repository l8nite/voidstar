
package us.opulo.p.soap.city;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.opulo.p.soap.city package. 
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

    private final static QName _GetCitiesByCountryResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesByCountryResponse");
    private final static QName _GetCityById_QNAME = new QName("http://p.opulo.us/soap/city", "getCityById");
    private final static QName _GetCitiesByCountry_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesByCountry");
    private final static QName _GetCityByIdResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCityByIdResponse");
    private final static QName _GetCitiesByName_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesByName");
    private final static QName _GetCitiesByNameResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.city
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link GetCitiesByNameResponse }
     * 
     */
    public GetCitiesByNameResponse createGetCitiesByNameResponse() {
        return new GetCitiesByNameResponse();
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
     * Create an instance of {@link GetCitiesByCountry }
     * 
     */
    public GetCitiesByCountry createGetCitiesByCountry() {
        return new GetCitiesByCountry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesByCountryResponse")
    public JAXBElement<GetCitiesByCountryResponse> createGetCitiesByCountryResponse(GetCitiesByCountryResponse value) {
        return new JAXBElement<GetCitiesByCountryResponse>(_GetCitiesByCountryResponse_QNAME, GetCitiesByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCityById")
    public JAXBElement<GetCityById> createGetCityById(GetCityById value) {
        return new JAXBElement<GetCityById>(_GetCityById_QNAME, GetCityById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesByCountry")
    public JAXBElement<GetCitiesByCountry> createGetCitiesByCountry(GetCitiesByCountry value) {
        return new JAXBElement<GetCitiesByCountry>(_GetCitiesByCountry_QNAME, GetCitiesByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCityByIdResponse")
    public JAXBElement<GetCityByIdResponse> createGetCityByIdResponse(GetCityByIdResponse value) {
        return new JAXBElement<GetCityByIdResponse>(_GetCityByIdResponse_QNAME, GetCityByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesByName")
    public JAXBElement<GetCitiesByName> createGetCitiesByName(GetCitiesByName value) {
        return new JAXBElement<GetCitiesByName>(_GetCitiesByName_QNAME, GetCitiesByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesByNameResponse")
    public JAXBElement<GetCitiesByNameResponse> createGetCitiesByNameResponse(GetCitiesByNameResponse value) {
        return new JAXBElement<GetCitiesByNameResponse>(_GetCitiesByNameResponse_QNAME, GetCitiesByNameResponse.class, null, value);
    }

}
