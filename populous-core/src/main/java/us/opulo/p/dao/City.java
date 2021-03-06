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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import us.opulo.p.constants.Constants.Resources.XSD;
import us.opulo.p.jaxb.annotations.SchemaLocation;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.Cities;

/**
 * City data access object. Objects of this class are persisted in the 'City' database table. 
 * 
 * @author Jason Campos, Shaun Guth 
 */
@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="City", propOrder = {
    "id",
    "name",
    "countryCode",
    "district",
    "population"
})
@Entity
@XmlGroup(Cities.class)
@Table(name = "City")
@SchemaLocation(XSD.CITY)
public final class City extends HEntity {
	
	@Id
	@XmlElement(name = "ID")
	private Integer id;

	@XmlElement(name = "Name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "CountryCode", insertable=false)
	@XmlTransient
	private Country country;

	@XmlElement(name = "CountryCode")
	private String countryCode;
	
	@XmlElement(name = "District")
	private String district;
    
	@XmlElement(name = "Population")
	private Integer population;
	
	@OneToOne(mappedBy = "city")
	@XmlTransient
	private Infection infection;
	
	@Transient
	@XmlTransient
	private Integer hashCode;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
		this.countryCode = country != null ? country.getCode() : null;
	}
	
	@Override
	public int hashCode() {
		return (name != null ? name.hashCode() : 0)  
			+ 31 * ( countryCode != null ? countryCode.hashCode() : 0 ) 
			+ 31 * ( district != null ? district.hashCode() : 0 ); 
	}
	
	@Override 
	public boolean equals(Object o) {
		if(!(o instanceof City)) {
			return false;
		}
		
		City oCity = (City) o;
		
		if (name == null 
				|| countryCode == null 
				|| district == null 
				|| oCity.name == null 
				|| oCity.countryCode == null 
				|| oCity.district == null
			) {
			return false;
		}
		
		return this.name.equals(oCity.name) 
				&& this.countryCode.equals(oCity.countryCode) 
				&& this.district.equals(oCity.district);
	}
	
	@Override
	public String toString() {
		// TODO: #24 - Country fails to be initialized when sent via Soap
		return this.getName()  + (country != null ? ", " + this.getCountry().getName() : "");
	}
}
