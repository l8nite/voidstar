package edu.sjsu.voidstar.project1;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.Continent;
import edu.sjsu.voidstar.project1.dao.Country;
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

    	System.out.println(countries.get(0).getIndepYear());
    	System.out.println(countries.get(0).getContinent());
    	
    	HibernateSession.beginTransaction();
    	countries.get(0).setContinent(Continent.Africa); // This doesn't work... I believe this is because of the enum
    	countries.get(0).setIndepYear(1776);
    	countries.get(0).save();
    	HibernateSession.commitTransaction();
    }
}
