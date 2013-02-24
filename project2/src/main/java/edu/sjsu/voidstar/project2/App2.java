package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityMarshaller;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityUnmarshaller;
import edu.sjsu.voidstar.project2.jaxb.tables.Countries;

public class App2 {

	public static void main(String... args) throws JAXBException, FileNotFoundException {
		EntityUnmarshaller<Countries> countryU = new EntityUnmarshaller<>(Countries.class);
		Countries countries = countryU.unmarshall(new File("src/main/resources/xml/Country.xml"));
		
		EntityMarshaller<Countries,Country> marshaller = new EntityMarshaller<>(countries);
		marshaller.marshal();
	}
}
