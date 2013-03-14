/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.jaxb.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import us.p.opulo.constants.Constants.Resources.XSD;
import us.p.opulo.dao.City;
import us.p.opulo.jaxb.annotations.SchemaLocation;

/**
 * City table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cities", propOrder = {"city"})
@XmlRootElement(name = "Cities")
@SchemaLocation(XSD.CITIES)
public class Cities implements EntityTable<City> {
	
    @XmlElement(name = "City")
    protected List<City> city = new ArrayList<>();
    
    public final void add(City city) {
		this.city.add(city);
	}
	
	public final void addAll(Collection<City> cities) {
		city.addAll(cities);	
	}
	
	public List<City> getEntities() {
		return Collections.unmodifiableList(city);
	}
}
