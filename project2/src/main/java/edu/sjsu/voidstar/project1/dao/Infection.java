package edu.sjsu.voidstar.project1.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "cityID",
    "zombies"
})
public class Infection extends HEntity {
	@Id
	@GeneratedValue
	@XmlElement(name = "ID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "CityId")
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

	public static Infection forCity(City city) {
		Criteria criteria = HibernateSession.get().createCriteria(
				Infection.class);
		criteria.add(Restrictions.eq("city.id", city.getId()));

		Infection infection = (Infection) criteria.uniqueResult();

		if (infection == null) {
			infection = new Infection();
			infection.setCity(city);
		}

		return infection;
	}
}
