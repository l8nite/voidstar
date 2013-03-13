
package us.opulo.p.soap.countrylanguage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.opulo.p.soap.countrylanguage package. 
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

    private final static QName _GetCountryLanguagesByLanguageResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesByLanguageResponse");
    private final static QName _GetCountryLanguagesByCountry_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesByCountry");
    private final static QName _GetCountryLanguagesByCountryResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesByCountryResponse");
    private final static QName _GetCountryLanguagesByLanguage_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesByLanguage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.countrylanguage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryLanguagesByCountryResponse }
     * 
     */
    public GetCountryLanguagesByCountryResponse createGetCountryLanguagesByCountryResponse() {
        return new GetCountryLanguagesByCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesByLanguageResponse }
     * 
     */
    public GetCountryLanguagesByLanguageResponse createGetCountryLanguagesByLanguageResponse() {
        return new GetCountryLanguagesByLanguageResponse();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesByLanguage }
     * 
     */
    public GetCountryLanguagesByLanguage createGetCountryLanguagesByLanguage() {
        return new GetCountryLanguagesByLanguage();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesByCountry }
     * 
     */
    public GetCountryLanguagesByCountry createGetCountryLanguagesByCountry() {
        return new GetCountryLanguagesByCountry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesByLanguageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesByLanguageResponse")
    public JAXBElement<GetCountryLanguagesByLanguageResponse> createGetCountryLanguagesByLanguageResponse(GetCountryLanguagesByLanguageResponse value) {
        return new JAXBElement<GetCountryLanguagesByLanguageResponse>(_GetCountryLanguagesByLanguageResponse_QNAME, GetCountryLanguagesByLanguageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesByCountry")
    public JAXBElement<GetCountryLanguagesByCountry> createGetCountryLanguagesByCountry(GetCountryLanguagesByCountry value) {
        return new JAXBElement<GetCountryLanguagesByCountry>(_GetCountryLanguagesByCountry_QNAME, GetCountryLanguagesByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesByCountryResponse")
    public JAXBElement<GetCountryLanguagesByCountryResponse> createGetCountryLanguagesByCountryResponse(GetCountryLanguagesByCountryResponse value) {
        return new JAXBElement<GetCountryLanguagesByCountryResponse>(_GetCountryLanguagesByCountryResponse_QNAME, GetCountryLanguagesByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesByLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesByLanguage")
    public JAXBElement<GetCountryLanguagesByLanguage> createGetCountryLanguagesByLanguage(GetCountryLanguagesByLanguage value) {
        return new JAXBElement<GetCountryLanguagesByLanguage>(_GetCountryLanguagesByLanguage_QNAME, GetCountryLanguagesByLanguage.class, null, value);
    }

}
