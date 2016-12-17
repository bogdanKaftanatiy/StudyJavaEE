
package wsClient;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CandidateWSImplService", targetNamespace = "http://wsServices/", wsdlLocation = "http://localhost:8080/lab7_WebServices_war_exploded/CandidateWSImpl?wsdl")
public class CandidateWSImplService
    extends Service
{

    private final static URL CANDIDATEWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CANDIDATEWSIMPLSERVICE_EXCEPTION;
    private final static QName CANDIDATEWSIMPLSERVICE_QNAME = new QName("http://wsServices/", "CandidateWSImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/lab7_WebServices_war_exploded/CandidateWSImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CANDIDATEWSIMPLSERVICE_WSDL_LOCATION = url;
        CANDIDATEWSIMPLSERVICE_EXCEPTION = e;
    }

    public CandidateWSImplService() {
        super(__getWsdlLocation(), CANDIDATEWSIMPLSERVICE_QNAME);
    }

    public CandidateWSImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CANDIDATEWSIMPLSERVICE_QNAME, features);
    }

    public CandidateWSImplService(URL wsdlLocation) {
        super(wsdlLocation, CANDIDATEWSIMPLSERVICE_QNAME);
    }

    public CandidateWSImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CANDIDATEWSIMPLSERVICE_QNAME, features);
    }

    public CandidateWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CandidateWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CandidateWS
     */
    @WebEndpoint(name = "CandidateWSImplPort")
    public CandidateWS getCandidateWSImplPort() {
        return super.getPort(new QName("http://wsServices/", "CandidateWSImplPort"), CandidateWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CandidateWS
     */
    @WebEndpoint(name = "CandidateWSImplPort")
    public CandidateWS getCandidateWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsServices/", "CandidateWSImplPort"), CandidateWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CANDIDATEWSIMPLSERVICE_EXCEPTION!= null) {
            throw CANDIDATEWSIMPLSERVICE_EXCEPTION;
        }
        return CANDIDATEWSIMPLSERVICE_WSDL_LOCATION;
    }

}
