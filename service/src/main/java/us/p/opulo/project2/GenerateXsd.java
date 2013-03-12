/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.project2;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.CountryLanguage;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.Language;
import us.p.opulo.jaxb.generators.XsdGenerator;
import us.p.opulo.jaxb.tables.Cities;
import us.p.opulo.jaxb.tables.Countries;
import us.p.opulo.jaxb.tables.CountryLanguages;
import us.p.opulo.jaxb.tables.Infections;
import us.p.opulo.jaxb.tables.Languages;

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
