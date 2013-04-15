package us.opulo.p.dao;

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
import us.opulo.p.jaxb.tables.InfectionEventDetails;

/**
 * InfectionEventDetail data access object. Objects of this class are persisted in the 'InfectionEventDetail' database table. 
 * 
 * @author Jason Campos
 */
@Entity
@XmlRootElement(name="Strain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfectionEventDetail", propOrder = {
    "InfectionEventID",
    "HealthyBefore",
    "HealthyAfter",
    "InfectedBefore",
    "InfectedAfter"
})
@XmlGroup(InfectionEventDetails.class)
@Table(name = "InfectionEventDetail")
@SchemaLocation(XSD.INFECTION_EVENT_DETAIL)
public class InfectionEventDetail extends HEntity {
	
	@Id
	@GeneratedValue
	@XmlElement(name="ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="InfectionEventID", insertable=false)
	@XmlTransient
	private InfectionEvent infectionEvent;
	
	@XmlElement(name="InfectionEventID")
	private Integer infectionEventID;
	
	@XmlElement(name="InfectedBefore")
	private Integer infectedBefore;
	
	@XmlElement(name="InfectedAfter")
	private Integer infectedAfter;

	@XmlElement(name="HealthyBefore")
	private Integer healthyBefore;
	
	@XmlElement(name="HealthyAfter")
	private Integer healthyAfter;
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private InfectionEventDetail() { }

	public InfectionEventDetail(InfectionEvent infectionEvent) {
		setInfectionEvent(infectionEvent);
	}

	public void setInfectionEvent(InfectionEvent infectionEvent) {
		this.infectionEvent = infectionEvent;
		this.infectionEventID = infectionEvent.getID();
	}
	
	public InfectionEvent getInfectionEvent() {
		return infectionEvent;
	}
	
	public void setHealthyBefore(Integer healthyBefore) {
		this.healthyBefore = healthyBefore;
	}
	
	public Integer getHealthyBefore() {
		return healthyBefore;
	}
	
	public void setHealthyAfter(Integer healthyAfter) {
		this.healthyAfter = healthyAfter;
	}
	
	public Integer getHealthyAfter() {
		return healthyAfter;
	}
	
	public void setInfectedBefore(Integer infectedBefore) {
		this.infectedBefore = infectedBefore;
	}
	
	public Integer getInfectedBefore() {
		return infectedBefore;
	}
	
	public void setInfectedAfter(Integer infectedAfter) {
		this.infectedAfter = infectedAfter;
	}
	
	public Integer getInfectedAfter() {
		return infectedAfter;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getInfectionEventID() {
		return infectionEventID;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setInfectionEventID(Integer infectionEventID) {
		this.infectionEventID = infectionEventID;
	}
}

