
package us.opulo.p.soap.infection;

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
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "InfectionPortService", targetNamespace = "http://p.opulo.us/soap/infection", wsdlLocation = "file:/home/jason/Dropbox/Jason/Dev/Workspaces/School/CS157B/voidstar/voidstar/service/src/main/resources/wsdl/InfectionSoapService.wsdl")
public class InfectionPortService
    extends Service
{

    private final static URL INFECTIONPORTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(us.opulo.p.soap.infection.InfectionPortService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = us.opulo.p.soap.infection.InfectionPortService.class.getResource(".");
            url = new URL(baseUrl, "file:/home/jason/Dropbox/Jason/Dev/Workspaces/School/CS157B/voidstar/voidstar/service/src/main/resources/wsdl/InfectionSoapService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/home/jason/Dropbox/Jason/Dev/Workspaces/School/CS157B/voidstar/voidstar/service/src/main/resources/wsdl/InfectionSoapService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        INFECTIONPORTSERVICE_WSDL_LOCATION = url;
    }

    public InfectionPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InfectionPortService() {
        super(INFECTIONPORTSERVICE_WSDL_LOCATION, new QName("http://p.opulo.us/soap/infection", "InfectionPortService"));
    }

    /**
     * 
     * @return
     *     returns InfectionService
     */
    @WebEndpoint(name = "InfectionServicePort")
    public InfectionService getInfectionServicePort() {
        return super.getPort(new QName("http://p.opulo.us/soap/infection", "InfectionServicePort"), InfectionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InfectionService
     */
    @WebEndpoint(name = "InfectionServicePort")
    public InfectionService getInfectionServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://p.opulo.us/soap/infection", "InfectionServicePort"), InfectionService.class, features);
    }

}
