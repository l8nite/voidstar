package edu.sjsu.voidstar.project1.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class CountryLanguage  extends HEntity {
	@Id
	

	
	private String countryCode;
	
	
	private String language;
	
	
	private  Float percentage;
	
	
	private IsOfficial isOfficial;


	
	
	public String getcountryCode() {
		return countryCode;
	}
	public void setcountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	
	public IsOfficial getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(IsOfficial isOfficial) {
		this.isOfficial = isOfficial;
	}
	

}

