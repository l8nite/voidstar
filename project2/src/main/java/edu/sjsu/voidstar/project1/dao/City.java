package edu.sjsu.voidstar.project1.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;
import edu.sjsu.voidstar.project2.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.project2.jaxb.tables.Cities;
@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="City", propOrder = {
    "id",
    "name",
    "countryCode",
    "district",
    "population"
})
@Entity
@XmlGroup(Cities.class)
public class City extends HEntity {
	
	@Id
	@XmlElement(name = "ID")
	private Integer id;

	@XmlElement(name = "Name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "CountryCode", insertable=false)
	@XmlTransient
	private Country country;

	@XmlElement(name = "CountryCode")
	private String countryCode;
	
	@XmlElement(name = "District")
	private String district;
    
	@XmlElement(name = "Population")
	private Integer population;
	
	@OneToOne(mappedBy = "city")
	@XmlTransient
	private Infection infection;
	
	@Transient
	@XmlTransient
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
				hashCode = 
						(name != null ? name.hashCode() : 0)  + 
						31 * ( countryCode != null ? countryCode.hashCode() : 0 ) + 
						31 * ( district != null ? district.hashCode() : 0 ); 
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
		
		if (name == null 
				|| countryCode == null 
				|| district == null 
				|| oCity.name == null 
				|| oCity.countryCode == null 
				|| oCity.district == null
			) {
			return false;
		}
		
		return this.name.equals(oCity.name) && this.countryCode.equals(oCity.countryCode) && this.district.equals(oCity.district);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
