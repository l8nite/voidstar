
package edu.sjsu.voidstar.ws.mashup;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MashupPortService", targetNamespace = "http://ws.voidstar.sjsu.edu/mashup", wsdlLocation = "http://localhost:8080/mashup/mashup?wsdl")
public class MashupPortService
    extends Service
{

    private final static URL MASHUPPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException MASHUPPORTSERVICE_EXCEPTION;
    private final static QName MASHUPPORTSERVICE_QNAME = new QName("http://ws.voidstar.sjsu.edu/mashup", "MashupPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/mashup/mashup?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MASHUPPORTSERVICE_WSDL_LOCATION = url;
        MASHUPPORTSERVICE_EXCEPTION = e;
    }

    public MashupPortService() {
        super(__getWsdlLocation(), MASHUPPORTSERVICE_QNAME);
    }

    public MashupPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MASHUPPORTSERVICE_QNAME, features);
    }

    public MashupPortService(URL wsdlLocation) {
        super(wsdlLocation, MASHUPPORTSERVICE_QNAME);
    }

    public MashupPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MASHUPPORTSERVICE_QNAME, features);
    }

    public MashupPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MashupPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MashupService
     */
    @WebEndpoint(name = "MashupServicePort")
    public MashupService getMashupServicePort() {
        return super.getPort(new QName("http://ws.voidstar.sjsu.edu/mashup", "MashupServicePort"), MashupService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MashupService
     */
    @WebEndpoint(name = "MashupServicePort")
    public MashupService getMashupServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.voidstar.sjsu.edu/mashup", "MashupServicePort"), MashupService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MASHUPPORTSERVICE_EXCEPTION!= null) {
            throw MASHUPPORTSERVICE_EXCEPTION;
        }
        return MASHUPPORTSERVICE_WSDL_LOCATION;
    }

}
