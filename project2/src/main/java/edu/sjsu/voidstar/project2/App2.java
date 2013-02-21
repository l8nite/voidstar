package edu.sjsu.voidstar.project2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project2.jaxb.factory.CountrysFactory;
import edu.sjsu.voidstar.project2.jaxb.tables.Countrys;

public class App2 {

	public static void main(String... args) throws JAXBException {
		
		CountrysFactory factory = new CountrysFactory();
		
		// Use the factory to create a new country
		Country country = factory.createRow();
		country.setCode("some code");
		country.setContinent("some continent");
		
		// Create the table and add the country to the table
		Countrys countrys = factory.createTable();
		countrys.get().add(country);
		
		// Marshall the output to XML
		JAXBContext context = JAXBContext.newInstance(new Class[]{Country.class});
		Marshaller m = context.createMarshaller();
		m.marshal(countrys, System.out);
	}
}
