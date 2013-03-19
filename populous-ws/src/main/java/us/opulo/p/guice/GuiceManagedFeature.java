/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.guice;

import javax.xml.ws.WebServiceFeature;

import com.sun.xml.ws.api.FeatureConstructor;

/**
 * This source code contains snippets from various internet websites and repositories. 
 * The original code may have been a part of the Guicyfruit project.
 */
public class GuiceManagedFeature extends WebServiceFeature {
	public static final String ID="p.opulo.us";
	
	@FeatureConstructor
	public GuiceManagedFeature() {
	    this.enabled=true;
	}
	
	public String getID() {
	    return ID;
	}
}