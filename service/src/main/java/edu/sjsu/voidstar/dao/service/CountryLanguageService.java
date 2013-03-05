package edu.sjsu.voidstar.dao.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.hibernate.HibernateSession;

public class CountryLanguageService {
	
	@SuppressWarnings("unchecked")	
	public static List<CountryLanguage> getAll(){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.list();
	}
	
	@SuppressWarnings("unchecked")	
	public static List<CountryLanguage> getByLanguage(Language language){
		return HibernateSession.get()
			.createCriteria(CountryLanguage.class)
			.add(Restrictions.eq("languageId", language.getId()))
			.list();
	}
}
