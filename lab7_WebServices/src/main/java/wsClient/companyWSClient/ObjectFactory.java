
package wsClient.companyWSClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsClient.companyWSClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateCompany_QNAME = new QName("http://wsServices/", "updateCompany");
    private final static QName _RemoveCompanyResponse_QNAME = new QName("http://wsServices/", "removeCompanyResponse");
    private final static QName _UpdateCompanyResponse_QNAME = new QName("http://wsServices/", "updateCompanyResponse");
    private final static QName _GetCompaniesResponse_QNAME = new QName("http://wsServices/", "getCompaniesResponse");
    private final static QName _RemoveCompany_QNAME = new QName("http://wsServices/", "removeCompany");
    private final static QName _GetCompanyResponse_QNAME = new QName("http://wsServices/", "getCompanyResponse");
    private final static QName _GetCompany_QNAME = new QName("http://wsServices/", "getCompany");
    private final static QName _GetCompanies_QNAME = new QName("http://wsServices/", "getCompanies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsClient.companyWSClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompanyResponse }
     * 
     */
    public GetCompanyResponse createGetCompanyResponse() {
        return new GetCompanyResponse();
    }

    /**
     * Create an instance of {@link RemoveCompany }
     * 
     */
    public RemoveCompany createRemoveCompany() {
        return new RemoveCompany();
    }

    /**
     * Create an instance of {@link GetCompanies }
     * 
     */
    public GetCompanies createGetCompanies() {
        return new GetCompanies();
    }

    /**
     * Create an instance of {@link GetCompany }
     * 
     */
    public GetCompany createGetCompany() {
        return new GetCompany();
    }

    /**
     * Create an instance of {@link UpdateCompany }
     * 
     */
    public UpdateCompany createUpdateCompany() {
        return new UpdateCompany();
    }

    /**
     * Create an instance of {@link RemoveCompanyResponse }
     * 
     */
    public RemoveCompanyResponse createRemoveCompanyResponse() {
        return new RemoveCompanyResponse();
    }

    /**
     * Create an instance of {@link UpdateCompanyResponse }
     * 
     */
    public UpdateCompanyResponse createUpdateCompanyResponse() {
        return new UpdateCompanyResponse();
    }

    /**
     * Create an instance of {@link GetCompaniesResponse }
     * 
     */
    public GetCompaniesResponse createGetCompaniesResponse() {
        return new GetCompaniesResponse();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCompany }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateCompany")
    public JAXBElement<UpdateCompany> createUpdateCompany(UpdateCompany value) {
        return new JAXBElement<UpdateCompany>(_UpdateCompany_QNAME, UpdateCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCompanyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeCompanyResponse")
    public JAXBElement<RemoveCompanyResponse> createRemoveCompanyResponse(RemoveCompanyResponse value) {
        return new JAXBElement<RemoveCompanyResponse>(_RemoveCompanyResponse_QNAME, RemoveCompanyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCompanyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateCompanyResponse")
    public JAXBElement<UpdateCompanyResponse> createUpdateCompanyResponse(UpdateCompanyResponse value) {
        return new JAXBElement<UpdateCompanyResponse>(_UpdateCompanyResponse_QNAME, UpdateCompanyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCompaniesResponse")
    public JAXBElement<GetCompaniesResponse> createGetCompaniesResponse(GetCompaniesResponse value) {
        return new JAXBElement<GetCompaniesResponse>(_GetCompaniesResponse_QNAME, GetCompaniesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCompany }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeCompany")
    public JAXBElement<RemoveCompany> createRemoveCompany(RemoveCompany value) {
        return new JAXBElement<RemoveCompany>(_RemoveCompany_QNAME, RemoveCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCompanyResponse")
    public JAXBElement<GetCompanyResponse> createGetCompanyResponse(GetCompanyResponse value) {
        return new JAXBElement<GetCompanyResponse>(_GetCompanyResponse_QNAME, GetCompanyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompany }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCompany")
    public JAXBElement<GetCompany> createGetCompany(GetCompany value) {
        return new JAXBElement<GetCompany>(_GetCompany_QNAME, GetCompany.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCompanies")
    public JAXBElement<GetCompanies> createGetCompanies(GetCompanies value) {
        return new JAXBElement<GetCompanies>(_GetCompanies_QNAME, GetCompanies.class, null, value);
    }

}
