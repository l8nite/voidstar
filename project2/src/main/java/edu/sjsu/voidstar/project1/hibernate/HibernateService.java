package edu.sjsu.voidstar.project1.hibernate;

import java.util.List;

import javax.persistence.Table;

import edu.sjsu.voidstar.project1.dao.City;
import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.CountryLanguage;
import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project1.dao.Infection;
import edu.sjsu.voidstar.project1.dao.Language;
import edu.sjsu.voidstar.project2.util.Assertions;

/**
 * Service class for any common Hibernate queries.
 * @author Jason Campos
 */
public class HibernateService {
	
	/**
	 * Fetches all entities from the database for the argument entityClass.
	 * @param entityClass
	 * @return A list of all persisted objects matching the argument entityClass.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends HEntity> List<T> fetchAll(Class<T> entityClass) {
		return HibernateSession.get()
				.createCriteria(entityClass)
				.list();
	}
	
	public static <T extends HEntity> int deleteAll(Class<T> entityClass) {
		Assertions.assertAnnotationPresent(entityClass,Table.class);
		
		String tableName = entityClass.getAnnotation(Table.class).name();
		return HibernateSession.get()
				.createQuery("delete from " + tableName)
				.executeUpdate();
	}

	public static void resetDatabase() {
		// TODO: Another reason to use some sort of dependency injection like Guice
		HibernateModule module = new HibernateModule(); 
		for(Class<? extends HEntity> c : module.getClasses()) {
			deleteAll(c);
		}
	}
}
