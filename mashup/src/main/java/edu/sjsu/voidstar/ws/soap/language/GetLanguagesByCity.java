
package edu.sjsu.voidstar.ws.soap.language;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.sjsu.voidstar.ws.dao.City;


/**
 * <p>Java class for getLanguagesByCity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLanguagesByCity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://p.opulo.us/dao}City" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguagesByCity", propOrder = {
    "city"
})
public class GetLanguagesByCity {

    @XmlElement(name = "City", namespace = "http://p.opulo.us/dao")
    protected City city;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setCity(City value) {
        this.city = value;
    }

}
