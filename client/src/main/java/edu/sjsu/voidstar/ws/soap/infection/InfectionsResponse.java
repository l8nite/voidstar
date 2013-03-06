
package edu.sjsu.voidstar.ws.soap.infection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.sjsu.voidstar.ws.dao.Infection;


/**
 * <p>Java class for infectionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="infectionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ws.voidstar.sjsu.edu/dao}Infection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infectionsResponse", propOrder = {
    "infection"
})
public class InfectionsResponse {

    @XmlElement(name = "Infection", namespace = "http://ws.voidstar.sjsu.edu/dao")
    protected List<Infection> infection;

    /**
     * Gets the value of the infection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Infection }
     * 
     * 
     */
    public List<Infection> getInfection() {
        if (infection == null) {
            infection = new ArrayList<Infection>();
        }
        return this.infection;
    }

}
