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
import javax.xml.bind.annotation.XmlType;

import us.opulo.p.constants.Constants.Resources.XSD;
import us.opulo.p.jaxb.annotations.SchemaLocation;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.Strains;

/**
 * Strain data access object. Objects of this class are persisted in the 'Strain' database table. 
 * 
 * @author Jason Campos
 */
@Entity
@XmlRootElement(name="Strain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Strain", propOrder = {
    "id",
    "mutatedFromStrainId",
    "name",
    "potency"
})
@XmlGroup(Strains.class)
@Table(name = "Strain")
@SchemaLocation(XSD.STRAIN)
public class Strain extends HEntity {
	
	@Id
	@GeneratedValue
	@XmlElement(name="ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="mutatedFromStrainId", insertable=false)
	private Strain mutatedFromStrain;
	
	@XmlElement(name="MutatedFromStrainId")
	private Integer mutatedFromStrainId;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="potency")
	private Integer potency;
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Strain () { }
	
	public Strain(String name, Integer potency) {
		this.name = name;
		this.potency = potency;
	}
	
	public Strain(String name, Integer potency, Strain mutatedFromStrain) {
		this(name, potency);
		setMutatedFromStrain(mutatedFromStrain);
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPotency() {
		return this.potency;
	}
	
	public void setPotency(Integer potency) {
		this.potency = potency;
	}
	
	public Strain getMutatedFromStrain() {
		return this.mutatedFromStrain;
	}
	
	public void setMutatedFromStrain(Strain mutatedFromStrain) {
		this.mutatedFromStrain = mutatedFromStrain;
		this.mutatedFromStrainId = mutatedFromStrain.getId();
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private Integer getMutatedFromStrainId() {
		return this.mutatedFromStrainId;
	}
	
	/*
	 * (non-javadoc)
	 * Keep private. Needed for Hibernate and JAXB but should never be used.
	 */
	@SuppressWarnings("unused")
	private void setMutatedFromStrainId(Integer mutatedFromStrainId) {
		this.mutatedFromStrainId = mutatedFromStrainId;
	}
}
