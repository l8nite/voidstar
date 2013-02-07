package edu.sjsu.voidstar.project1.dao;

import java.io.Serializable;

public class CountryLanguageId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String countryCode;
	private Integer languageId;

	public int hashCode() {
		return countryCode.hashCode() + languageId.hashCode();
	}

	public boolean equals(Object object) {
		if (countryCode == null || languageId == null || object == null) { 
			return false;
		}
		
		if (object instanceof CountryLanguageId) {
			CountryLanguageId otherId = (CountryLanguageId) object;
			
			if (otherId.countryCode == null || otherId.languageId == null) {
				return false;
			}
			
			return (otherId.countryCode == this.countryCode && otherId.languageId == this.languageId);
		}
		return false;
	}
}
