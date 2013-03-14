
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

    private final static QName _GetCountryByCode_QNAME = new QName("http://p.opulo.us/soap/country", "getCountryByCode");
    private final static QName _GetCountriesByContinentResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesByContinentResponse");
    private final static QName _GetCountryByCodeResponse_QNAME = new QName("http://p.opulo.us/soap/country", "getCountryByCodeResponse");
    private final static QName _GetCountriesByContinent_QNAME = new QName("http://p.opulo.us/soap/country", "getCountriesByContinent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.country
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryByCode }
     * 
     */
    public GetCountryByCode createGetCountryByCode() {
        return new GetCountryByCode();
    }

    /**
     * Create an instance of {@link GetCountriesByContinentResponse }
     * 
     */
    public GetCountriesByContinentResponse createGetCountriesByContinentResponse() {
        return new GetCountriesByContinentResponse();
    }

    /**
     * Create an instance of {@link GetCountryByCodeResponse }
     * 
     */
    public GetCountryByCodeResponse createGetCountryByCodeResponse() {
        return new GetCountryByCodeResponse();
    }

    /**
     * Create an instance of {@link GetCountriesByContinent }
     * 
     */
    public GetCountriesByContinent createGetCountriesByContinent() {
        return new GetCountriesByContinent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountryByCode")
    public JAXBElement<GetCountryByCode> createGetCountryByCode(GetCountryByCode value) {
        return new JAXBElement<GetCountryByCode>(_GetCountryByCode_QNAME, GetCountryByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesByContinentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesByContinentResponse")
    public JAXBElement<GetCountriesByContinentResponse> createGetCountriesByContinentResponse(GetCountriesByContinentResponse value) {
        return new JAXBElement<GetCountriesByContinentResponse>(_GetCountriesByContinentResponse_QNAME, GetCountriesByContinentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountryByCodeResponse")
    public JAXBElement<GetCountryByCodeResponse> createGetCountryByCodeResponse(GetCountryByCodeResponse value) {
        return new JAXBElement<GetCountryByCodeResponse>(_GetCountryByCodeResponse_QNAME, GetCountryByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesByContinent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/country", name = "getCountriesByContinent")
    public JAXBElement<GetCountriesByContinent> createGetCountriesByContinent(GetCountriesByContinent value) {
        return new JAXBElement<GetCountriesByContinent>(_GetCountriesByContinent_QNAME, GetCountriesByContinent.class, null, value);
    }

}
