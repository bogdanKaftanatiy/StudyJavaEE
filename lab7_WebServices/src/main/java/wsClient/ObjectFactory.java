
package wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsClient package. 
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

    private final static QName _GetCandidateResponse_QNAME = new QName("http://wsServices/", "getCandidateResponse");
    private final static QName _GetCandidatesResponse_QNAME = new QName("http://wsServices/", "getCandidatesResponse");
    private final static QName _RemoveCandidate_QNAME = new QName("http://wsServices/", "removeCandidate");
    private final static QName _RemoveCandidateResponse_QNAME = new QName("http://wsServices/", "removeCandidateResponse");
    private final static QName _UpdateCandidateResponse_QNAME = new QName("http://wsServices/", "updateCandidateResponse");
    private final static QName _Candidate_QNAME = new QName("http://wsServices/", "candidate");
    private final static QName _GetCandidate_QNAME = new QName("http://wsServices/", "getCandidate");
    private final static QName _GetCandidates_QNAME = new QName("http://wsServices/", "getCandidates");
    private final static QName _UpdateCandidate_QNAME = new QName("http://wsServices/", "updateCandidate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCandidatesResponse }
     * 
     */
    public GetCandidatesResponse createGetCandidatesResponse() {
        return new GetCandidatesResponse();
    }

    /**
     * Create an instance of {@link RemoveCandidate }
     * 
     */
    public RemoveCandidate createRemoveCandidate() {
        return new RemoveCandidate();
    }

    /**
     * Create an instance of {@link Candidate }
     * 
     */
    public Candidate createCandidate() {
        return new Candidate();
    }

    /**
     * Create an instance of {@link GetCandidate }
     * 
     */
    public GetCandidate createGetCandidate() {
        return new GetCandidate();
    }

    /**
     * Create an instance of {@link RemoveCandidateResponse }
     * 
     */
    public RemoveCandidateResponse createRemoveCandidateResponse() {
        return new RemoveCandidateResponse();
    }

    /**
     * Create an instance of {@link UpdateCandidateResponse }
     * 
     */
    public UpdateCandidateResponse createUpdateCandidateResponse() {
        return new UpdateCandidateResponse();
    }

    /**
     * Create an instance of {@link UpdateCandidate }
     * 
     */
    public UpdateCandidate createUpdateCandidate() {
        return new UpdateCandidate();
    }

    /**
     * Create an instance of {@link GetCandidates }
     * 
     */
    public GetCandidates createGetCandidates() {
        return new GetCandidates();
    }

    /**
     * Create an instance of {@link GetCandidateResponse }
     * 
     */
    public GetCandidateResponse createGetCandidateResponse() {
        return new GetCandidateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCandidateResponse")
    public JAXBElement<GetCandidateResponse> createGetCandidateResponse(GetCandidateResponse value) {
        return new JAXBElement<GetCandidateResponse>(_GetCandidateResponse_QNAME, GetCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCandidatesResponse")
    public JAXBElement<GetCandidatesResponse> createGetCandidatesResponse(GetCandidatesResponse value) {
        return new JAXBElement<GetCandidatesResponse>(_GetCandidatesResponse_QNAME, GetCandidatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeCandidate")
    public JAXBElement<RemoveCandidate> createRemoveCandidate(RemoveCandidate value) {
        return new JAXBElement<RemoveCandidate>(_RemoveCandidate_QNAME, RemoveCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeCandidateResponse")
    public JAXBElement<RemoveCandidateResponse> createRemoveCandidateResponse(RemoveCandidateResponse value) {
        return new JAXBElement<RemoveCandidateResponse>(_RemoveCandidateResponse_QNAME, RemoveCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateCandidateResponse")
    public JAXBElement<UpdateCandidateResponse> createUpdateCandidateResponse(UpdateCandidateResponse value) {
        return new JAXBElement<UpdateCandidateResponse>(_UpdateCandidateResponse_QNAME, UpdateCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Candidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "candidate")
    public JAXBElement<Candidate> createCandidate(Candidate value) {
        return new JAXBElement<Candidate>(_Candidate_QNAME, Candidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCandidate")
    public JAXBElement<GetCandidate> createGetCandidate(GetCandidate value) {
        return new JAXBElement<GetCandidate>(_GetCandidate_QNAME, GetCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getCandidates")
    public JAXBElement<GetCandidates> createGetCandidates(GetCandidates value) {
        return new JAXBElement<GetCandidates>(_GetCandidates_QNAME, GetCandidates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateCandidate")
    public JAXBElement<UpdateCandidate> createUpdateCandidate(UpdateCandidate value) {
        return new JAXBElement<UpdateCandidate>(_UpdateCandidate_QNAME, UpdateCandidate.class, null, value);
    }

}
