package edu.sjsu.voidstar.project1.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project1.dao.Country;

/**
 * Contains configuration data for the Hibernate connection. 
 * TODO: This should be an interface. 
 * 
 * @author Jason Campos
 */
public class HibernateModule {
	
	/**
	 * @return A list of classes that map to Hibernate entitities
	 */
	List<Class<? extends HEntity>> getClasses() {
		List<Class<? extends HEntity>> entityClasses = new ArrayList<>();
		entityClasses.add(Country.class);
		verifyClassesAreAnnotated(entityClasses);
		return entityClasses;
	}
	
	/**
	 * @return Configuration properties for Hibernate.
	 */
	Properties getProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc:mysql://kong.idlemonkeys.net:3306/se157bproject1");
		properties.put("hibernate.connection.username", "jcampos");
		properties.put("hibernate.connection.password", "sopmacj");
		properties.put("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
		properties.put("show.sql", "true");
		return properties;
	}
	
	/*
	 * (non-Javadoc)
	 * Verifies that the argument classes contain the @Entity annotation
	 */
	private void verifyClassesAreAnnotated(List<Class<? extends HEntity>> entityClasses) {
		for(Class<? extends HEntity> entityClass : entityClasses) {
			if (!entityClass.isAnnotationPresent(javax.persistence.Entity.class)) {
				throw new RuntimeException("Class " + entityClass.getSimpleName() + " does not contain the @Entity annotation but is mapped in " + this.getClass().getSimpleName());
			}
		}
	}
}
