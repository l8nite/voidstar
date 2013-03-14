
package edu.sjsu.voidstar.ws.mashup;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.mashup package. 
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

    private final static QName _GetLanguagesSpokenInCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getLanguagesSpokenInCountryResponse");
    private final static QName _GetNumberOfZombiesInCityResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getNumberOfZombiesInCityResponse");
    private final static QName _GetZombiesOnContinentResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesOnContinentResponse");
    private final static QName _GetCountriesWhichSpeakLanguageResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWhichSpeakLanguageResponse");
    private final static QName _GetLanguagesSpokenInCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getLanguagesSpokenInCountry");
    private final static QName _GetCountriesWhichSpeakLanguage_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWhichSpeakLanguage");
    private final static QName _GetNumberOfZombiesInCity_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getNumberOfZombiesInCity");
    private final static QName _GetZombiesOnContinent_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesOnContinent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.mashup
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetZombiesOnContinentResponse }
     * 
     */
    public GetZombiesOnContinentResponse createGetZombiesOnContinentResponse() {
        return new GetZombiesOnContinentResponse();
    }

    /**
     * Create an instance of {@link GetNumberOfZombiesInCityResponse }
     * 
     */
    public GetNumberOfZombiesInCityResponse createGetNumberOfZombiesInCityResponse() {
        return new GetNumberOfZombiesInCityResponse();
    }

    /**
     * Create an instance of {@link GetCountriesWhichSpeakLanguageResponse }
     * 
     */
    public GetCountriesWhichSpeakLanguageResponse createGetCountriesWhichSpeakLanguageResponse() {
        return new GetCountriesWhichSpeakLanguageResponse();
    }

    /**
     * Create an instance of {@link GetZombiesOnContinent }
     * 
     */
    public GetZombiesOnContinent createGetZombiesOnContinent() {
        return new GetZombiesOnContinent();
    }

    /**
     * Create an instance of {@link GetLanguagesSpokenInCountryResponse }
     * 
     */
    public GetLanguagesSpokenInCountryResponse createGetLanguagesSpokenInCountryResponse() {
        return new GetLanguagesSpokenInCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountriesWhichSpeakLanguage }
     * 
     */
    public GetCountriesWhichSpeakLanguage createGetCountriesWhichSpeakLanguage() {
        return new GetCountriesWhichSpeakLanguage();
    }

    /**
     * Create an instance of {@link GetNumberOfZombiesInCity }
     * 
     */
    public GetNumberOfZombiesInCity createGetNumberOfZombiesInCity() {
        return new GetNumberOfZombiesInCity();
    }

    /**
     * Create an instance of {@link GetLanguagesSpokenInCountry }
     * 
     */
    public GetLanguagesSpokenInCountry createGetLanguagesSpokenInCountry() {
        return new GetLanguagesSpokenInCountry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesSpokenInCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getLanguagesSpokenInCountryResponse")
    public JAXBElement<GetLanguagesSpokenInCountryResponse> createGetLanguagesSpokenInCountryResponse(GetLanguagesSpokenInCountryResponse value) {
        return new JAXBElement<GetLanguagesSpokenInCountryResponse>(_GetLanguagesSpokenInCountryResponse_QNAME, GetLanguagesSpokenInCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfZombiesInCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getNumberOfZombiesInCityResponse")
    public JAXBElement<GetNumberOfZombiesInCityResponse> createGetNumberOfZombiesInCityResponse(GetNumberOfZombiesInCityResponse value) {
        return new JAXBElement<GetNumberOfZombiesInCityResponse>(_GetNumberOfZombiesInCityResponse_QNAME, GetNumberOfZombiesInCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesOnContinentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesOnContinentResponse")
    public JAXBElement<GetZombiesOnContinentResponse> createGetZombiesOnContinentResponse(GetZombiesOnContinentResponse value) {
        return new JAXBElement<GetZombiesOnContinentResponse>(_GetZombiesOnContinentResponse_QNAME, GetZombiesOnContinentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWhichSpeakLanguageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCountriesWhichSpeakLanguageResponse")
    public JAXBElement<GetCountriesWhichSpeakLanguageResponse> createGetCountriesWhichSpeakLanguageResponse(GetCountriesWhichSpeakLanguageResponse value) {
        return new JAXBElement<GetCountriesWhichSpeakLanguageResponse>(_GetCountriesWhichSpeakLanguageResponse_QNAME, GetCountriesWhichSpeakLanguageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesSpokenInCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getLanguagesSpokenInCountry")
    public JAXBElement<GetLanguagesSpokenInCountry> createGetLanguagesSpokenInCountry(GetLanguagesSpokenInCountry value) {
        return new JAXBElement<GetLanguagesSpokenInCountry>(_GetLanguagesSpokenInCountry_QNAME, GetLanguagesSpokenInCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWhichSpeakLanguage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCountriesWhichSpeakLanguage")
    public JAXBElement<GetCountriesWhichSpeakLanguage> createGetCountriesWhichSpeakLanguage(GetCountriesWhichSpeakLanguage value) {
        return new JAXBElement<GetCountriesWhichSpeakLanguage>(_GetCountriesWhichSpeakLanguage_QNAME, GetCountriesWhichSpeakLanguage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfZombiesInCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getNumberOfZombiesInCity")
    public JAXBElement<GetNumberOfZombiesInCity> createGetNumberOfZombiesInCity(GetNumberOfZombiesInCity value) {
        return new JAXBElement<GetNumberOfZombiesInCity>(_GetNumberOfZombiesInCity_QNAME, GetNumberOfZombiesInCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesOnContinent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesOnContinent")
    public JAXBElement<GetZombiesOnContinent> createGetZombiesOnContinent(GetZombiesOnContinent value) {
        return new JAXBElement<GetZombiesOnContinent>(_GetZombiesOnContinent_QNAME, GetZombiesOnContinent.class, null, value);
    }

}
