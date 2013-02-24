package edu.sjsu.voidstar.project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import edu.sjsu.voidstar.project1.dao.Country;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityMarshaller;
import edu.sjsu.voidstar.project2.jaxb.marshallers.EntityUnmarshaller;
import edu.sjsu.voidstar.project2.jaxb.tables.Countrys;

public class App2 {

	public static void main(String... args) throws JAXBException, FileNotFoundException {
		EntityUnmarshaller<Countrys> countryU = new EntityUnmarshaller<>(Countrys.class);
		Countrys countries = countryU.unmarshall(new FileInputStream(new File("src/main/resources/xml/Country.xml")));
		
		EntityMarshaller<Countrys,Country> marshaller = new EntityMarshaller<>(countries);
		marshaller.marshal();
	}
}
