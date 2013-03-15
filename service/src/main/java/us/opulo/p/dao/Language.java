/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import us.opulo.p.constants.Constants.Resources.XSD;
import us.opulo.p.jaxb.annotations.SchemaLocation;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.Languages;

@Entity
@XmlRootElement(name="Language")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Language", propOrder = {
    "id",
    "language"
})
@XmlGroup(Languages.class)
@Table(name = "Language")
@SchemaLocation(XSD.LANGUAGE)
public class Language extends HEntity {
	
	@Id
	@XmlElement(name = "ID")
	private Integer id;        
    
    @XmlElement(name = "Language")
	private String language;
	
	@OneToMany(mappedBy="languageId")
	@XmlTransient
	private Set<CountryLanguage> countries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<CountryLanguage> getCountries() {
		return countries;
	}

	public void setCountries(Set<CountryLanguage> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {			// - to sort descending
		return this.language;
	}
}
