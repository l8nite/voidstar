package edu.sjsu.voidstar.project1.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Language extends HEntity {
	@Id
	private Integer id;
	private String language;
	
	@OneToMany(mappedBy="languageId")
	private Set<CountryLanguage> countries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<CountryLanguage> getCountries() {
		return countries;
	}

	public void setCountries(Set<CountryLanguage> countries) {
		this.countries = countries;
	}
}
