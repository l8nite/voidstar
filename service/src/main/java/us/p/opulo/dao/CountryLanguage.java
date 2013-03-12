package us.p.opulo.dao;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import us.p.opulo.jaxb.annotations.SchemaLocation;
import us.p.opulo.jaxb.annotations.XmlGroup;
import us.p.opulo.jaxb.tables.CountryLanguages;
import us.p.opulo.constants.Constants.Resources.XSD;

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
@XmlGroup(CountryLanguages.class)
@Table(name = "CountryLanguage")
@SchemaLocation(XSD.COUNTRY_LANGUAGE)
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
	
	@Override
	public String toString() {
		return "Country: " + country.toString() + ", Language: " + language.toString();
	}
}
