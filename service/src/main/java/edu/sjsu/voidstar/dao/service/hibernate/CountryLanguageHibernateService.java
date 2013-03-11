package edu.sjsu.voidstar.dao.service.hibernate;

import java.util.List;

import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.dao.service.CountryLanguageService;
import edu.sjsu.voidstar.hibernate.HibernateSession;

@Singleton
public class CountryLanguageHibernateService implements CountryLanguageService {
	
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getAll(){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.list();
	}
	
	@SuppressWarnings("unchecked")	
	public List<CountryLanguage> getByLanguage(Language language){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}

	@Override
	public List<CountryLanguage> getByCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}
}
