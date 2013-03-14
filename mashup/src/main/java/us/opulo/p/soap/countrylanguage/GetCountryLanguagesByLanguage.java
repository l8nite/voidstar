
package us.opulo.p.soap.countrylanguage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCountryLanguagesByLanguage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCountryLanguagesByLanguage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://p.opulo.us/dao}Language" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCountryLanguagesByLanguage", propOrder = {
    "language"
})
public class GetCountryLanguagesByLanguage {

    @XmlElement(name = "Language", namespace = "http://p.opulo.us/dao", nillable = true)
    protected Object language;

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLanguage(Object value) {
        this.language = value;
    }

}
