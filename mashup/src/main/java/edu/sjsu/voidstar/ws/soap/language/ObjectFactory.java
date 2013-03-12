
package edu.sjsu.voidstar.ws.soap.language;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.sjsu.voidstar.ws.soap.language package. 
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

    private final static QName _GetSortedLanguagesByCountryResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getSortedLanguagesByCountryResponse");
    private final static QName _GetLanguageByName_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageByName");
    private final static QName _GetLanguagesByCityResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesByCityResponse");
    private final static QName _GetLanguageByNameResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageByNameResponse");
    private final static QName _GetLanguageById_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageById");
    private final static QName _GetLanguagesByCountry_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesByCountry");
    private final static QName _GetSortedLanguagesByCountry_QNAME = new QName("http://p.opulo.us/soap/language", "getSortedLanguagesByCountry");
    private final static QName _GetLanguagesByCountryResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesByCountryResponse");
    private final static QName _GetLanguagesByCity_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguagesByCity");
    private final static QName _GetLanguageByIdResponse_QNAME = new QName("http://p.opulo.us/soap/language", "getLanguageByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.soap.language
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLanguageByIdResponse }
     * 
     */
    public GetLanguageByIdResponse createGetLanguageByIdResponse() {
        return new GetLanguageByIdResponse();
    }

    /**
     * Create an instance of {@link GetLanguageById }
     * 
     */
    public GetLanguageById createGetLanguageById() {
        return new GetLanguageById();
    }

    /**
     * Create an instance of {@link GetLanguagesByCity }
     * 
     */
    public GetLanguagesByCity createGetLanguagesByCity() {
        return new GetLanguagesByCity();
    }

    /**
     * Create an instance of {@link GetLanguagesByCountryResponse }
     * 
     */
    public GetLanguagesByCountryResponse createGetLanguagesByCountryResponse() {
        return new GetLanguagesByCountryResponse();
    }

    /**
     * Create an instance of {@link GetLanguagesByCityResponse }
     * 
     */
    public GetLanguagesByCityResponse createGetLanguagesByCityResponse() {
        return new GetLanguagesByCityResponse();
    }

    /**
     * Create an instance of {@link GetLanguageByNameResponse }
     * 
     */
    public GetLanguageByNameResponse createGetLanguageByNameResponse() {
        return new GetLanguageByNameResponse();
    }

    /**
     * Create an instance of {@link GetLanguageByName }
     * 
     */
    public GetLanguageByName createGetLanguageByName() {
        return new GetLanguageByName();
    }

    /**
     * Create an instance of {@link GetSortedLanguagesByCountry }
     * 
     */
    public GetSortedLanguagesByCountry createGetSortedLanguagesByCountry() {
        return new GetSortedLanguagesByCountry();
    }

    /**
     * Create an instance of {@link GetLanguagesByCountry }
     * 
     */
    public GetLanguagesByCountry createGetLanguagesByCountry() {
        return new GetLanguagesByCountry();
    }

    /**
     * Create an instance of {@link GetSortedLanguagesByCountryResponse }
     * 
     */
    public GetSortedLanguagesByCountryResponse createGetSortedLanguagesByCountryResponse() {
        return new GetSortedLanguagesByCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSortedLanguagesByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getSortedLanguagesByCountryResponse")
    public JAXBElement<GetSortedLanguagesByCountryResponse> createGetSortedLanguagesByCountryResponse(GetSortedLanguagesByCountryResponse value) {
        return new JAXBElement<GetSortedLanguagesByCountryResponse>(_GetSortedLanguagesByCountryResponse_QNAME, GetSortedLanguagesByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageByName")
    public JAXBElement<GetLanguageByName> createGetLanguageByName(GetLanguageByName value) {
        return new JAXBElement<GetLanguageByName>(_GetLanguageByName_QNAME, GetLanguageByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesByCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesByCityResponse")
    public JAXBElement<GetLanguagesByCityResponse> createGetLanguagesByCityResponse(GetLanguagesByCityResponse value) {
        return new JAXBElement<GetLanguagesByCityResponse>(_GetLanguagesByCityResponse_QNAME, GetLanguagesByCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageByNameResponse")
    public JAXBElement<GetLanguageByNameResponse> createGetLanguageByNameResponse(GetLanguageByNameResponse value) {
        return new JAXBElement<GetLanguageByNameResponse>(_GetLanguageByNameResponse_QNAME, GetLanguageByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageById")
    public JAXBElement<GetLanguageById> createGetLanguageById(GetLanguageById value) {
        return new JAXBElement<GetLanguageById>(_GetLanguageById_QNAME, GetLanguageById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesByCountry")
    public JAXBElement<GetLanguagesByCountry> createGetLanguagesByCountry(GetLanguagesByCountry value) {
        return new JAXBElement<GetLanguagesByCountry>(_GetLanguagesByCountry_QNAME, GetLanguagesByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSortedLanguagesByCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getSortedLanguagesByCountry")
    public JAXBElement<GetSortedLanguagesByCountry> createGetSortedLanguagesByCountry(GetSortedLanguagesByCountry value) {
        return new JAXBElement<GetSortedLanguagesByCountry>(_GetSortedLanguagesByCountry_QNAME, GetSortedLanguagesByCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesByCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesByCountryResponse")
    public JAXBElement<GetLanguagesByCountryResponse> createGetLanguagesByCountryResponse(GetLanguagesByCountryResponse value) {
        return new JAXBElement<GetLanguagesByCountryResponse>(_GetLanguagesByCountryResponse_QNAME, GetLanguagesByCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguagesByCity")
    public JAXBElement<GetLanguagesByCity> createGetLanguagesByCity(GetLanguagesByCity value) {
        return new JAXBElement<GetLanguagesByCity>(_GetLanguagesByCity_QNAME, GetLanguagesByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguageByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p.opulo.us/soap/language", name = "getLanguageByIdResponse")
    public JAXBElement<GetLanguageByIdResponse> createGetLanguageByIdResponse(GetLanguageByIdResponse value) {
        return new JAXBElement<GetLanguageByIdResponse>(_GetLanguageByIdResponse_QNAME, GetLanguageByIdResponse.class, null, value);
    }

}
