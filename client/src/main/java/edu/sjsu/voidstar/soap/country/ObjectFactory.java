
package edu.sjsu.voidstar.soap.country;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.soap.country package. 
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

    private final static QName _GetCountryByCodeResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCountryByCodeResponse");
    private final static QName _GetCountryByContinentResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCountryByContinentResponse");
    private final static QName _Country_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "Country");
    private final static QName _GetCountryByContinent_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCountryByContinent");
    private final static QName _GetCountryByCode_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getCountryByCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.soap.country
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryByContinent }
     * 
     */
    public GetCountryByContinent createGetCountryByContinent() {
        return new GetCountryByContinent();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link GetCountryByCode }
     * 
     */
    public GetCountryByCode createGetCountryByCode() {
        return new GetCountryByCode();
    }

    /**
     * Create an instance of {@link GetCountryByContinentResponse }
     * 
     */
    public GetCountryByContinentResponse createGetCountryByContinentResponse() {
        return new GetCountryByContinentResponse();
    }

    /**
     * Create an instance of {@link GetCountryByCodeResponse }
     * 
     */
    public GetCountryByCodeResponse createGetCountryByCodeResponse() {
        return new GetCountryByCodeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCountryByCodeResponse")
    public JAXBElement<GetCountryByCodeResponse> createGetCountryByCodeResponse(GetCountryByCodeResponse value) {
        return new JAXBElement<GetCountryByCodeResponse>(_GetCountryByCodeResponse_QNAME, GetCountryByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByContinentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCountryByContinentResponse")
    public JAXBElement<GetCountryByContinentResponse> createGetCountryByContinentResponse(GetCountryByContinentResponse value) {
        return new JAXBElement<GetCountryByContinentResponse>(_GetCountryByContinentResponse_QNAME, GetCountryByContinentResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByContinent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCountryByContinent")
    public JAXBElement<GetCountryByContinent> createGetCountryByContinent(GetCountryByContinent value) {
        return new JAXBElement<GetCountryByContinent>(_GetCountryByContinent_QNAME, GetCountryByContinent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getCountryByCode")
    public JAXBElement<GetCountryByCode> createGetCountryByCode(GetCountryByCode value) {
        return new JAXBElement<GetCountryByCode>(_GetCountryByCode_QNAME, GetCountryByCode.class, null, value);
    }

}
