/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
import us.p.opulo.jaxb.tables.Infections;

@Entity
@XmlRootElement(name="Infection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infection", propOrder = {
    "id",
    "cityID",
    "zombies"
})
@XmlGroup(Infections.class)
@Table(name = "Infection")
@SchemaLocation(XSD.INFECTION)
public class Infection extends HEntity {
	@Id
	@GeneratedValue
	@XmlElement(name = "ID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "CityID", insertable=false)
	@XmlTransient
	private City city;
    
	@XmlElement(name = "CityID")
    private Integer cityID;
    
	@XmlElement(name = "Zombies")
	private Integer zombies = 0;

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Infection () { }
	
	public Infection (City city) {
		setCity(city);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getCityID() {
		return cityID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
		this.cityID = city.getId();
	}

	public Integer getZombies() {
		return zombies;
	}

	public void setZombies(Integer zombies) {
		this.zombies = zombies;
	}
	
	public String toString() {
		return "ID: " + id + ", CityID: " + cityID + ", Zombies: " + zombies;
	}
}
