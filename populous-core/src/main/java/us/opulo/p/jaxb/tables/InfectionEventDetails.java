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
import us.opulo.p.dao.InfectionEventDetail;
import us.opulo.p.jaxb.annotations.SchemaLocation;

/**
 * InfectionEventDetail table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfectionEventDetails", propOrder = { "infectionEventDetail" })
@XmlRootElement(name = "InfectionEventDetails")
@SchemaLocation(XSD.INFECTION_EVENT_DETAILS)
public class InfectionEventDetails implements EntityTable<InfectionEventDetail> {
	
    @XmlElement(name = "InfectionEventDetail")
    protected List<InfectionEventDetail> infectionEventDetail = new ArrayList<>();
    
    public void add(InfectionEventDetail infectionEventDetail) {
    	this.infectionEventDetail.add(infectionEventDetail);
    }
    
    public void addAll(Collection<InfectionEventDetail> infectionEventDetails) {
    	infectionEventDetail.addAll(infectionEventDetails);
    }
    
    public List<InfectionEventDetail> getEntities() {
		return Collections.unmodifiableList(infectionEventDetail);
	}
}