package edu.sjsu.voidstar.project1.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "name",
    "continent",
    "region",
    "surfaceArea",
    "indepYear",
    "population",
    "lifeExpectancy",
    "gnp",
    "gnpOld",
    "localName",
    "governmentForm",
    "headOfState",
    "capital",
    "code2"
})

public class Country extends HEntity {
	@Id
	@XmlElement(name = "Code")
	private String code;

	@XmlElement(name = "Name")
	private String name;    
    
    @XmlElement(name = "Continent")
	private String continent;

    @XmlElement(name = "Region")
    private String region;
	
    @XmlElement(name = "SurfaceArea")
    private Float surfaceArea;
	
    @XmlElement(name = "IndepYear")
    private Integer indepYear;
	
    @XmlElement(name = "Population")
    private Integer population;
	
    @XmlElement(name = "LifeExpectancy")
    private Integer lifeExpectancy;
	
    @XmlElement(name = "GNP")
    private Float gnp;
	
    @XmlElement(name = "GNPOld")
    private Float gnpOld;
	
    @XmlElement(name = "LocalName")
    private String localName;
	
    @XmlElement(name = "GovernmentForm")
    private String governmentForm;
	
    @XmlElement(name = "HeadOfState")
    private String headOfState;
	
    @XmlElement(name = "Capital")
    private Integer capital;
	
    @XmlElement(name = "Code2")
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
