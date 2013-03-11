
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

    private final static QName _GetMostSpokenLanguageInCountryResponse_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getMostSpokenLanguageInCountryResponse");
    private final static QName _GetMostSpokenLanguageInCountry_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "getMostSpokenLanguageInCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.sjsu.voidstar.ws.mashup
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMostSpokenLanguageInCountry }
     * 
     */
    public GetMostSpokenLanguageInCountry createGetMostSpokenLanguageInCountry() {
        return new GetMostSpokenLanguageInCountry();
    }

    /**
     * Create an instance of {@link GetMostSpokenLanguageInCountryResponse }
     * 
     */
    public GetMostSpokenLanguageInCountryResponse createGetMostSpokenLanguageInCountryResponse() {
        return new GetMostSpokenLanguageInCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMostSpokenLanguageInCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getMostSpokenLanguageInCountryResponse")
    public JAXBElement<GetMostSpokenLanguageInCountryResponse> createGetMostSpokenLanguageInCountryResponse(GetMostSpokenLanguageInCountryResponse value) {
        return new JAXBElement<GetMostSpokenLanguageInCountryResponse>(_GetMostSpokenLanguageInCountryResponse_QNAME, GetMostSpokenLanguageInCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMostSpokenLanguageInCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.voidstar.sjsu.edu/mashup", name = "getMostSpokenLanguageInCountry")
    public JAXBElement<GetMostSpokenLanguageInCountry> createGetMostSpokenLanguageInCountry(GetMostSpokenLanguageInCountry value) {
        return new JAXBElement<GetMostSpokenLanguageInCountry>(_GetMostSpokenLanguageInCountry_QNAME, GetMostSpokenLanguageInCountry.class, null, value);
    }

}
