package edu.sjsu.voidstar.project1.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
public class Country extends HEntity {
	@Id
	private String code;
	private String name;

	private String continent;
	private String region;
	private Float surfaceArea;
	private Integer indepYear;
	private Integer population;
	private Integer lifeExpectancy;
	private Float gnp;
	private Float gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	
	@OneToMany(mappedBy="countryCode")
	private Set<City> cities;
	
	@OneToMany(mappedBy="countryCode")
	private Set<CountryLanguage> languages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Integer indepYear) {
		this.indepYear = indepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Integer lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}

	public Float getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(Float gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public Set<CountryLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<CountryLanguage> countryLanguages) {
		this.languages = countryLanguages;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	@SuppressWarnings("unchecked")
	public List<Language> getMostPopularLanguages() {
		return (List<Language>)HibernateSession.get().createCriteria(CountryLanguage.class, "countryLanguage")
		.add(Restrictions.eq("countryCode", this.code))
		.setProjection(Projections.property("language"))
		.addOrder(Order.desc("percentage"))
		.setMaxResults(3)
		.list();
	}
	
	@Override
	public int hashCode() {
		return code.hashCode();
	}
	
	@Override 
	public boolean equals(Object o1) {
		if(!(o1 instanceof Country)) { 
			return false;
		}
		
		Country oCountry = (Country) o1;		
		if ( code == null || oCountry == null) {
			return false;
		}
		
		return code.equals(oCountry.code);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
