
package us.opulo.p.soap.country;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.opulo.p.soap.country package. 
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

    private final static QName _GetCountriesOnContinentResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesOnContinentResponse");
    private final static QName _GetCountriesOnContinentsResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesOnContinentsResponse");
    private final static QName _GetCountryWithCodeResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountryWithCodeResponse");
    private final static QName _GetCountriesWithCodesResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesWithCodesResponse");
    private final static QName _GetCountriesOnContinent_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesOnContinent");
    private final static QName _GetCountriesOnContinents_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesOnContinents");
    private final static QName _GetCountriesWithCodes_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesWithCodes");
    private final static QName _GetCountryWithCode_QNAME = new QName("http://p.opulo.us/soap/country", "getCountryWithCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.country
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountriesWithCodes }
     * 
     */
    public GetCountriesWithCodes createGetCountriesWithCodes() {
        return new GetCountriesWithCodes();
    }

    /**
     * Create an instance of {@link GetCountryWithCode }
     * 
     */
    public GetCountryWithCode createGetCountryWithCode() {
        return new GetCountryWithCode();
    }

    /**
     * Create an instance of {@link GetCountriesWithCodesResponse }
     * 
     */
    public GetCountriesWithCodesResponse createGetCountriesWithCodesResponse() {
        return new GetCountriesWithCodesResponse();
    }

    /**
     * Create an instance of {@link GetCountriesOnContinent }
     * 
     */
    public GetCountriesOnContinent createGetCountriesOnContinent() {
        return new GetCountriesOnContinent();
    }

    /**
     * Create an instance of {@link GetCountriesOnContinentsResponse }
     * 
     */
    public GetCountriesOnContinentsResponse createGetCountriesOnContinentsResponse() {
        return new GetCountriesOnContinentsResponse();
    }

    /**
     * Create an instance of {@link GetCountriesOnContinents }
     * 
     */
    public GetCountriesOnContinents createGetCountriesOnContinents() {
        return new GetCountriesOnContinents();
    }

    /**
     * Create an instance of {@link GetCountriesOnContinentResponse }
     * 
     */
    public GetCountriesOnContinentResponse createGetCountriesOnContinentResponse() {
        return new GetCountriesOnContinentResponse();
    }

    /**
     * Create an instance of {@link GetCountryWithCodeResponse }
     * 
     */
    public GetCountryWithCodeResponse createGetCountryWithCodeResponse() {
        return new GetCountryWithCodeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesOnContinentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesOnContinentResponse")
    public JAXBElement<GetCountriesOnContinentResponse> createGetCountriesOnContinentResponse(GetCountriesOnContinentResponse value) {
        return new JAXBElement<GetCountriesOnContinentResponse>(_GetCountriesOnContinentResponse_QNAME, GetCountriesOnContinentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesOnContinentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesOnContinentsResponse")
    public JAXBElement<GetCountriesOnContinentsResponse> createGetCountriesOnContinentsResponse(GetCountriesOnContinentsResponse value) {
        return new JAXBElement<GetCountriesOnContinentsResponse>(_GetCountriesOnContinentsResponse_QNAME, GetCountriesOnContinentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryWithCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountryWithCodeResponse")
    public JAXBElement<GetCountryWithCodeResponse> createGetCountryWithCodeResponse(GetCountryWithCodeResponse value) {
        return new JAXBElement<GetCountryWithCodeResponse>(_GetCountryWithCodeResponse_QNAME, GetCountryWithCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWithCodesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesWithCodesResponse")
    public JAXBElement<GetCountriesWithCodesResponse> createGetCountriesWithCodesResponse(GetCountriesWithCodesResponse value) {
        return new JAXBElement<GetCountriesWithCodesResponse>(_GetCountriesWithCodesResponse_QNAME, GetCountriesWithCodesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesOnContinent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesOnContinent")
    public JAXBElement<GetCountriesOnContinent> createGetCountriesOnContinent(GetCountriesOnContinent value) {
        return new JAXBElement<GetCountriesOnContinent>(_GetCountriesOnContinent_QNAME, GetCountriesOnContinent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesOnContinents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesOnContinents")
    public JAXBElement<GetCountriesOnContinents> createGetCountriesOnContinents(GetCountriesOnContinents value) {
        return new JAXBElement<GetCountriesOnContinents>(_GetCountriesOnContinents_QNAME, GetCountriesOnContinents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWithCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesWithCodes")
    public JAXBElement<GetCountriesWithCodes> createGetCountriesWithCodes(GetCountriesWithCodes value) {
        return new JAXBElement<GetCountriesWithCodes>(_GetCountriesWithCodes_QNAME, GetCountriesWithCodes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryWithCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountryWithCode")
    public JAXBElement<GetCountryWithCode> createGetCountryWithCode(GetCountryWithCode value) {
        return new JAXBElement<GetCountryWithCode>(_GetCountryWithCode_QNAME, GetCountryWithCode.class, null, value);
    }

}
