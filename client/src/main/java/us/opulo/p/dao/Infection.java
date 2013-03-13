
package us.opulo.p.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Infection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Infection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zombies" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infection", propOrder = {
    "id",
    "cityID",
    "zombies"
})
public class Infection {

    @XmlElement(name = "ID")
    protected Integer id;
    @XmlElement(name = "CityID")
    protected String cityID;
    @XmlElement(name = "Zombies")
    protected Integer zombies;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setID(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the cityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityID() {
        return cityID;
    }

    /**
     * Sets the value of the cityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityID(String value) {
        this.cityID = value;
    }

    /**
     * Gets the value of the zombies property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZombies() {
        return zombies;
    }

    /**
     * Sets the value of the zombies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZombies(Integer value) {
        this.zombies = value;
    }

}
