package edu.sjsu.voidstar.hibernate;

import java.util.List;

import javax.persistence.Table;

import edu.sjsu.voidstar.dao.HEntity;
import edu.sjsu.voidstar.util.Assertions;

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