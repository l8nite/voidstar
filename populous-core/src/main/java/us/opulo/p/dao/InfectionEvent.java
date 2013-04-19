package us.opulo.p.dao;

import java.util.Date;

import javax.persistence.CascadeType;
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
@SchemaLocation(XSD.INFECTION_EVENT)
public class InfectionEvent extends HEntity {
	@Id
	@GeneratedValue
	@XmlElement(name="ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="cityID")
	@XmlTransient
	private City city;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="infectionEventDetailID")
	@XmlTransient
	private InfectionEventDetail eventDetail;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="infectionEventDateID")
	@XmlTransient
	private InfectionEventDate eventDate;
	
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
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private InfectionEvent () { }
	
	public InfectionEvent(City city, InfectionEventDetail eventDetails, Date date) {
		setCity(city);
		setEventDetail(eventDetails);
		setEventDate(new InfectionEventDate(date));
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
}
