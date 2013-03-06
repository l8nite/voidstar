
package edu.sjsu.voidstar.ws.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Country complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Country">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Continent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurfaceArea" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="IndepYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Population" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LifeExpectancy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GNP" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="GNPOld" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="LocalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GovernmentForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HeadOfState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Capital" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Code2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Country", propOrder = {
    "code",
    "name",
    "continent",
    "region",
    "surfaceArea",
    "indepYear",
    "population",
    "lifeExpectancy",
    "gnp",
    "gnpOld",
    "localName",
    "governmentForm",
    "headOfState",
    "capital",
    "code2"
})
public class Country {

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Continent")
    protected String continent;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "SurfaceArea")
    protected Float surfaceArea;
    @XmlElement(name = "IndepYear")
    protected Integer indepYear;
    @XmlElement(name = "Population")
    protected Integer population;
    @XmlElement(name = "LifeExpectancy")
    protected Integer lifeExpectancy;
    @XmlElement(name = "GNP")
    protected Float gnp;
    @XmlElement(name = "GNPOld")
    protected Float gnpOld;
    @XmlElement(name = "LocalName")
    protected String localName;
    @XmlElement(name = "GovernmentForm")
    protected String governmentForm;
    @XmlElement(name = "HeadOfState")
    protected String headOfState;
    @XmlElement(name = "Capital")
    protected Integer capital;
    @XmlElement(name = "Code2")
    protected String code2;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the continent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the value of the continent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContinent(String value) {
        this.continent = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the surfaceArea property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Sets the value of the surfaceArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSurfaceArea(Float value) {
        this.surfaceArea = value;
    }

    /**
     * Gets the value of the indepYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIndepYear() {
        return indepYear;
    }

    /**
     * Sets the value of the indepYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndepYear(Integer value) {
        this.indepYear = value;
    }

    /**
     * Gets the value of the population property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPopulation(Integer value) {
        this.population = value;
    }

    /**
     * Gets the value of the lifeExpectancy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Sets the value of the lifeExpectancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLifeExpectancy(Integer value) {
        this.lifeExpectancy = value;
    }

    /**
     * Gets the value of the gnp property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGNP() {
        return gnp;
    }

    /**
     * Sets the value of the gnp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGNP(Float value) {
        this.gnp = value;
    }

    /**
     * Gets the value of the gnpOld property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGNPOld() {
        return gnpOld;
    }

    /**
     * Sets the value of the gnpOld property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGNPOld(Float value) {
        this.gnpOld = value;
    }

    /**
     * Gets the value of the localName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Sets the value of the localName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalName(String value) {
        this.localName = value;
    }

    /**
     * Gets the value of the governmentForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Sets the value of the governmentForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovernmentForm(String value) {
        this.governmentForm = value;
    }

    /**
     * Gets the value of the headOfState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Sets the value of the headOfState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadOfState(String value) {
        this.headOfState = value;
    }

    /**
     * Gets the value of the capital property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapital() {
        return capital;
    }

    /**
     * Sets the value of the capital property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapital(Integer value) {
        this.capital = value;
    }

    /**
     * Gets the value of the code2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode2() {
        return code2;
    }

    /**
     * Sets the value of the code2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode2(String value) {
        this.code2 = value;
    }

}
