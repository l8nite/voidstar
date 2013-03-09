
package edu.sjsu.voidstar.ws.soap.city;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import edu.sjsu.voidstar.ws.dao.Cities;


/**
 * <p>Java class for citiesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="citiesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blah" type="{http://ws.voidstar.sjsu.edu/dao}Cities" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citiesResponse", propOrder = {
    "blah"
})
public class CitiesResponse {

    protected Cities blah;

    /**
     * Gets the value of the blah property.
     * 
     * @return
     *     possible object is
     *     {@link Cities }
     *     
     */
    public Cities getBlah() {
        return blah;
    }

    /**
     * Sets the value of the blah property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cities }
     *     
     */
    public void setBlah(Cities value) {
        this.blah = value;
    }

}
