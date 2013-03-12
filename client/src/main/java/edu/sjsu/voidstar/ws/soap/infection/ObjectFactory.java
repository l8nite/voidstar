
package edu.sjsu.voidstar.ws.soap.infection;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.soap.infection package. 
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

    private final static QName _GetInfectionsByCountry_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsByCountry");
    private final static QName _GetInfectionByCityResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionByCityResponse");
    private final static QName _GetInfectionByCity_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionByCity");
    private final static QName _GetInfectionsByCountryResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsByCountryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.soap.infection
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfectionByCity }
     * 
     */
    public GetInfectionByCity createGetInfectionByCity() {
        return new GetInfectionByCity();
    }

    /**
     * Create an instance of {@link GetInfectionByCityResponse }
     * 
     */
    public GetInfectionByCityResponse createGetInfectionByCityResponse() {
        return new GetInfectionByCityResponse();
    }

    /**
     * Create an instance of {@link GetInfectionsByCountryResponse }
     * 
     */
    public GetInfectionsByCountryResponse createGetInfectionsByCountryResponse() {
        return new GetInfectionsByCountryResponse();
    }

    /**
     * Create an instance of {@link GetInfectionsByCountry }
     * 
     */
    public GetInfectionsByCountry createGetInfectionsByCountry() {
        return new GetInfectionsByCountry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsByCountry")
    public JAXBElement<GetInfectionsByCountry> createGetInfectionsByCountry(GetInfectionsByCountry value) {
        return new JAXBElement<GetInfectionsByCountry>(_GetInfectionsByCountry_QNAME, GetInfectionsByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionByCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionByCityResponse")
    public JAXBElement<GetInfectionByCityResponse> createGetInfectionByCityResponse(GetInfectionByCityResponse value) {
        return new JAXBElement<GetInfectionByCityResponse>(_GetInfectionByCityResponse_QNAME, GetInfectionByCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionByCity")
    public JAXBElement<GetInfectionByCity> createGetInfectionByCity(GetInfectionByCity value) {
        return new JAXBElement<GetInfectionByCity>(_GetInfectionByCity_QNAME, GetInfectionByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsByCountryResponse")
    public JAXBElement<GetInfectionsByCountryResponse> createGetInfectionsByCountryResponse(GetInfectionsByCountryResponse value) {
        return new JAXBElement<GetInfectionsByCountryResponse>(_GetInfectionsByCountryResponse_QNAME, GetInfectionsByCountryResponse.class, null, value);
    }

}
