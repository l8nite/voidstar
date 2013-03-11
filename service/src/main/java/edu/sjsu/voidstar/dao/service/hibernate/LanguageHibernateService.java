package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.dao.service.LanguageService;
import edu.sjsu.voidstar.guice.annotations.HibernateService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class LanguageHibernateService implements LanguageService {
	@Inject
	@HibernateService
	private CountryLanguageService countryLanguageService;

	@Override
	public Language getLanguageById(Integer languageId) {
		return (Language) HibernateSession.get()
				.createCriteria(Language.class)
				.add(Restrictions.eq("id", languageId))
				.uniqueResult();
	}

	@Override
	public Language getLanguageByName(String languageName) {
		return (Language) HibernateSession.get()
				.createCriteria(Language.class)
				.add(Restrictions.eq("language", languageName))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesByCountry(Country country) {
		return HibernateSession.get().createCriteria(Language.class, "l")
				.createAlias("countries", "cl")
				.add(Restrictions.eq("cl.countryCode", country.getCode()))
				.list();
	}
}
