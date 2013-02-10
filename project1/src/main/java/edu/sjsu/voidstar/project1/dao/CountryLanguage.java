package edu.sjsu.voidstar.project1.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

@Entity
@IdClass(CountryLanguageId.class)
public class CountryLanguage extends HEntity {
	@Id
	private String countryCode;
	@Id
	private Integer languageId;
	
	private Float percentage;
	private String isOfficial;

	@ManyToOne
	@JoinColumn(name="CountryCode")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="LanguageID")
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
}
