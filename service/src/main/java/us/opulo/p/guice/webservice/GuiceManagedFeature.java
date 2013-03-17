package us.opulo.p.guice.webservice;

import javax.xml.ws.WebServiceFeature;

import com.sun.xml.ws.api.FeatureConstructor;

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