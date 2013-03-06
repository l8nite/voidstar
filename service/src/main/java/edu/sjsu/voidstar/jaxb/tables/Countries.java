package edu.sjsu.voidstar.jaxb.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import edu.sjsu.voidstar.constants.Constants.Resources.XSD;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.jaxb.annotations.SchemaLocation;

/**
 * Country table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Countries")
@XmlType(name = "Countries", propOrder = { "country" })
@SchemaLocation(XSD.COUNTRIES)
public class Countries implements EntityTable<Country> {
	
    @XmlElement(name = "Country")
    protected List<Country> country = new ArrayList<>();
    
    public final void add(Country country) {
    	this.country.add(country);
	}
	
	public final void addAll(Collection<Country> countries) {
		country.addAll(countries);	
	}
	
	public List<Country> getEntities() {
		return Collections.unmodifiableList(country);
	}
}
