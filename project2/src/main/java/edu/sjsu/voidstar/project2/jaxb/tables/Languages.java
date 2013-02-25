package edu.sjsu.voidstar.project2.jaxb.tables;

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
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project2.jaxb.annotations.SchemaLocation;

/**
 * Langauge table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Languages", propOrder = { "language" })
@XmlRootElement(name = "Languages")
@SchemaLocation(XSD.LANGUAGES)
public class Languages implements EntityTable<Language> {

    @XmlElement(name = "Language")
    protected List<Language> language = new ArrayList<>();
    
    public void add(Language language) {
    	this.language.add(language);
    }
    
    public void addAll(Collection<Language> languages) {
    	language.addAll(languages);
    }
    
    public List<Language> getEntities() {
		return Collections.unmodifiableList(language);
	}
}