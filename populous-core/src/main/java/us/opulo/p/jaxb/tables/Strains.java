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
import us.opulo.p.dao.Strain;
import us.opulo.p.jaxb.annotations.SchemaLocation;

/**
 * Strain table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Strains", propOrder = { "strain" })
@XmlRootElement(name = "Strains")
@SchemaLocation(XSD.STRAINS)
public class Strains implements EntityTable<Strain> {

    @XmlElement(name = "Strain")
    protected List<Strain> strain = new ArrayList<>();
    
    public void add(Strain strain) {
    	this.strain.add(strain);
    }
    
    public void addAll(Collection<Strain> strains) {
    	strain.addAll(strains);
    }
    
    public List<Strain> getEntities() {
		return Collections.unmodifiableList(strain);
	}
}