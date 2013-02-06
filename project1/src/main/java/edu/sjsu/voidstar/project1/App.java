package edu.sjsu.voidstar.project1;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
     	Session session = HibernateSession.get();
    	Criteria criteria = session.createCriteria(Country.class)
    	.add(Restrictions.eq("code", "USA"));
    	List<Country> countries = criteria.list();
    	System.out.println(countries.get(0).getIndepYear());
    }
}
