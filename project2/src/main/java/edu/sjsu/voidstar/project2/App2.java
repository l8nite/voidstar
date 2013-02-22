package edu.sjsu.voidstar.project2;

import javax.xml.bind.JAXBException;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityMarshaller;
import edu.sjsu.voidstar.project2.jaxb.tables.Countrys;

public class App2 {

	public static void main(String... args) throws JAXBException {
	
		// Use the factory to create a new country
		Country country = new Country();
		country.setCode("some code");
		country.setContinent("some continent");
		
		EntityMarshaller<Countrys,Country> m = new EntityMarshaller<>(new Countrys());
		m.add(country);
		
		m.marshal();
	}
}
