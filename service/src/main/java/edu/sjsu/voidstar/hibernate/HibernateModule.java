package edu.sjsu.voidstar.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.HEntity;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.util.Assertions;

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
		entityClasses.add(City.class);
		entityClasses.add(CountryLanguage.class);
		entityClasses.add(Language.class);
		entityClasses.add(Infection.class);
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
		properties.put("hibernate.connection.url", "jdbc:mysql://kong.idlemonkeys.net:3306/se157bproject2");
		properties.put("hibernate.connection.username", "jcampos");
		properties.put("hibernate.connection.password", "sopmacj");
		properties.put("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
		properties.put("hibernate.show.sql", true);
		return properties;
	}
	
	/*
	 * (non-Javadoc)
	 * Verifies that the argument classes contain the @Entity annotation
	 */
	private void verifyClassesAreAnnotated(List<Class<? extends HEntity>> entityClasses) {
		for(Class<? extends HEntity> entityClass : entityClasses) {
			Assertions.assertAnnotationPresent(entityClass, javax.persistence.Entity.class);
		}
	}
}
