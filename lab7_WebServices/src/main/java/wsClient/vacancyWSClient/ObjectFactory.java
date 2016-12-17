
package wsClient.vacancyWSClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsClient.vacancyWSClient package. 
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

    private final static QName _UpdateVacancy_QNAME = new QName("http://wsServices/", "updateVacancy");
    private final static QName _GetVacancyResponse_QNAME = new QName("http://wsServices/", "getVacancyResponse");
    private final static QName _GetVacanciesResponse_QNAME = new QName("http://wsServices/", "getVacanciesResponse");
    private final static QName _UpdateVacancyResponse_QNAME = new QName("http://wsServices/", "updateVacancyResponse");
    private final static QName _RemoveVacancy_QNAME = new QName("http://wsServices/", "removeVacancy");
    private final static QName _GetVacancies_QNAME = new QName("http://wsServices/", "getVacancies");
    private final static QName _RemoveVacancyResponse_QNAME = new QName("http://wsServices/", "removeVacancyResponse");
    private final static QName _GetVacancy_QNAME = new QName("http://wsServices/", "getVacancy");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsClient.vacancyWSClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveVacancy }
     * 
     */
    public RemoveVacancy createRemoveVacancy() {
        return new RemoveVacancy();
    }

    /**
     * Create an instance of {@link RemoveVacancyResponse }
     * 
     */
    public RemoveVacancyResponse createRemoveVacancyResponse() {
        return new RemoveVacancyResponse();
    }

    /**
     * Create an instance of {@link GetVacancies }
     * 
     */
    public GetVacancies createGetVacancies() {
        return new GetVacancies();
    }

    /**
     * Create an instance of {@link GetVacancy }
     * 
     */
    public GetVacancy createGetVacancy() {
        return new GetVacancy();
    }

    /**
     * Create an instance of {@link GetVacancyResponse }
     * 
     */
    public GetVacancyResponse createGetVacancyResponse() {
        return new GetVacancyResponse();
    }

    /**
     * Create an instance of {@link UpdateVacancy }
     * 
     */
    public UpdateVacancy createUpdateVacancy() {
        return new UpdateVacancy();
    }

    /**
     * Create an instance of {@link GetVacanciesResponse }
     * 
     */
    public GetVacanciesResponse createGetVacanciesResponse() {
        return new GetVacanciesResponse();
    }

    /**
     * Create an instance of {@link UpdateVacancyResponse }
     * 
     */
    public UpdateVacancyResponse createUpdateVacancyResponse() {
        return new UpdateVacancyResponse();
    }

    /**
     * Create an instance of {@link Candidate }
     * 
     */
    public Candidate createCandidate() {
        return new Candidate();
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
     * Create an instance of {@link Vacancy }
     * 
     */
    public Vacancy createVacancy() {
        return new Vacancy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVacancy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateVacancy")
    public JAXBElement<UpdateVacancy> createUpdateVacancy(UpdateVacancy value) {
        return new JAXBElement<UpdateVacancy>(_UpdateVacancy_QNAME, UpdateVacancy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVacancyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getVacancyResponse")
    public JAXBElement<GetVacancyResponse> createGetVacancyResponse(GetVacancyResponse value) {
        return new JAXBElement<GetVacancyResponse>(_GetVacancyResponse_QNAME, GetVacancyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVacanciesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getVacanciesResponse")
    public JAXBElement<GetVacanciesResponse> createGetVacanciesResponse(GetVacanciesResponse value) {
        return new JAXBElement<GetVacanciesResponse>(_GetVacanciesResponse_QNAME, GetVacanciesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVacancyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateVacancyResponse")
    public JAXBElement<UpdateVacancyResponse> createUpdateVacancyResponse(UpdateVacancyResponse value) {
        return new JAXBElement<UpdateVacancyResponse>(_UpdateVacancyResponse_QNAME, UpdateVacancyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveVacancy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeVacancy")
    public JAXBElement<RemoveVacancy> createRemoveVacancy(RemoveVacancy value) {
        return new JAXBElement<RemoveVacancy>(_RemoveVacancy_QNAME, RemoveVacancy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVacancies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getVacancies")
    public JAXBElement<GetVacancies> createGetVacancies(GetVacancies value) {
        return new JAXBElement<GetVacancies>(_GetVacancies_QNAME, GetVacancies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveVacancyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeVacancyResponse")
    public JAXBElement<RemoveVacancyResponse> createRemoveVacancyResponse(RemoveVacancyResponse value) {
        return new JAXBElement<RemoveVacancyResponse>(_RemoveVacancyResponse_QNAME, RemoveVacancyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVacancy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getVacancy")
    public JAXBElement<GetVacancy> createGetVacancy(GetVacancy value) {
        return new JAXBElement<GetVacancy>(_GetVacancy_QNAME, GetVacancy.class, null, value);
    }

}
