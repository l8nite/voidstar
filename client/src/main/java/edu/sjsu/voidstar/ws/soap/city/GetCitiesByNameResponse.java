
package edu.sjsu.voidstar.ws.soap.city;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.sjsu.voidstar.ws.dao.City;


/**
 * <p>Java class for getCitiesByNameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitiesByNameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ws.voidstar.sjsu.edu/dao}City" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCitiesByNameResponse", propOrder = {
    "city"
})
public class GetCitiesByNameResponse {

    @XmlElement(name = "City", namespace = "http://ws.voidstar.sjsu.edu/dao")
    protected List<City> city;

    /**
     * Gets the value of the city property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the city property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link City }
     * 
     * 
     */
    public List<City> getCity() {
        if (city == null) {
            city = new ArrayList<City>();
        }
        return this.city;
    }

}
