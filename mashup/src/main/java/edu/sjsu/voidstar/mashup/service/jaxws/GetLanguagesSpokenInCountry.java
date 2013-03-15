
package edu.sjsu.voidstar.mashup.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLanguagesSpokenInCountry", namespace = "http://ws.voidstar.sjsu.edu/mashup")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguagesSpokenInCountry", namespace = "http://ws.voidstar.sjsu.edu/mashup")
public class GetLanguagesSpokenInCountry {

    @XmlElement(name = "countryCode", namespace = "")
    private String countryCode;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * 
     * @param countryCode
     *     the value for the countryCode property
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
