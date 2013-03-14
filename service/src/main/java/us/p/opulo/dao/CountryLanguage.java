/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import us.p.opulo.constants.Constants.Resources.XSD;
import us.p.opulo.jaxb.annotations.SchemaLocation;
import us.p.opulo.jaxb.annotations.XmlGroup;
import us.p.opulo.jaxb.tables.CountryLanguages;

@Entity
@IdClass(CountryLanguageId.class)
@XmlRootElement(name="CountryLanguage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryLanguage", propOrder = {
    "countryCode",
    "languageId",
    "isOfficial",
    "percentage"
})
@XmlGroup(CountryLanguages.class)
@Table(name = "CountryLanguage")
@SchemaLocation(XSD.COUNTRY_LANGUAGE)
public class CountryLanguage extends HEntity {
	@Id
	@XmlElement(name = "CountryCode")
	private String countryCode;
	
	@Id
	@XmlElement(name = "LanguageID")
	private Integer languageId;

    @XmlElement(name = "Percentage")
	private Float percentage;
	
    @XmlElement(name = "IsOfficial")
	private String isOfficial;

	@ManyToOne
	@JoinColumn(name="CountryCode", insertable=false)
	@XmlTransient
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="LanguageID", insertable=false)
	@XmlTransient
	private Language language;

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private String getCountryCode() {
		return countryCode;
	}

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getLanguageId() {
		return languageId;
	}

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
		this.countryCode = country != null ? country.getCode() : null;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
		this.languageId = language != null ? language.getId() : null;
	}
	
	@Override
	public String toString() {
		return "Country: " + country.toString() + ", Language: " + language.toString();
	}
}
