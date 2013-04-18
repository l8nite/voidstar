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
@XmlRootElement(name="InfectionEventDetail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfectionEventDetail", propOrder = {
    "InfectionEventID",
    "Mutation",
    "Strain",
    "Vector",
    "Epidemic"
})
@XmlGroup(InfectionEventDetails.class)
@Table(name = "InfectionEventDetail")
@SchemaLocation(XSD.INFECTION_EVENT_DETAIL)
public class InfectionEventDetail extends HEntity {
	
	@Id
	@GeneratedValue
	@XmlElement(name="ID")
	private Integer id;
	
	@XmlElement(name="InfectionEventID")
	private Integer infectionEventID;
	
	@XmlElement(name="Mutation")
	private String mutation;
	
	@XmlElement(name="Strain")
	private String strain;

	@XmlElement(name="Vector")
	private String vector;
	
	@XmlElement(name="Epidemic")
	private String epidemic;
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private InfectionEventDetail() { }

	public InfectionEventDetail(String mutation, String strain, String vector, String epidemic) {
		setMutation(mutation);
		setStrain(strain);
		setVector(vector);
		setEpidemic(epidemic);
	}
	
	public String getMutation() {
		return mutation;
	}

	public void setMutation(String mutation) {
		this.mutation = mutation;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}

	public String getVector() {
		return vector;
	}

	public void setVector(String vector) {
		this.vector = vector;
	}

	public String getEpidemic() {
		return epidemic;
	}

	public void setEpidemic(String epidemic) {
		this.epidemic = epidemic;
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

