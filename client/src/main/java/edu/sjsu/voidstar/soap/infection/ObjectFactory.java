
package edu.sjsu.voidstar.soap.infection;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.soap.infection package. 
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

    private final static QName _GetInfectionsForCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getInfectionsForCountry");
    private final static QName _City_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "City");
    private final static QName _Country_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "Country");
    private final static QName _Infection_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "Infection");
    private final static QName _GetInfectionByCity_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getInfectionByCity");
    private final static QName _GetInfectionsForCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getInfectionsForCountryResponse");
    private final static QName _GetInfectionByCityResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/", "getInfectionByCityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.soap.infection
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link Infection }
     * 
     */
    public Infection createInfection() {
        return new Infection();
    }

    /**
     * Create an instance of {@link GetInfectionsForCountryResponse }
     * 
     */
    public GetInfectionsForCountryResponse createGetInfectionsForCountryResponse() {
        return new GetInfectionsForCountryResponse();
    }

    /**
     * Create an instance of {@link GetInfectionByCityResponse }
     * 
     */
    public GetInfectionByCityResponse createGetInfectionByCityResponse() {
        return new GetInfectionByCityResponse();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link GetInfectionsForCountry }
     * 
     */
    public GetInfectionsForCountry createGetInfectionsForCountry() {
        return new GetInfectionsForCountry();
    }

    /**
     * Create an instance of {@link GetInfectionByCity }
     * 
     */
    public GetInfectionByCity createGetInfectionByCity() {
        return new GetInfectionByCity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getInfectionsForCountry")
    public JAXBElement<GetInfectionsForCountry> createGetInfectionsForCountry(GetInfectionsForCountry value) {
        return new JAXBElement<GetInfectionsForCountry>(_GetInfectionsForCountry_QNAME, GetInfectionsForCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Infection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "Infection")
    public JAXBElement<Infection> createInfection(Infection value) {
        return new JAXBElement<Infection>(_Infection_QNAME, Infection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getInfectionByCity")
    public JAXBElement<GetInfectionByCity> createGetInfectionByCity(GetInfectionByCity value) {
        return new JAXBElement<GetInfectionByCity>(_GetInfectionByCity_QNAME, GetInfectionByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionsForCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getInfectionsForCountryResponse")
    public JAXBElement<GetInfectionsForCountryResponse> createGetInfectionsForCountryResponse(GetInfectionsForCountryResponse value) {
        return new JAXBElement<GetInfectionsForCountryResponse>(_GetInfectionsForCountryResponse_QNAME, GetInfectionsForCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfectionByCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/", name = "getInfectionByCityResponse")
    public JAXBElement<GetInfectionByCityResponse> createGetInfectionByCityResponse(GetInfectionByCityResponse value) {
        return new JAXBElement<GetInfectionByCityResponse>(_GetInfectionByCityResponse_QNAME, GetInfectionByCityResponse.class, null, value);
    }

}
