package edu.sjsu.voidstar.project1.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
public class Infection extends HEntity {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name = "CityId")
	private City city;

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
		criteria.setMaxResults(1);

		Infection infection = (Infection) criteria.uniqueResult();

		if (infection == null) {
			infection = new Infection();
			infection.setCity(city);
		}

		return infection;
	}
}
