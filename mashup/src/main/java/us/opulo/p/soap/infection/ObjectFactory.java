
package us.opulo.p.soap.infection;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.opulo.p.soap.infection package. 
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

    private final static QName _GetAllInfections_QNAME = new QName("http://p.opulo.us/soap/infection", "getAllInfections");
    private final static QName _GetInfectionForCities_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionForCities");
    private final static QName _GetInfectionForCity_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionForCity");
    private final static QName _GetInfectionsForCountry_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsForCountry");
    private final static QName _GetAllInfectionsResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getAllInfectionsResponse");
    private final static QName _GetInfectionForCityResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionForCityResponse");
    private final static QName _GetInfectionsForCountries_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsForCountries");
    private final static QName _GetInfectionsForCountriesResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsForCountriesResponse");
    private final static QName _GetInfectionForCitiesResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionForCitiesResponse");
    private final static QName _GetInfectionsForCountryResponse_QNAME = new QName("http://p.opulo.us/soap/infection", "getInfectionsForCountryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.opulo.p.soap.infection
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfectionsForCountryResponse }
     * 
     */
    public GetInfectionsForCountryResponse createGetInfectionsForCountryResponse() {
        return new GetInfectionsForCountryResponse();
    }

    /**
     * Create an instance of {@link GetInfectionForCitiesResponse }
     * 
     */
    public GetInfectionForCitiesResponse createGetInfectionForCitiesResponse() {
        return new GetInfectionForCitiesResponse();
    }

    /**
     * Create an instance of {@link GetAllInfectionsResponse }
     * 
     */
    public GetAllInfectionsResponse createGetAllInfectionsResponse() {
        return new GetAllInfectionsResponse();
    }

    /**
     * Create an instance of {@link GetInfectionsForCountriesResponse }
     * 
     */
    public GetInfectionsForCountriesResponse createGetInfectionsForCountriesResponse() {
        return new GetInfectionsForCountriesResponse();
    }

    /**
     * Create an instance of {@link GetInfectionsForCountries }
     * 
     */
    public GetInfectionsForCountries createGetInfectionsForCountries() {
        return new GetInfectionsForCountries();
    }

    /**
     * Create an instance of {@link GetInfectionForCityResponse }
     * 
     */
    public GetInfectionForCityResponse createGetInfectionForCityResponse() {
        return new GetInfectionForCityResponse();
    }

    /**
     * Create an instance of {@link GetInfectionsForCountry }
     * 
     */
    public GetInfectionsForCountry createGetInfectionsForCountry() {
        return new GetInfectionsForCountry();
    }

    /**
     * Create an instance of {@link GetInfectionForCity }
     * 
     */
    public GetInfectionForCity createGetInfectionForCity() {
        return new GetInfectionForCity();
    }

    /**
     * Create an instance of {@link GetInfectionForCities }
     * 
     */
    public GetInfectionForCities createGetInfectionForCities() {
        return new GetInfectionForCities();
    }

    /**
     * Create an instance of {@link GetAllInfections }
     * 
     */
    public GetAllInfections createGetAllInfections() {
        return new GetAllInfections();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInfections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getAllInfections")
    public JAXBElement<GetAllInfections> createGetAllInfections(GetAllInfections value) {
        return new JAXBElement<GetAllInfections>(_GetAllInfections_QNAME, GetAllInfections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionForCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionForCities")
    public JAXBElement<GetInfectionForCities> createGetInfectionForCities(GetInfectionForCities value) {
        return new JAXBElement<GetInfectionForCities>(_GetInfectionForCities_QNAME, GetInfectionForCities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionForCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionForCity")
    public JAXBElement<GetInfectionForCity> createGetInfectionForCity(GetInfectionForCity value) {
        return new JAXBElement<GetInfectionForCity>(_GetInfectionForCity_QNAME, GetInfectionForCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsForCountry")
    public JAXBElement<GetInfectionsForCountry> createGetInfectionsForCountry(GetInfectionsForCountry value) {
        return new JAXBElement<GetInfectionsForCountry>(_GetInfectionsForCountry_QNAME, GetInfectionsForCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInfectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getAllInfectionsResponse")
    public JAXBElement<GetAllInfectionsResponse> createGetAllInfectionsResponse(GetAllInfectionsResponse value) {
        return new JAXBElement<GetAllInfectionsResponse>(_GetAllInfectionsResponse_QNAME, GetAllInfectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionForCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionForCityResponse")
    public JAXBElement<GetInfectionForCityResponse> createGetInfectionForCityResponse(GetInfectionForCityResponse value) {
        return new JAXBElement<GetInfectionForCityResponse>(_GetInfectionForCityResponse_QNAME, GetInfectionForCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsForCountries")
    public JAXBElement<GetInfectionsForCountries> createGetInfectionsForCountries(GetInfectionsForCountries value) {
        return new JAXBElement<GetInfectionsForCountries>(_GetInfectionsForCountries_QNAME, GetInfectionsForCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsForCountriesResponse")
    public JAXBElement<GetInfectionsForCountriesResponse> createGetInfectionsForCountriesResponse(GetInfectionsForCountriesResponse value) {
        return new JAXBElement<GetInfectionsForCountriesResponse>(_GetInfectionsForCountriesResponse_QNAME, GetInfectionsForCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionForCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionForCitiesResponse")
    public JAXBElement<GetInfectionForCitiesResponse> createGetInfectionForCitiesResponse(GetInfectionForCitiesResponse value) {
        return new JAXBElement<GetInfectionForCitiesResponse>(_GetInfectionForCitiesResponse_QNAME, GetInfectionForCitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/infection", name = "getInfectionsForCountryResponse")
    public JAXBElement<GetInfectionsForCountryResponse> createGetInfectionsForCountryResponse(GetInfectionsForCountryResponse value) {
        return new JAXBElement<GetInfectionsForCountryResponse>(_GetInfectionsForCountryResponse_QNAME, GetInfectionsForCountryResponse.class, null, value);
    }

}
