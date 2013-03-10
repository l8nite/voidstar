package edu.sjsu.voidstar.dao;

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

import edu.sjsu.voidstar.constants.Constants.Resources.XSD;
import edu.sjsu.voidstar.jaxb.annotations.SchemaLocation;
import edu.sjsu.voidstar.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.jaxb.tables.Infections;

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
	@JoinColumn(name = "CityId", insertable=false)
	@XmlTransient
	private City city;
    
	@XmlElement(name = "CityID")
    private String cityID;
    
	@XmlElement(name = "Zombies")
	private Integer zombies = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
