
package edu.sjsu.voidstar.ws.soap.infection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.sjsu.voidstar.ws.dao.Infection;


/**
 * <p>Java class for getInfectionByCityResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInfectionByCityResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ws.voidstar.sjsu.edu/dao}Infection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfectionByCityResponse", propOrder = {
    "infection"
})
public class GetInfectionByCityResponse {

    @XmlElement(name = "Infection", namespace = "http://ws.voidstar.sjsu.edu/dao")
    protected Infection infection;

    /**
     * Gets the value of the infection property.
     * 
     * @return
     *     possible object is
     *     {@link Infection }
     *     
     */
    public Infection getInfection() {
        return infection;
    }

    /**
     * Sets the value of the infection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Infection }
     *     
     */
    public void setInfection(Infection value) {
        this.infection = value;
    }

}
