package edu.sjsu.voidstar.project2;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.CountryLanguage;
import edu.sjsu.voidstar.dao.Infection;
import edu.sjsu.voidstar.dao.Language;
import edu.sjsu.voidstar.jaxb.generators.XsdGenerator;
import edu.sjsu.voidstar.jaxb.tables.Cities;
import edu.sjsu.voidstar.jaxb.tables.Countries;
import edu.sjsu.voidstar.jaxb.tables.CountryLanguages;
import edu.sjsu.voidstar.jaxb.tables.Infections;
import edu.sjsu.voidstar.jaxb.tables.Languages;

/**
 * Generates an XSD for the HEntity and EntityTable classes.
 * @author Jason Campos
 */
public class GenerateXsd {

	public static void main(String... args) throws JAXBException, IOException {
		XsdGenerator.generateSchema(City.class);
		XsdGenerator.generateSchema(Country.class);
		XsdGenerator.generateSchema(CountryLanguage.class);
		XsdGenerator.generateSchema(Infection.class);
		XsdGenerator.generateSchema(Language.class);
		XsdGenerator.generateSchema(Cities.class);
		XsdGenerator.generateSchema(Countries.class);
		XsdGenerator.generateSchema(CountryLanguages.class);
		XsdGenerator.generateSchema(Infections.class);
		XsdGenerator.generateSchema(Languages.class);
	}
}
