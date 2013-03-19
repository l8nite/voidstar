/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.project2;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import us.opulo.p.dao.City;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.CountryLanguage;
import us.opulo.p.dao.Infection;
import us.opulo.p.dao.Language;
import us.opulo.p.jaxb.generators.XsdGenerator;
import us.opulo.p.jaxb.tables.Cities;
import us.opulo.p.jaxb.tables.Countries;
import us.opulo.p.jaxb.tables.CountryLanguages;
import us.opulo.p.jaxb.tables.Infections;
import us.opulo.p.jaxb.tables.Languages;

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
