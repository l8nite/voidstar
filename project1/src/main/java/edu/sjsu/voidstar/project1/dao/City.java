package edu.sjsu.voidstar.project1.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class City  extends HEntity {
	@Id
	private Integer id;
	
	private String name;
	
	private String countryCode;
	
	private String district;
	
	private Integer population;




	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getcountryCode() {
		return countryCode;
	}
	public void setcountryCode(String countryCode) {
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

	

}

