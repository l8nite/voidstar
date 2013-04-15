/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.jaxb.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import us.opulo.p.constants.Constants.Resources.XSD;
import us.opulo.p.dao.InfectionEvent;
import us.opulo.p.jaxb.annotations.SchemaLocation;

/**
 * InfectionEvent table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfectionEvents", propOrder = { "infectionEvents" })
@XmlRootElement(name = "Infections")
@SchemaLocation(XSD.INFECTION_EVENTS)
public class InfectionEvents implements EntityTable<InfectionEvent> {
	
    @XmlElement(name = "InfectionEvent")
    protected List<InfectionEvent> infectionEvent = new ArrayList<>();
    
    public void add(InfectionEvent infectionEvent) {
    	this.infectionEvent.add(infectionEvent);
    }
    
    public void addAll(Collection<InfectionEvent> infectionEvents) {
    	infectionEvent.addAll(infectionEvents);
    }
    
    public List<InfectionEvent> getEntities() {
		return Collections.unmodifiableList(infectionEvent);
	}
}