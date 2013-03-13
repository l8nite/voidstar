
package us.opulo.p.soap.country;

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
@WebServiceClient(name = "CountryPortService", targetNamespace = "http://p.opulo.us/soap/country", wsdlLocation = "file:/C:/cygwin/home/jcampos/dev/voidstar/service/src/main/resources/wsdl/CountrySoapService.wsdl")
public class CountryPortService
    extends Service
{

    private final static URL COUNTRYPORTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(us.opulo.p.soap.country.CountryPortService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = us.opulo.p.soap.country.CountryPortService.class.getResource(".");
            url = new URL(baseUrl, "file:/C:/cygwin/home/jcampos/dev/voidstar/service/src/main/resources/wsdl/CountrySoapService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/cygwin/home/jcampos/dev/voidstar/service/src/main/resources/wsdl/CountrySoapService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        COUNTRYPORTSERVICE_WSDL_LOCATION = url;
    }

    public CountryPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountryPortService() {
        super(COUNTRYPORTSERVICE_WSDL_LOCATION, new QName("http://p.opulo.us/soap/country", "CountryPortService"));
    }

    /**
     * 
     * @return
     *     returns CountryService
     */
    @WebEndpoint(name = "CountryServicePort")
    public CountryService getCountryServicePort() {
        return super.getPort(new QName("http://p.opulo.us/soap/country", "CountryServicePort"), CountryService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CountryService
     */
    @WebEndpoint(name = "CountryServicePort")
    public CountryService getCountryServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://p.opulo.us/soap/country", "CountryServicePort"), CountryService.class, features);
    }

}
