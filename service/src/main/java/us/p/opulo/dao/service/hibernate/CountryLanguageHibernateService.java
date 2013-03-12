package us.p.opulo.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class CountryLanguageHibernateService implements CountryLanguageService {
	
	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesByLanguage(Language language){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getCountryLanguagesByCountry(Country country) {
		return HibernateSession.get()
				.createCriteria(CountryLanguage.class)
				.add(Restrictions.eq("countryCode", country.getCode()))
				.list();
	}
}
