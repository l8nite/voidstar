
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
    private final static QName _TestCountryMethods_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCountryMethods");
    private final static QName _TestInfectionMethods_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testInfectionMethods");
    private final static QName _TestCityMethodsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCityMethodsResponse");
    private final static QName _TestLanguageMethods_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testLanguageMethods");
    private final static QName _GetZombiesInCountriesWhereLanguageIsSpokenResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesInCountriesWhereLanguageIsSpokenResponse");
    private final static QName _TestInfectionMethodsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testInfectionMethodsResponse");
    private final static QName _GetCountriesWhichSpeakLanguageResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWhichSpeakLanguageResponse");
    private final static QName _GetZombiesInCountriesWhereLanguageIsSpoken_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesInCountriesWhereLanguageIsSpoken");
    private final static QName _GetLanguagesSpokenInCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getLanguagesSpokenInCountry");
    private final static QName _TestCountryMethodsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCountryMethodsResponse");
    private final static QName _GetZombiesInCityResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesInCityResponse");
    private final static QName _GetCitiesWithTheMostZombies_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCitiesWithTheMostZombies");
    private final static QName _GetCountriesWithTheMostZombies_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWithTheMostZombies");
    private final static QName _TestCountryLanguageMethodsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCountryLanguageMethodsResponse");
    private final static QName _GetZombiesOnContinentResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesOnContinentResponse");
    private final static QName _GetCitiesWithTheMostZombiesResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCitiesWithTheMostZombiesResponse");
    private final static QName _TestCityMethods_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCityMethods");
    private final static QName _GetZombiesInCity_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesInCity");
    private final static QName _GetZombiesOnContinent_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesOnContinent");
    private final static QName _TestCountryLanguageMethods_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testCountryLanguageMethods");
    private final static QName _GetZombiesBasedOnGeoIPLookup_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesBasedOnGeoIPLookup");
    private final static QName _GetCountriesWithTheMostZombiesResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWithTheMostZombiesResponse");
    private final static QName _GetZombiesBasedOnGeoIPLookupResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getZombiesBasedOnGeoIPLookupResponse");
    private final static QName _GetCountriesWhichSpeakLanguage_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getCountriesWhichSpeakLanguage");
    private final static QName _TestLanguageMethodsResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "testLanguageMethodsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.mashup
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestCountryLanguageMethodsResponse }
     * 
     */
    public TestCountryLanguageMethodsResponse createTestCountryLanguageMethodsResponse() {
        return new TestCountryLanguageMethodsResponse();
    }

    /**
     * Create an instance of {@link GetCitiesWithTheMostZombies }
     * 
     */
    public GetCitiesWithTheMostZombies createGetCitiesWithTheMostZombies() {
        return new GetCitiesWithTheMostZombies();
    }

    /**
     * Create an instance of {@link TestInfectionMethodsResponse }
     * 
     */
    public TestInfectionMethodsResponse createTestInfectionMethodsResponse() {
        return new TestInfectionMethodsResponse();
    }

    /**
     * Create an instance of {@link TestCountryLanguageMethods }
     * 
     */
    public TestCountryLanguageMethods createTestCountryLanguageMethods() {
        return new TestCountryLanguageMethods();
    }

    /**
     * Create an instance of {@link GetZombiesOnContinent }
     * 
     */
    public GetZombiesOnContinent createGetZombiesOnContinent() {
        return new GetZombiesOnContinent();
    }

    /**
     * Create an instance of {@link TestCountryMethods }
     * 
     */
    public TestCountryMethods createTestCountryMethods() {
        return new TestCountryMethods();
    }

    /**
     * Create an instance of {@link GetCountriesWhichSpeakLanguageResponse }
     * 
     */
    public GetCountriesWhichSpeakLanguageResponse createGetCountriesWhichSpeakLanguageResponse() {
        return new GetCountriesWhichSpeakLanguageResponse();
    }

    /**
     * Create an instance of {@link TestLanguageMethodsResponse }
     * 
     */
    public TestLanguageMethodsResponse createTestLanguageMethodsResponse() {
        return new TestLanguageMethodsResponse();
    }

    /**
     * Create an instance of {@link GetZombiesInCity }
     * 
     */
    public GetZombiesInCity createGetZombiesInCity() {
        return new GetZombiesInCity();
    }

    /**
     * Create an instance of {@link GetZombiesBasedOnGeoIPLookup }
     * 
     */
    public GetZombiesBasedOnGeoIPLookup createGetZombiesBasedOnGeoIPLookup() {
        return new GetZombiesBasedOnGeoIPLookup();
    }

    /**
     * Create an instance of {@link TestCountryMethodsResponse }
     * 
     */
    public TestCountryMethodsResponse createTestCountryMethodsResponse() {
        return new TestCountryMethodsResponse();
    }

    /**
     * Create an instance of {@link GetZombiesBasedOnGeoIPLookupResponse }
     * 
     */
    public GetZombiesBasedOnGeoIPLookupResponse createGetZombiesBasedOnGeoIPLookupResponse() {
        return new GetZombiesBasedOnGeoIPLookupResponse();
    }

    /**
     * Create an instance of {@link TestCityMethodsResponse }
     * 
     */
    public TestCityMethodsResponse createTestCityMethodsResponse() {
        return new TestCityMethodsResponse();
    }

    /**
     * Create an instance of {@link GetZombiesInCountriesWhereLanguageIsSpoken }
     * 
     */
    public GetZombiesInCountriesWhereLanguageIsSpoken createGetZombiesInCountriesWhereLanguageIsSpoken() {
        return new GetZombiesInCountriesWhereLanguageIsSpoken();
    }

    /**
     * Create an instance of {@link GetCountriesWhichSpeakLanguage }
     * 
     */
    public GetCountriesWhichSpeakLanguage createGetCountriesWhichSpeakLanguage() {
        return new GetCountriesWhichSpeakLanguage();
    }

    /**
     * Create an instance of {@link GetLanguagesSpokenInCountry }
     * 
     */
    public GetLanguagesSpokenInCountry createGetLanguagesSpokenInCountry() {
        return new GetLanguagesSpokenInCountry();
    }

    /**
     * Create an instance of {@link GetCountriesWithTheMostZombiesResponse }
     * 
     */
    public GetCountriesWithTheMostZombiesResponse createGetCountriesWithTheMostZombiesResponse() {
        return new GetCountriesWithTheMostZombiesResponse();
    }

    /**
     * Create an instance of {@link TestCityMethods }
     * 
     */
    public TestCityMethods createTestCityMethods() {
        return new TestCityMethods();
    }

    /**
     * Create an instance of {@link TestInfectionMethods }
     * 
     */
    public TestInfectionMethods createTestInfectionMethods() {
        return new TestInfectionMethods();
    }

    /**
     * Create an instance of {@link TestLanguageMethods }
     * 
     */
    public TestLanguageMethods createTestLanguageMethods() {
        return new TestLanguageMethods();
    }

    /**
     * Create an instance of {@link GetCountriesWithTheMostZombies }
     * 
     */
    public GetCountriesWithTheMostZombies createGetCountriesWithTheMostZombies() {
        return new GetCountriesWithTheMostZombies();
    }

    /**
     * Create an instance of {@link GetZombiesOnContinentResponse }
     * 
     */
    public GetZombiesOnContinentResponse createGetZombiesOnContinentResponse() {
        return new GetZombiesOnContinentResponse();
    }

    /**
     * Create an instance of {@link GetCitiesWithTheMostZombiesResponse }
     * 
     */
    public GetCitiesWithTheMostZombiesResponse createGetCitiesWithTheMostZombiesResponse() {
        return new GetCitiesWithTheMostZombiesResponse();
    }

    /**
     * Create an instance of {@link GetZombiesInCountriesWhereLanguageIsSpokenResponse }
     * 
     */
    public GetZombiesInCountriesWhereLanguageIsSpokenResponse createGetZombiesInCountriesWhereLanguageIsSpokenResponse() {
        return new GetZombiesInCountriesWhereLanguageIsSpokenResponse();
    }

    /**
     * Create an instance of {@link GetZombiesInCityResponse }
     * 
     */
    public GetZombiesInCityResponse createGetZombiesInCityResponse() {
        return new GetZombiesInCityResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesSpokenInCountryResponse }
     * 
     */
    public GetLanguagesSpokenInCountryResponse createGetLanguagesSpokenInCountryResponse() {
        return new GetLanguagesSpokenInCountryResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCountryMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCountryMethods")
    public JAXBElement<TestCountryMethods> createTestCountryMethods(TestCountryMethods value) {
        return new JAXBElement<TestCountryMethods>(_TestCountryMethods_QNAME, TestCountryMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestInfectionMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testInfectionMethods")
    public JAXBElement<TestInfectionMethods> createTestInfectionMethods(TestInfectionMethods value) {
        return new JAXBElement<TestInfectionMethods>(_TestInfectionMethods_QNAME, TestInfectionMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCityMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCityMethodsResponse")
    public JAXBElement<TestCityMethodsResponse> createTestCityMethodsResponse(TestCityMethodsResponse value) {
        return new JAXBElement<TestCityMethodsResponse>(_TestCityMethodsResponse_QNAME, TestCityMethodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestLanguageMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testLanguageMethods")
    public JAXBElement<TestLanguageMethods> createTestLanguageMethods(TestLanguageMethods value) {
        return new JAXBElement<TestLanguageMethods>(_TestLanguageMethods_QNAME, TestLanguageMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesInCountriesWhereLanguageIsSpokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesInCountriesWhereLanguageIsSpokenResponse")
    public JAXBElement<GetZombiesInCountriesWhereLanguageIsSpokenResponse> createGetZombiesInCountriesWhereLanguageIsSpokenResponse(GetZombiesInCountriesWhereLanguageIsSpokenResponse value) {
        return new JAXBElement<GetZombiesInCountriesWhereLanguageIsSpokenResponse>(_GetZombiesInCountriesWhereLanguageIsSpokenResponse_QNAME, GetZombiesInCountriesWhereLanguageIsSpokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestInfectionMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testInfectionMethodsResponse")
    public JAXBElement<TestInfectionMethodsResponse> createTestInfectionMethodsResponse(TestInfectionMethodsResponse value) {
        return new JAXBElement<TestInfectionMethodsResponse>(_TestInfectionMethodsResponse_QNAME, TestInfectionMethodsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesInCountriesWhereLanguageIsSpoken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesInCountriesWhereLanguageIsSpoken")
    public JAXBElement<GetZombiesInCountriesWhereLanguageIsSpoken> createGetZombiesInCountriesWhereLanguageIsSpoken(GetZombiesInCountriesWhereLanguageIsSpoken value) {
        return new JAXBElement<GetZombiesInCountriesWhereLanguageIsSpoken>(_GetZombiesInCountriesWhereLanguageIsSpoken_QNAME, GetZombiesInCountriesWhereLanguageIsSpoken.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCountryMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCountryMethodsResponse")
    public JAXBElement<TestCountryMethodsResponse> createTestCountryMethodsResponse(TestCountryMethodsResponse value) {
        return new JAXBElement<TestCountryMethodsResponse>(_TestCountryMethodsResponse_QNAME, TestCountryMethodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesInCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesInCityResponse")
    public JAXBElement<GetZombiesInCityResponse> createGetZombiesInCityResponse(GetZombiesInCityResponse value) {
        return new JAXBElement<GetZombiesInCityResponse>(_GetZombiesInCityResponse_QNAME, GetZombiesInCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithTheMostZombies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCitiesWithTheMostZombies")
    public JAXBElement<GetCitiesWithTheMostZombies> createGetCitiesWithTheMostZombies(GetCitiesWithTheMostZombies value) {
        return new JAXBElement<GetCitiesWithTheMostZombies>(_GetCitiesWithTheMostZombies_QNAME, GetCitiesWithTheMostZombies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWithTheMostZombies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCountriesWithTheMostZombies")
    public JAXBElement<GetCountriesWithTheMostZombies> createGetCountriesWithTheMostZombies(GetCountriesWithTheMostZombies value) {
        return new JAXBElement<GetCountriesWithTheMostZombies>(_GetCountriesWithTheMostZombies_QNAME, GetCountriesWithTheMostZombies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCountryLanguageMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCountryLanguageMethodsResponse")
    public JAXBElement<TestCountryLanguageMethodsResponse> createTestCountryLanguageMethodsResponse(TestCountryLanguageMethodsResponse value) {
        return new JAXBElement<TestCountryLanguageMethodsResponse>(_TestCountryLanguageMethodsResponse_QNAME, TestCountryLanguageMethodsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesWithTheMostZombiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCitiesWithTheMostZombiesResponse")
    public JAXBElement<GetCitiesWithTheMostZombiesResponse> createGetCitiesWithTheMostZombiesResponse(GetCitiesWithTheMostZombiesResponse value) {
        return new JAXBElement<GetCitiesWithTheMostZombiesResponse>(_GetCitiesWithTheMostZombiesResponse_QNAME, GetCitiesWithTheMostZombiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCityMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCityMethods")
    public JAXBElement<TestCityMethods> createTestCityMethods(TestCityMethods value) {
        return new JAXBElement<TestCityMethods>(_TestCityMethods_QNAME, TestCityMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesInCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesInCity")
    public JAXBElement<GetZombiesInCity> createGetZombiesInCity(GetZombiesInCity value) {
        return new JAXBElement<GetZombiesInCity>(_GetZombiesInCity_QNAME, GetZombiesInCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesOnContinent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesOnContinent")
    public JAXBElement<GetZombiesOnContinent> createGetZombiesOnContinent(GetZombiesOnContinent value) {
        return new JAXBElement<GetZombiesOnContinent>(_GetZombiesOnContinent_QNAME, GetZombiesOnContinent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestCountryLanguageMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testCountryLanguageMethods")
    public JAXBElement<TestCountryLanguageMethods> createTestCountryLanguageMethods(TestCountryLanguageMethods value) {
        return new JAXBElement<TestCountryLanguageMethods>(_TestCountryLanguageMethods_QNAME, TestCountryLanguageMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesBasedOnGeoIPLookup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesBasedOnGeoIPLookup")
    public JAXBElement<GetZombiesBasedOnGeoIPLookup> createGetZombiesBasedOnGeoIPLookup(GetZombiesBasedOnGeoIPLookup value) {
        return new JAXBElement<GetZombiesBasedOnGeoIPLookup>(_GetZombiesBasedOnGeoIPLookup_QNAME, GetZombiesBasedOnGeoIPLookup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesWithTheMostZombiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getCountriesWithTheMostZombiesResponse")
    public JAXBElement<GetCountriesWithTheMostZombiesResponse> createGetCountriesWithTheMostZombiesResponse(GetCountriesWithTheMostZombiesResponse value) {
        return new JAXBElement<GetCountriesWithTheMostZombiesResponse>(_GetCountriesWithTheMostZombiesResponse_QNAME, GetCountriesWithTheMostZombiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZombiesBasedOnGeoIPLookupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getZombiesBasedOnGeoIPLookupResponse")
    public JAXBElement<GetZombiesBasedOnGeoIPLookupResponse> createGetZombiesBasedOnGeoIPLookupResponse(GetZombiesBasedOnGeoIPLookupResponse value) {
        return new JAXBElement<GetZombiesBasedOnGeoIPLookupResponse>(_GetZombiesBasedOnGeoIPLookupResponse_QNAME, GetZombiesBasedOnGeoIPLookupResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TestLanguageMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "testLanguageMethodsResponse")
    public JAXBElement<TestLanguageMethodsResponse> createTestLanguageMethodsResponse(TestLanguageMethodsResponse value) {
        return new JAXBElement<TestLanguageMethodsResponse>(_TestLanguageMethodsResponse_QNAME, TestLanguageMethodsResponse.class, null, value);
    }

}
