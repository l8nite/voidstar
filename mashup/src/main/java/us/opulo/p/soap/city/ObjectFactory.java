
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

    private final static QName _GetCityWithIdResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCityWithIdResponse");
    private final static QName _GetCitiesInCountriesResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesInCountriesResponse");
    private final static QName _GetCitiesWithIds_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithIds");
    private final static QName _GetCitiesWithNamesResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithNamesResponse");
    private final static QName _GetCitiesInCountryResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesInCountryResponse");
    private final static QName _GetCitiesInCountries_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesInCountries");
    private final static QName _GetCityWithId_QNAME = new QName("http://p.opulo.us/soap/city", "getCityWithId");
    private final static QName _GetCitiesWithNames_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithNames");
    private final static QName _GetCitiesWithName_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithName");
    private final static QName _GetCitiesWithIdsResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithIdsResponse");
    private final static QName _GetCitiesWithNameResponse_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesWithNameResponse");
    private final static QName _GetCitiesInCountry_QNAME = new QName("http://p.opulo.us/soap/city", "getCitiesInCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.city
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCitiesInCountryResponse }
     * 
     */
    public GetCitiesInCountryResponse createGetCitiesInCountryResponse() {
        return new GetCitiesInCountryResponse();
    }

    /**
     * Create an instance of {@link GetCitiesInCountry }
     * 
     */
    public GetCitiesInCountry createGetCitiesInCountry() {
        return new GetCitiesInCountry();
    }

    /**
     * Create an instance of {@link GetCitiesInCountriesResponse }
     * 
     */
    public GetCitiesInCountriesResponse createGetCitiesInCountriesResponse() {
        return new GetCitiesInCountriesResponse();
    }

    /**
     * Create an instance of {@link GetCitiesWithNames }
     * 
     */
    public GetCitiesWithNames createGetCitiesWithNames() {
        return new GetCitiesWithNames();
    }

    /**
     * Create an instance of {@link GetCityWithId }
     * 
     */
    public GetCityWithId createGetCityWithId() {
        return new GetCityWithId();
    }

    /**
     * Create an instance of {@link GetCityWithIdResponse }
     * 
     */
    public GetCityWithIdResponse createGetCityWithIdResponse() {
        return new GetCityWithIdResponse();
    }

    /**
     * Create an instance of {@link GetCitiesWithName }
     * 
     */
    public GetCitiesWithName createGetCitiesWithName() {
        return new GetCitiesWithName();
    }

    /**
     * Create an instance of {@link GetCitiesWithIdsResponse }
     * 
     */
    public GetCitiesWithIdsResponse createGetCitiesWithIdsResponse() {
        return new GetCitiesWithIdsResponse();
    }

    /**
     * Create an instance of {@link GetCitiesInCountries }
     * 
     */
    public GetCitiesInCountries createGetCitiesInCountries() {
        return new GetCitiesInCountries();
    }

    /**
     * Create an instance of {@link GetCitiesWithNamesResponse }
     * 
     */
    public GetCitiesWithNamesResponse createGetCitiesWithNamesResponse() {
        return new GetCitiesWithNamesResponse();
    }

    /**
     * Create an instance of {@link GetCitiesWithIds }
     * 
     */
    public GetCitiesWithIds createGetCitiesWithIds() {
        return new GetCitiesWithIds();
    }

    /**
     * Create an instance of {@link GetCitiesWithNameResponse }
     * 
     */
    public GetCitiesWithNameResponse createGetCitiesWithNameResponse() {
        return new GetCitiesWithNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityWithIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCityWithIdResponse")
    public JAXBElement<GetCityWithIdResponse> createGetCityWithIdResponse(GetCityWithIdResponse value) {
        return new JAXBElement<GetCityWithIdResponse>(_GetCityWithIdResponse_QNAME, GetCityWithIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesInCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesInCountriesResponse")
    public JAXBElement<GetCitiesInCountriesResponse> createGetCitiesInCountriesResponse(GetCitiesInCountriesResponse value) {
        return new JAXBElement<GetCitiesInCountriesResponse>(_GetCitiesInCountriesResponse_QNAME, GetCitiesInCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithIds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithIds")
    public JAXBElement<GetCitiesWithIds> createGetCitiesWithIds(GetCitiesWithIds value) {
        return new JAXBElement<GetCitiesWithIds>(_GetCitiesWithIds_QNAME, GetCitiesWithIds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithNamesResponse")
    public JAXBElement<GetCitiesWithNamesResponse> createGetCitiesWithNamesResponse(GetCitiesWithNamesResponse value) {
        return new JAXBElement<GetCitiesWithNamesResponse>(_GetCitiesWithNamesResponse_QNAME, GetCitiesWithNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesInCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesInCountryResponse")
    public JAXBElement<GetCitiesInCountryResponse> createGetCitiesInCountryResponse(GetCitiesInCountryResponse value) {
        return new JAXBElement<GetCitiesInCountryResponse>(_GetCitiesInCountryResponse_QNAME, GetCitiesInCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesInCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesInCountries")
    public JAXBElement<GetCitiesInCountries> createGetCitiesInCountries(GetCitiesInCountries value) {
        return new JAXBElement<GetCitiesInCountries>(_GetCitiesInCountries_QNAME, GetCitiesInCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityWithId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCityWithId")
    public JAXBElement<GetCityWithId> createGetCityWithId(GetCityWithId value) {
        return new JAXBElement<GetCityWithId>(_GetCityWithId_QNAME, GetCityWithId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithNames")
    public JAXBElement<GetCitiesWithNames> createGetCitiesWithNames(GetCitiesWithNames value) {
        return new JAXBElement<GetCitiesWithNames>(_GetCitiesWithNames_QNAME, GetCitiesWithNames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithName")
    public JAXBElement<GetCitiesWithName> createGetCitiesWithName(GetCitiesWithName value) {
        return new JAXBElement<GetCitiesWithName>(_GetCitiesWithName_QNAME, GetCitiesWithName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithIdsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithIdsResponse")
    public JAXBElement<GetCitiesWithIdsResponse> createGetCitiesWithIdsResponse(GetCitiesWithIdsResponse value) {
        return new JAXBElement<GetCitiesWithIdsResponse>(_GetCitiesWithIdsResponse_QNAME, GetCitiesWithIdsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesWithNameResponse")
    public JAXBElement<GetCitiesWithNameResponse> createGetCitiesWithNameResponse(GetCitiesWithNameResponse value) {
        return new JAXBElement<GetCitiesWithNameResponse>(_GetCitiesWithNameResponse_QNAME, GetCitiesWithNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesInCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/city", name = "getCitiesInCountry")
    public JAXBElement<GetCitiesInCountry> createGetCitiesInCountry(GetCitiesInCountry value) {
        return new JAXBElement<GetCitiesInCountry>(_GetCitiesInCountry_QNAME, GetCitiesInCountry.class, null, value);
    }

}
