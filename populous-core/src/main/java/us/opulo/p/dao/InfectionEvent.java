package us.opulo.p.dao;

import java.util.Date;

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

import us.opulo.p.constants.Constants.Resources.XSD;
import us.opulo.p.jaxb.annotations.SchemaLocation;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.Strains;

/**
 * InfectionEvent data access object. Objects of this class are persisted in the 'InfectionEvent' database table. 
 * 
 * @author Jason Campos
 */
@Entity
@XmlRootElement(name="Strain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Strain", propOrder = {
		"cityID",
		"strainID",
		"date"
})
@XmlGroup(Strains.class)
@Table(name = "Strain")
@SchemaLocation(XSD.STRAIN)
public class InfectionEvent extends HEntity {
	
	@Id
	@GeneratedValue
	@XmlElement(name="ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="cityID", insertable=false)
	@XmlTransient
	private City city;
	
	@OneToOne
	@JoinColumn(name="strainID", insertable=false)
	@XmlTransient
	private Strain strain;
	
	@XmlElement(name="date")
	private Date eventDate;
	
	@XmlElement(name="cityID")
	private Integer cityID;
	
	@XmlElement(name="strainID")
	private Integer strainID;
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private InfectionEvent () { }
	
	public InfectionEvent(City city, Strain strain, Date eventDate) {
		setCity(city);
		setStrain(strain);
		setDate(eventDate);
	}
	
	public Integer getID() {
		return id;
	}
	
	public void setID(Integer id) {
		this.id = id;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
		this.cityID = city.getId();
	}
	
	public Strain getStrain() {
		return strain;
	}
	
	public void setStrain(Strain strain) {
		this.strain = strain;
		this.strainID = strain.getId();
	}

	public void setDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public Date getDate() {
		return eventDate;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setCityID(Integer cityID) {
		this.cityID = cityID;
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
	private void setStrainID(Integer strainID) {
		this.strainID = strainID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getStrainID() {
		return strainID;
	}
}
