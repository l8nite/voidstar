
package us.opulo.p.mashup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "MashupPortService", targetNamespace = "http://p.opulo.us/mashup", wsdlLocation = "http://localhost:8124/mashup?wsdl")
public class MashupPortService
    extends Service
{

    private final static URL MASHUPPORTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(us.opulo.p.mashup.MashupPortService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = us.opulo.p.mashup.MashupPortService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8124/mashup?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8124/mashup?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MASHUPPORTSERVICE_WSDL_LOCATION = url;
    }

    public MashupPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MashupPortService() {
        super(MASHUPPORTSERVICE_WSDL_LOCATION, new QName("http://p.opulo.us/mashup", "MashupPortService"));
    }

    /**
     * 
     * @return
     *     returns MashupService
     */
    @WebEndpoint(name = "MashupServicePort")
    public MashupService getMashupServicePort() {
        return super.getPort(new QName("http://p.opulo.us/mashup", "MashupServicePort"), MashupService.class);
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
        return super.getPort(new QName("http://p.opulo.us/mashup", "MashupServicePort"), MashupService.class, features);
    }

}
