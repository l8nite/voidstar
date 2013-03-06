
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

    private final static QName _InfectionsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/infection", "infectionsResponse");
    private final static QName _InfectionResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/infection", "infectionResponse");
    private final static QName _GetInfectionByCity_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/infection", "getInfectionByCity");
    private final static QName _GetInfectionsByCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/soap/infection", "getInfectionsByCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.soap.infection
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfectionsByCountry }
     * 
     */
    public GetInfectionsByCountry createGetInfectionsByCountry() {
        return new GetInfectionsByCountry();
    }

    /**
     * Create an instance of {@link InfectionResponse }
     * 
     */
    public InfectionResponse createInfectionResponse() {
        return new InfectionResponse();
    }

    /**
     * Create an instance of {@link GetInfectionByCity }
     * 
     */
    public GetInfectionByCity createGetInfectionByCity() {
        return new GetInfectionByCity();
    }

    /**
     * Create an instance of {@link InfectionsResponse }
     * 
     */
    public InfectionsResponse createInfectionsResponse() {
        return new InfectionsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/infection", name = "infectionsResponse")
    public JAXBElement<InfectionsResponse> createInfectionsResponse(InfectionsResponse value) {
        return new JAXBElement<InfectionsResponse>(_InfectionsResponse_QNAME, InfectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/infection", name = "infectionResponse")
    public JAXBElement<InfectionResponse> createInfectionResponse(InfectionResponse value) {
        return new JAXBElement<InfectionResponse>(_InfectionResponse_QNAME, InfectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/infection", name = "getInfectionByCity")
    public JAXBElement<GetInfectionByCity> createGetInfectionByCity(GetInfectionByCity value) {
        return new JAXBElement<GetInfectionByCity>(_GetInfectionByCity_QNAME, GetInfectionByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/soap/infection", name = "getInfectionsByCountry")
    public JAXBElement<GetInfectionsByCountry> createGetInfectionsByCountry(GetInfectionsByCountry value) {
        return new JAXBElement<GetInfectionsByCountry>(_GetInfectionsByCountry_QNAME, GetInfectionsByCountry.class, null, value);
    }

}
