
package edu.sjsu.voidstar.ws.mashup;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MashupService", targetNamespace = "http://p.opulo.us/mashup")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MashupService {


    /**
     * 
     * @param languageName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCountriesWhichSpeakLanguage", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetCountriesWhichSpeakLanguage")
    @ResponseWrapper(localName = "getCountriesWhichSpeakLanguageResponse", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetCountriesWhichSpeakLanguageResponse")
    @Action(input = "http://p.opulo.us/mashup/MashupService/getCountriesWhichSpeakLanguageRequest", output = "http://p.opulo.us/mashup/MashupService/getCountriesWhichSpeakLanguageResponse")
    public String getCountriesWhichSpeakLanguage(
        @WebParam(name = "languageName", targetNamespace = "")
        String languageName);

    /**
     * 
     * @param countryCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLanguagesSpokenInCountry", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetLanguagesSpokenInCountry")
    @ResponseWrapper(localName = "getLanguagesSpokenInCountryResponse", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetLanguagesSpokenInCountryResponse")
    @Action(input = "http://p.opulo.us/mashup/MashupService/getLanguagesSpokenInCountryRequest", output = "http://p.opulo.us/mashup/MashupService/getLanguagesSpokenInCountryResponse")
    public String getLanguagesSpokenInCountry(
        @WebParam(name = "countryCode", targetNamespace = "")
        String countryCode);

    /**
     * 
     * @param cityName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNumberOfZombiesInCity", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetNumberOfZombiesInCity")
    @ResponseWrapper(localName = "getNumberOfZombiesInCityResponse", targetNamespace = "http://p.opulo.us/mashup", className = "edu.sjsu.voidstar.ws.mashup.GetNumberOfZombiesInCityResponse")
    @Action(input = "http://p.opulo.us/mashup/MashupService/getNumberOfZombiesInCityRequest", output = "http://p.opulo.us/mashup/MashupService/getNumberOfZombiesInCityResponse")
    public String getNumberOfZombiesInCity(
        @WebParam(name = "cityName", targetNamespace = "")
        String cityName);

}
