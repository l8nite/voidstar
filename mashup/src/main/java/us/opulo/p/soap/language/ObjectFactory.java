
package us.opulo.p.soap.language;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.opulo.p.soap.language package. 
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

    private final static QName _GetLanguagesWithIds_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesWithIds");
    private final static QName _GetAllLanguagesResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getAllLanguagesResponse");
    private final static QName _GetLanguageWithName_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageWithName");
    private final static QName _GetLanguageWithId_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageWithId");
    private final static QName _GetLanguagesInCountryResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesInCountryResponse");
    private final static QName _GetLanguageWithIdResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageWithIdResponse");
    private final static QName _GetLanguagesWithNamesResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesWithNamesResponse");
    private final static QName _GetLanguagesInCountries_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesInCountries");
    private final static QName _GetLanguagesInCountry_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesInCountry");
    private final static QName _GetLanguageWithNameResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageWithNameResponse");
    private final static QName _GetLanguagesInCountriesResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesInCountriesResponse");
    private final static QName _GetLanguagesWithIdsResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesWithIdsResponse");
    private final static QName _GetLanguagesWithNames_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesWithNames");
    private final static QName _GetAllLanguages_QNAME = new QName("http://p.opulo.us/soap/language", "getAllLanguages");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.language
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLanguageWithNameResponse }
     * 
     */
    public GetLanguageWithNameResponse createGetLanguageWithNameResponse() {
        return new GetLanguageWithNameResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesWithNamesResponse }
     * 
     */
    public GetLanguagesWithNamesResponse createGetLanguagesWithNamesResponse() {
        return new GetLanguagesWithNamesResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesInCountries }
     * 
     */
    public GetLanguagesInCountries createGetLanguagesInCountries() {
        return new GetLanguagesInCountries();
    }

    /**
     * Create an instance of {@link GetLanguagesInCountry }
     * 
     */
    public GetLanguagesInCountry createGetLanguagesInCountry() {
        return new GetLanguagesInCountry();
    }

    /**
     * Create an instance of {@link GetLanguagesInCountriesResponse }
     * 
     */
    public GetLanguagesInCountriesResponse createGetLanguagesInCountriesResponse() {
        return new GetLanguagesInCountriesResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesWithIdsResponse }
     * 
     */
    public GetLanguagesWithIdsResponse createGetLanguagesWithIdsResponse() {
        return new GetLanguagesWithIdsResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesWithNames }
     * 
     */
    public GetLanguagesWithNames createGetLanguagesWithNames() {
        return new GetLanguagesWithNames();
    }

    /**
     * Create an instance of {@link GetAllLanguages }
     * 
     */
    public GetAllLanguages createGetAllLanguages() {
        return new GetAllLanguages();
    }

    /**
     * Create an instance of {@link GetLanguageWithIdResponse }
     * 
     */
    public GetLanguageWithIdResponse createGetLanguageWithIdResponse() {
        return new GetLanguageWithIdResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesInCountryResponse }
     * 
     */
    public GetLanguagesInCountryResponse createGetLanguagesInCountryResponse() {
        return new GetLanguagesInCountryResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesWithIds }
     * 
     */
    public GetLanguagesWithIds createGetLanguagesWithIds() {
        return new GetLanguagesWithIds();
    }

    /**
     * Create an instance of {@link GetAllLanguagesResponse }
     * 
     */
    public GetAllLanguagesResponse createGetAllLanguagesResponse() {
        return new GetAllLanguagesResponse();
    }

    /**
     * Create an instance of {@link GetLanguageWithId }
     * 
     */
    public GetLanguageWithId createGetLanguageWithId() {
        return new GetLanguageWithId();
    }

    /**
     * Create an instance of {@link GetLanguageWithName }
     * 
     */
    public GetLanguageWithName createGetLanguageWithName() {
        return new GetLanguageWithName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesWithIds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesWithIds")
    public JAXBElement<GetLanguagesWithIds> createGetLanguagesWithIds(GetLanguagesWithIds value) {
        return new JAXBElement<GetLanguagesWithIds>(_GetLanguagesWithIds_QNAME, GetLanguagesWithIds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLanguagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getAllLanguagesResponse")
    public JAXBElement<GetAllLanguagesResponse> createGetAllLanguagesResponse(GetAllLanguagesResponse value) {
        return new JAXBElement<GetAllLanguagesResponse>(_GetAllLanguagesResponse_QNAME, GetAllLanguagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageWithName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageWithName")
    public JAXBElement<GetLanguageWithName> createGetLanguageWithName(GetLanguageWithName value) {
        return new JAXBElement<GetLanguageWithName>(_GetLanguageWithName_QNAME, GetLanguageWithName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageWithId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageWithId")
    public JAXBElement<GetLanguageWithId> createGetLanguageWithId(GetLanguageWithId value) {
        return new JAXBElement<GetLanguageWithId>(_GetLanguageWithId_QNAME, GetLanguageWithId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesInCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesInCountryResponse")
    public JAXBElement<GetLanguagesInCountryResponse> createGetLanguagesInCountryResponse(GetLanguagesInCountryResponse value) {
        return new JAXBElement<GetLanguagesInCountryResponse>(_GetLanguagesInCountryResponse_QNAME, GetLanguagesInCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageWithIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageWithIdResponse")
    public JAXBElement<GetLanguageWithIdResponse> createGetLanguageWithIdResponse(GetLanguageWithIdResponse value) {
        return new JAXBElement<GetLanguageWithIdResponse>(_GetLanguageWithIdResponse_QNAME, GetLanguageWithIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesWithNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesWithNamesResponse")
    public JAXBElement<GetLanguagesWithNamesResponse> createGetLanguagesWithNamesResponse(GetLanguagesWithNamesResponse value) {
        return new JAXBElement<GetLanguagesWithNamesResponse>(_GetLanguagesWithNamesResponse_QNAME, GetLanguagesWithNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesInCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesInCountries")
    public JAXBElement<GetLanguagesInCountries> createGetLanguagesInCountries(GetLanguagesInCountries value) {
        return new JAXBElement<GetLanguagesInCountries>(_GetLanguagesInCountries_QNAME, GetLanguagesInCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesInCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesInCountry")
    public JAXBElement<GetLanguagesInCountry> createGetLanguagesInCountry(GetLanguagesInCountry value) {
        return new JAXBElement<GetLanguagesInCountry>(_GetLanguagesInCountry_QNAME, GetLanguagesInCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageWithNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageWithNameResponse")
    public JAXBElement<GetLanguageWithNameResponse> createGetLanguageWithNameResponse(GetLanguageWithNameResponse value) {
        return new JAXBElement<GetLanguageWithNameResponse>(_GetLanguageWithNameResponse_QNAME, GetLanguageWithNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesInCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesInCountriesResponse")
    public JAXBElement<GetLanguagesInCountriesResponse> createGetLanguagesInCountriesResponse(GetLanguagesInCountriesResponse value) {
        return new JAXBElement<GetLanguagesInCountriesResponse>(_GetLanguagesInCountriesResponse_QNAME, GetLanguagesInCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesWithIdsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesWithIdsResponse")
    public JAXBElement<GetLanguagesWithIdsResponse> createGetLanguagesWithIdsResponse(GetLanguagesWithIdsResponse value) {
        return new JAXBElement<GetLanguagesWithIdsResponse>(_GetLanguagesWithIdsResponse_QNAME, GetLanguagesWithIdsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesWithNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesWithNames")
    public JAXBElement<GetLanguagesWithNames> createGetLanguagesWithNames(GetLanguagesWithNames value) {
        return new JAXBElement<GetLanguagesWithNames>(_GetLanguagesWithNames_QNAME, GetLanguagesWithNames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLanguages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getAllLanguages")
    public JAXBElement<GetAllLanguages> createGetAllLanguages(GetAllLanguages value) {
        return new JAXBElement<GetAllLanguages>(_GetAllLanguages_QNAME, GetAllLanguages.class, null, value);
    }

}
