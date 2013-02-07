package edu.sjsu.voidstar.project1;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args )
    {
    	@SuppressWarnings("unchecked")
		List<Country> countries = HibernateSession.get()
	    		.createCriteria(Country.class)
	    		.add(Restrictions.eq("code", "USA"))
	    		.list();
    	
    	Country usa = countries.get(0);

    	System.out.println(usa.getIndepYear());
    	System.out.println(usa.getContinent());

    	Set<CountryLanguage> countryLanguages = usa.getLanguages();
    	
    	for (CountryLanguage countryLanguage : countryLanguages) {
    		Language language = countryLanguage.getLanguage();
    		System.out.println(language.getLanguage() + " is spoken by " + countryLanguage.getPercentage() + " of the population.");
    	}
  
    	
//    	HibernateSession.beginTransaction();
//    	countries.get(0).save();
//    	HibernateSession.commitTransaction();
    }
}
