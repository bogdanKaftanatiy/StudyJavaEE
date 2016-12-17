
package wsClient;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CompanyWS", targetNamespace = "http://wsServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CompanyWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "removeCompany", targetNamespace = "http://wsServices/", className = "wsClient.RemoveCompany")
    @ResponseWrapper(localName = "removeCompanyResponse", targetNamespace = "http://wsServices/", className = "wsClient.RemoveCompanyResponse")
    public void removeCompany(
        @WebParam(name = "arg0", targetNamespace = "")
        Company arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateCompany", targetNamespace = "http://wsServices/", className = "wsClient.UpdateCompany")
    @ResponseWrapper(localName = "updateCompanyResponse", targetNamespace = "http://wsServices/", className = "wsClient.UpdateCompanyResponse")
    public void updateCompany(
        @WebParam(name = "arg0", targetNamespace = "")
        Company arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns wsClient.Company
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompany", targetNamespace = "http://wsServices/", className = "wsClient.GetCompany")
    @ResponseWrapper(localName = "getCompanyResponse", targetNamespace = "http://wsServices/", className = "wsClient.GetCompanyResponse")
    public Company getCompany(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<wsClient.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanies", targetNamespace = "http://wsServices/", className = "wsClient.GetCompanies")
    @ResponseWrapper(localName = "getCompaniesResponse", targetNamespace = "http://wsServices/", className = "wsClient.GetCompaniesResponse")
    public List<Company> getCompanies();

}
