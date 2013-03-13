
package us.opulo.p.dao;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CountryLanguages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CountryLanguages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://p.opulo.us/dao}CountryLanguage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryLanguages", propOrder = {
    "countryLanguage"
})
public class CountryLanguages {

    @XmlElement(name = "CountryLanguage", namespace = "http://p.opulo.us/dao")
    protected List<CountryLanguage> countryLanguage;

    /**
     * Gets the value of the countryLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountryLanguage }
     * 
     * 
     */
    public List<CountryLanguage> getCountryLanguage() {
        if (countryLanguage == null) {
            countryLanguage = new ArrayList<CountryLanguage>();
        }
        return this.countryLanguage;
    }

}
