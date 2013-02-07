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
		if (object instanceof CountryLanguageId) {
			CountryLanguageId otherId = (CountryLanguageId) object;
			return (otherId.countryCode == this.countryCode && otherId.languageId == this.languageId);
		}

		return false;
	}
}
