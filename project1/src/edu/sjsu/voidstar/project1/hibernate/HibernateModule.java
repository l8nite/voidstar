package edu.sjsu.voidstar.project1.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.Entity;

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
	List<Class<? extends Entity>> getClasses() {
		List<Class<? extends Entity>> entityClasses = new ArrayList<>();
		entityClasses.add(Country.class);
		
		verifyClassesAreAnnotated(entityClasses);
		return entityClasses;
	}
	
	/**
	 * @return Configuration properties for Hibernate.
	 */
	Properties getProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.connection.driver.class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc://:3306");
		properties.put("hibernate.connection.username", "username");
		properties.put("hibernate.connection.password", "somepassword");
		return properties;
	}
	
	/*
	 * (non-Javadoc)
	 * Verifies that the argument classes contain the @Entity annotation
	 */
	private void verifyClassesAreAnnotated(List<Class<? extends Entity>> entityClasses) {
		for(Class<? extends Entity> entityClass : entityClasses) {
			if (!entityClass.isAnnotationPresent(org.hibernate.annotations.Entity.class)) {
				throw new RuntimeException("Class " + entityClass.getSimpleName() + " does not contain the @Entity annotation but is mapped in " + this.getClass().getSimpleName());
			}
		}
	}
}
