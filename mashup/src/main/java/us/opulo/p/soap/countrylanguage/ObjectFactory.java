
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

    private final static QName _GetCountryLanguagesForLanguages_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForLanguages");
    private final static QName _GetCountryLanguagesForLanguage_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForLanguage");
    private final static QName _GetAllCountryLanguagesResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getAllCountryLanguagesResponse");
    private final static QName _GetAllCountryLanguages_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getAllCountryLanguages");
    private final static QName _GetCountryLanguagesForCountryResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForCountryResponse");
    private final static QName _GetCountryLanguagesForCountriesResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForCountriesResponse");
    private final static QName _GetCountryLanguagesForCountries_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForCountries");
    private final static QName _GetCountryLanguagesForLanguagesResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForLanguagesResponse");
    private final static QName _GetCountryLanguagesForLanguageResponse_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForLanguageResponse");
    private final static QName _GetCountryLanguagesForCountry_QNAME = new QName("http://p.opulo.us/soap/countrylanguage", "getCountryLanguagesForCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.countrylanguage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForLanguageResponse }
     * 
     */
    public GetCountryLanguagesForLanguageResponse createGetCountryLanguagesForLanguageResponse() {
        return new GetCountryLanguagesForLanguageResponse();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForLanguage }
     * 
     */
    public GetCountryLanguagesForLanguage createGetCountryLanguagesForLanguage() {
        return new GetCountryLanguagesForLanguage();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForLanguages }
     * 
     */
    public GetCountryLanguagesForLanguages createGetCountryLanguagesForLanguages() {
        return new GetCountryLanguagesForLanguages();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForCountries }
     * 
     */
    public GetCountryLanguagesForCountries createGetCountryLanguagesForCountries() {
        return new GetCountryLanguagesForCountries();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForLanguagesResponse }
     * 
     */
    public GetCountryLanguagesForLanguagesResponse createGetCountryLanguagesForLanguagesResponse() {
        return new GetCountryLanguagesForLanguagesResponse();
    }

    /**
     * Create an instance of {@link GetAllCountryLanguages }
     * 
     */
    public GetAllCountryLanguages createGetAllCountryLanguages() {
        return new GetAllCountryLanguages();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForCountriesResponse }
     * 
     */
    public GetCountryLanguagesForCountriesResponse createGetCountryLanguagesForCountriesResponse() {
        return new GetCountryLanguagesForCountriesResponse();
    }

    /**
     * Create an instance of {@link GetAllCountryLanguagesResponse }
     * 
     */
    public GetAllCountryLanguagesResponse createGetAllCountryLanguagesResponse() {
        return new GetAllCountryLanguagesResponse();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForCountry }
     * 
     */
    public GetCountryLanguagesForCountry createGetCountryLanguagesForCountry() {
        return new GetCountryLanguagesForCountry();
    }

    /**
     * Create an instance of {@link GetCountryLanguagesForCountryResponse }
     * 
     */
    public GetCountryLanguagesForCountryResponse createGetCountryLanguagesForCountryResponse() {
        return new GetCountryLanguagesForCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForLanguages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForLanguages")
    public JAXBElement<GetCountryLanguagesForLanguages> createGetCountryLanguagesForLanguages(GetCountryLanguagesForLanguages value) {
        return new JAXBElement<GetCountryLanguagesForLanguages>(_GetCountryLanguagesForLanguages_QNAME, GetCountryLanguagesForLanguages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForLanguage")
    public JAXBElement<GetCountryLanguagesForLanguage> createGetCountryLanguagesForLanguage(GetCountryLanguagesForLanguage value) {
        return new JAXBElement<GetCountryLanguagesForLanguage>(_GetCountryLanguagesForLanguage_QNAME, GetCountryLanguagesForLanguage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountryLanguagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getAllCountryLanguagesResponse")
    public JAXBElement<GetAllCountryLanguagesResponse> createGetAllCountryLanguagesResponse(GetAllCountryLanguagesResponse value) {
        return new JAXBElement<GetAllCountryLanguagesResponse>(_GetAllCountryLanguagesResponse_QNAME, GetAllCountryLanguagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCountryLanguages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getAllCountryLanguages")
    public JAXBElement<GetAllCountryLanguages> createGetAllCountryLanguages(GetAllCountryLanguages value) {
        return new JAXBElement<GetAllCountryLanguages>(_GetAllCountryLanguages_QNAME, GetAllCountryLanguages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForCountryResponse")
    public JAXBElement<GetCountryLanguagesForCountryResponse> createGetCountryLanguagesForCountryResponse(GetCountryLanguagesForCountryResponse value) {
        return new JAXBElement<GetCountryLanguagesForCountryResponse>(_GetCountryLanguagesForCountryResponse_QNAME, GetCountryLanguagesForCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForCountriesResponse")
    public JAXBElement<GetCountryLanguagesForCountriesResponse> createGetCountryLanguagesForCountriesResponse(GetCountryLanguagesForCountriesResponse value) {
        return new JAXBElement<GetCountryLanguagesForCountriesResponse>(_GetCountryLanguagesForCountriesResponse_QNAME, GetCountryLanguagesForCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForCountries")
    public JAXBElement<GetCountryLanguagesForCountries> createGetCountryLanguagesForCountries(GetCountryLanguagesForCountries value) {
        return new JAXBElement<GetCountryLanguagesForCountries>(_GetCountryLanguagesForCountries_QNAME, GetCountryLanguagesForCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForLanguagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForLanguagesResponse")
    public JAXBElement<GetCountryLanguagesForLanguagesResponse> createGetCountryLanguagesForLanguagesResponse(GetCountryLanguagesForLanguagesResponse value) {
        return new JAXBElement<GetCountryLanguagesForLanguagesResponse>(_GetCountryLanguagesForLanguagesResponse_QNAME, GetCountryLanguagesForLanguagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForLanguageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForLanguageResponse")
    public JAXBElement<GetCountryLanguagesForLanguageResponse> createGetCountryLanguagesForLanguageResponse(GetCountryLanguagesForLanguageResponse value) {
        return new JAXBElement<GetCountryLanguagesForLanguageResponse>(_GetCountryLanguagesForLanguageResponse_QNAME, GetCountryLanguagesForLanguageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryLanguagesForCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/countrylanguage", name = "getCountryLanguagesForCountry")
    public JAXBElement<GetCountryLanguagesForCountry> createGetCountryLanguagesForCountry(GetCountryLanguagesForCountry value) {
        return new JAXBElement<GetCountryLanguagesForCountry>(_GetCountryLanguagesForCountry_QNAME, GetCountryLanguagesForCountry.class, null, value);
    }

}
