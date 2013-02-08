package edu.sjsu.voidstar.project1.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
public class City extends HEntity {
	@Id
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "CountryCode")
	private Country country;

	private String countryCode;
	private String district;
	private Integer population;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getFullCityName() {
		return this.getName() + ", " + this.getCountry().getName();
	}

	public static City getRandom() {
		Criteria criteria = HibernateSession.get().createCriteria(City.class);
		criteria.add(Restrictions.isNotNull("id"));
		// hack because the .sqlRestriction adds an "and"
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(1);
		return (City) criteria.uniqueResult();
	}
}
