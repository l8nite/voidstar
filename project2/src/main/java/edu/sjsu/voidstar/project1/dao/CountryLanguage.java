package edu.sjsu.voidstar.project1.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
@IdClass(CountryLanguageId.class)
@XmlRootElement(name="CountryLanguage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryLanguage", propOrder = {
    "countryCode",
    "languageId",
    "isOfficial",
    "percentage"
})
public class CountryLanguage extends HEntity {
	@Id
	@XmlElement(name = "CountryCode")
	private String countryCode;
	
	@Id
	@XmlElement(name = "LanguageID")
	private Integer languageId;

    @XmlElement(name = "Percentage")
	private Float percentage;
	
    @XmlElement(name = "IsOfficial")
	private String isOfficial;

	@ManyToOne
	@JoinColumn(name="CountryCode", insertable=false)
	@XmlTransient
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="LanguageID", insertable=false)
	@XmlTransient
	private Language language;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	@SuppressWarnings("unchecked")	
	public static List<CountryLanguage> get(){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.list();
	}
	
	@SuppressWarnings("unchecked")	
	public static List<CountryLanguage> get(Language language){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}
	
	@Override
	public String toString() {
		return "Country: " + country.toString() + ", Language: " + language.toString();
	}
}
