
package us.opulo.p.soap.language;

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
@WebServiceClient(name = "LanguagePortService", targetNamespace = "http://p.opulo.us/soap/language", wsdlLocation = "http://localhost:8123/language?wsdl")
public class LanguagePortService
    extends Service
{

    private final static URL LANGUAGEPORTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(us.opulo.p.soap.language.LanguagePortService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = us.opulo.p.soap.language.LanguagePortService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8123/language?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8123/language?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        LANGUAGEPORTSERVICE_WSDL_LOCATION = url;
    }

    public LanguagePortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LanguagePortService() {
        super(LANGUAGEPORTSERVICE_WSDL_LOCATION, new QName("http://p.opulo.us/soap/language", "LanguagePortService"));
    }

    /**
     * 
     * @return
     *     returns LanguageService
     */
    @WebEndpoint(name = "LanguageServicePort")
    public LanguageService getLanguageServicePort() {
        return super.getPort(new QName("http://p.opulo.us/soap/language", "LanguageServicePort"), LanguageService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LanguageService
     */
    @WebEndpoint(name = "LanguageServicePort")
    public LanguageService getLanguageServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://p.opulo.us/soap/language", "LanguageServicePort"), LanguageService.class, features);
    }

}
