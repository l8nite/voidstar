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
import us.p.opulo.dao.Infection;
import us.p.opulo.jaxb.annotations.SchemaLocation;

/**
 * Infection table JAXB binder.
 * @author Jason Campos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infections", propOrder = { "infection" })
@XmlRootElement(name = "Infections")
@SchemaLocation(XSD.INFECTIONS)
public class Infections implements EntityTable<Infection> {
	
    @XmlElement(name = "Infection")
    protected List<Infection> infection = new ArrayList<>();
    
    public void add(Infection infection) {
    	this.infection.add(infection);
    }
    
    public void addAll(Collection<Infection> infections) {
    	infection.addAll(infections);
    }
    
    public List<Infection> getEntities() {
		return Collections.unmodifiableList(infection);
	}
}