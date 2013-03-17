/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.project3;

import javax.xml.ws.Endpoint;

import us.opulo.p.dao.service.soap.CityServiceSoap;
import us.opulo.p.dao.service.soap.CountryLanguageServiceSoap;
import us.opulo.p.dao.service.soap.CountryServiceSoap;
import us.opulo.p.dao.service.soap.InfectionServiceSoap;
import us.opulo.p.dao.service.soap.LanguageServiceSoap;

public class PublishServices {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8123/city", new CityServiceSoap());
		Endpoint.publish("http://localhost:8123/country", new CountryServiceSoap());
		Endpoint.publish("http://localhost:8123/countrylanguage", new CountryLanguageServiceSoap());
		Endpoint.publish("http://localhost:8123/infection", new InfectionServiceSoap());
		Endpoint.publish("http://localhost:8123/language", new LanguageServiceSoap());
	}
}
