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

import edu.sjsu.voidstar.constants.Constants.Files.XSD;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.jaxb.annotations.SchemaLocation;

/**
 * CountryLanguage table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryLanguages", propOrder = { "countryLanguage" })
@XmlRootElement(name = "CountryLanguages")
@SchemaLocation(XSD.COUNTRY_LANGUAGES)
public class CountryLanguages implements EntityTable<CountryLanguage> {

	@XmlElement(name = "CountryLanguage")
    protected List<CountryLanguage> countryLanguage = new ArrayList<>();
    
    public final void add(CountryLanguage countryLanguage) {
    	this.countryLanguage.add(countryLanguage);
	}
	
	public final void addAll(Collection<CountryLanguage> countryLanguages) {
		countryLanguage.addAll(countryLanguages);	
	}
	
	public List<CountryLanguage> getEntities() {
		return Collections.unmodifiableList(countryLanguage);
	}
}
