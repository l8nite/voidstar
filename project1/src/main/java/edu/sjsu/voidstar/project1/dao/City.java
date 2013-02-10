package edu.sjsu.voidstar.project1.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	
	@Transient
	private Integer hashCode;
	
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
	
	@SuppressWarnings("unchecked")
	public static List<City> getCities() {
		return HibernateSession.get()
				.createCriteria(City.class)
				.list();
	}
	
	public static City getRandomCity() {
		List<City> allCities = City.getCities();
		return allCities.get(new Random().nextInt(allCities.size()));
	}
	
	@Override
	public int hashCode() {
		// returned cached hashCode if its initialized. Otherwise, calculate
		synchronized(this) {
			if (hashCode == null) {
				hashCode = name.hashCode() + 31 * countryCode.hashCode() + 31 * district.hashCode(); 
			}
		}
		return hashCode;
	}
	
	@Override 
	public boolean equals(Object o) {
		if(!(o instanceof City)) {
			return false;
		}
		
		City oCity = (City) o;
		return this.name.equals(oCity.name) && this.countryCode.equals(oCity.countryCode) && this.district.equals(oCity.district);
	}
}
