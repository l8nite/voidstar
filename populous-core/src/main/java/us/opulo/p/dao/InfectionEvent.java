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
import us.opulo.p.jaxb.tables.InfectionEvents;

/**
 * InfectionEvent data access object. Objects of this class are persisted in the 'InfectionEvent' database table. 
 * 
 * @author Jason Campos
 */
@Entity
@XmlRootElement(name="InfectionEvent")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfectionEvent", propOrder = {
		"cityID",
		"infectionEventDetailID",
		"infectionEventDateID"
})
@XmlGroup(InfectionEvents.class)
@Table(name = "InfectionEvent")
@SchemaLocation(XSD.INFECTION)
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
	@JoinColumn(name="infectionEventDetailID", insertable=false)
	@XmlTransient
	private InfectionEventDetail eventDetail;
	
	@OneToOne
	@JoinColumn(name="infectionEventDateID", insertable=false)
	@XmlTransient
	private InfectionEventDate eventDate;
	
	@XmlElement(name="HealthyPopulationChange")
	private Integer healthyPopulationChange;
	
	@XmlElement(name="InfectedPopulationChange")
	private Integer infectedPopulationChange;
	
	@XmlElement(name="HealthyBefore")
	private Integer healthyBefore;
	
	@XmlElement(name="HealthyAfter")
	private Integer healthyAfter;
	
	@XmlElement(name="Infected")
	private Integer infected;
	
	@XmlElement(name="InfectedBefore")
	private Integer infectedBefore;
	
	@XmlElement(name="InfectedAfter")
	private Integer infectedAfter;
	
	@XmlElement(name="cityID")
	private Integer cityID;

	@XmlElement(name="infectionEventDateID")
	private Integer infectionEventDateID;

	@XmlElement(name="infectionEventDetailID")
	private Integer infectionEventDetailID;

	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private InfectionEvent () { }
	
	public InfectionEvent(City city, InfectionEventDetail eventDetail, Date eventDate) {
		setCity(city);
		setEventDetail(eventDetail);
		setEventDate(new InfectionEventDate(eventDate));
	}
	
	public Integer getHealthyPopulationChange() {
		return healthyPopulationChange;
	}

	public void setHealthyPopulationChange(Integer healthyPopulationChange) {
		this.healthyPopulationChange = healthyPopulationChange;
	}

	public Integer getInfectedPopulationChange() {
		return infectedPopulationChange;
	}

	public void setInfectedPopulationChange(Integer infectedPopulationChange) {
		this.infectedPopulationChange = infectedPopulationChange;
	}

	public Integer getHealthyBefore() {
		return healthyBefore;
	}

	public void setHealthyBefore(Integer healthyBefore) {
		this.healthyBefore = healthyBefore;
	}

	public Integer getHealthyAfter() {
		return healthyAfter;
	}

	public void setHealthyAfter(Integer healthyAfter) {
		this.healthyAfter = healthyAfter;
	}

	public Integer getInfected() {
		return infected;
	}

	public void setInfected(Integer infected) {
		this.infected = infected;
	}

	public Integer getInfectedBefore() {
		return infectedBefore;
	}

	public void setInfectedBefore(Integer infectedBefore) {
		this.infectedBefore = infectedBefore;
	}

	public Integer getInfectedAfter() {
		return infectedAfter;
	}

	public void setInfectedAfter(Integer infectedAfter) {
		this.infectedAfter = infectedAfter;
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

	public InfectionEventDate getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(InfectionEventDate eventDate) {
		this.eventDate = eventDate;
	}

	public InfectionEventDetail getEventDetail() {
		return eventDetail;
	}
	
	public void setEventDetail(InfectionEventDetail eventDetail) {
		this.eventDetail = eventDetail;
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
	private void setInfectionEventDateID(Integer infectionEventDateID) {
		this.infectionEventDateID = infectionEventDateID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getInfectionEventDateID() {
		return infectionEventDateID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setInfectionEventDetailID(Integer infectionEventDetailID) {
		this.infectionEventDetailID = infectionEventDetailID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getInfectionEventDetailID() {
		return infectionEventDetailID;
	}
}
