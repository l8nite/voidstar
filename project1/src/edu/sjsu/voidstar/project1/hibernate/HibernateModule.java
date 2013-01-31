package edu.sjsu.voidstar.project1.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project1.dao.Entity;

public class HibernateModule {
	
	List<Class<? extends Entity>> getClasses() {
		List<Class<? extends Entity>> entityClasses = new ArrayList<>();
		entityClasses.add(Country.class);
		return entityClasses;
	}
	
	Properties getProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.connection.driver.class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc://:3306");
		properties.put("hibernate.connection.username", "username");
		properties.put("hibernate.connection.password", "somepassword");
		return properties;
	}
}
