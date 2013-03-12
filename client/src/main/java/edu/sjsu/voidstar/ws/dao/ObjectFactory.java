
package edu.sjsu.voidstar.ws.dao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.dao package. 
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

    private final static QName _Infections_QNAME = new QName("http://p.opulo.us/dao", "Infections");
    private final static QName _Language_QNAME = new QName("http://p.opulo.us/dao", "Language");
    private final static QName _CountryLanguage_QNAME = new QName("http://p.opulo.us/dao", "CountryLanguage");
    private final static QName _Cities_QNAME = new QName("http://p.opulo.us/dao", "Cities");
    private final static QName _Countries_QNAME = new QName("http://p.opulo.us/dao", "Countries");
    private final static QName _Infection_QNAME = new QName("http://p.opulo.us/dao", "Infection");
    private final static QName _Country_QNAME = new QName("http://p.opulo.us/dao", "Country");
    private final static QName _Languages_QNAME = new QName("http://p.opulo.us/dao", "Languages");
    private final static QName _City_QNAME = new QName("http://p.opulo.us/dao", "City");
    private final static QName _CountryLanguages_QNAME = new QName("http://p.opulo.us/dao", "CountryLanguages");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.dao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryLanguages }
     * 
     */
    public CountryLanguages createCountryLanguages() {
        return new CountryLanguages();
    }

    /**
     * Create an instance of {@link Cities }
     * 
     */
    public Cities createCities() {
        return new Cities();
    }

    /**
     * Create an instance of {@link Infection }
     * 
     */
    public Infection createInfection() {
        return new Infection();
    }

    /**
     * Create an instance of {@link Infections }
     * 
     */
    public Infections createInfections() {
        return new Infections();
    }

    /**
     * Create an instance of {@link CountryLanguage }
     * 
     */
    public CountryLanguage createCountryLanguage() {
        return new CountryLanguage();
    }

    /**
     * Create an instance of {@link Countries }
     * 
     */
    public Countries createCountries() {
        return new Countries();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new Language();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link Languages }
     * 
     */
    public Languages createLanguages() {
        return new Languages();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Infections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Infections")
    public JAXBElement<Infections> createInfections(Infections value) {
        return new JAXBElement<Infections>(_Infections_QNAME, Infections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Language }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Language")
    public JAXBElement<Language> createLanguage(Language value) {
        return new JAXBElement<Language>(_Language_QNAME, Language.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "CountryLanguage")
    public JAXBElement<CountryLanguage> createCountryLanguage(CountryLanguage value) {
        return new JAXBElement<CountryLanguage>(_CountryLanguage_QNAME, CountryLanguage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Cities")
    public JAXBElement<Cities> createCities(Cities value) {
        return new JAXBElement<Cities>(_Cities_QNAME, Cities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Countries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Countries")
    public JAXBElement<Countries> createCountries(Countries value) {
        return new JAXBElement<Countries>(_Countries_QNAME, Countries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Infection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Infection")
    public JAXBElement<Infection> createInfection(Infection value) {
        return new JAXBElement<Infection>(_Infection_QNAME, Infection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Languages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "Languages")
    public JAXBElement<Languages> createLanguages(Languages value) {
        return new JAXBElement<Languages>(_Languages_QNAME, Languages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryLanguages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/dao", name = "CountryLanguages")
    public JAXBElement<CountryLanguages> createCountryLanguages(CountryLanguages value) {
        return new JAXBElement<CountryLanguages>(_CountryLanguages_QNAME, CountryLanguages.class, null, value);
    }

}
