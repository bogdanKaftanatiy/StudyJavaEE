
package wsClient.directorWSClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsClient.directorWSClient package. 
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

    private final static QName _RemoveDirectorResponse_QNAME = new QName("http://wsServices/", "removeDirectorResponse");
    private final static QName _UpdateDirector_QNAME = new QName("http://wsServices/", "updateDirector");
    private final static QName _GetDirectors_QNAME = new QName("http://wsServices/", "getDirectors");
    private final static QName _UpdateDirectorResponse_QNAME = new QName("http://wsServices/", "updateDirectorResponse");
    private final static QName _GetDirectorResponse_QNAME = new QName("http://wsServices/", "getDirectorResponse");
    private final static QName _RemoveDirector_QNAME = new QName("http://wsServices/", "removeDirector");
    private final static QName _GetDirectorsResponse_QNAME = new QName("http://wsServices/", "getDirectorsResponse");
    private final static QName _GetDirector_QNAME = new QName("http://wsServices/", "getDirector");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsClient.directorWSClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveDirector }
     * 
     */
    public RemoveDirector createRemoveDirector() {
        return new RemoveDirector();
    }

    /**
     * Create an instance of {@link GetDirectorsResponse }
     * 
     */
    public GetDirectorsResponse createGetDirectorsResponse() {
        return new GetDirectorsResponse();
    }

    /**
     * Create an instance of {@link GetDirector }
     * 
     */
    public GetDirector createGetDirector() {
        return new GetDirector();
    }

    /**
     * Create an instance of {@link RemoveDirectorResponse }
     * 
     */
    public RemoveDirectorResponse createRemoveDirectorResponse() {
        return new RemoveDirectorResponse();
    }

    /**
     * Create an instance of {@link GetDirectors }
     * 
     */
    public GetDirectors createGetDirectors() {
        return new GetDirectors();
    }

    /**
     * Create an instance of {@link UpdateDirector }
     * 
     */
    public UpdateDirector createUpdateDirector() {
        return new UpdateDirector();
    }

    /**
     * Create an instance of {@link GetDirectorResponse }
     * 
     */
    public GetDirectorResponse createGetDirectorResponse() {
        return new GetDirectorResponse();
    }

    /**
     * Create an instance of {@link UpdateDirectorResponse }
     * 
     */
    public UpdateDirectorResponse createUpdateDirectorResponse() {
        return new UpdateDirectorResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDirectorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeDirectorResponse")
    public JAXBElement<RemoveDirectorResponse> createRemoveDirectorResponse(RemoveDirectorResponse value) {
        return new JAXBElement<RemoveDirectorResponse>(_RemoveDirectorResponse_QNAME, RemoveDirectorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDirector }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateDirector")
    public JAXBElement<UpdateDirector> createUpdateDirector(UpdateDirector value) {
        return new JAXBElement<UpdateDirector>(_UpdateDirector_QNAME, UpdateDirector.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getDirectors")
    public JAXBElement<GetDirectors> createGetDirectors(GetDirectors value) {
        return new JAXBElement<GetDirectors>(_GetDirectors_QNAME, GetDirectors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDirectorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "updateDirectorResponse")
    public JAXBElement<UpdateDirectorResponse> createUpdateDirectorResponse(UpdateDirectorResponse value) {
        return new JAXBElement<UpdateDirectorResponse>(_UpdateDirectorResponse_QNAME, UpdateDirectorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getDirectorResponse")
    public JAXBElement<GetDirectorResponse> createGetDirectorResponse(GetDirectorResponse value) {
        return new JAXBElement<GetDirectorResponse>(_GetDirectorResponse_QNAME, GetDirectorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveDirector }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "removeDirector")
    public JAXBElement<RemoveDirector> createRemoveDirector(RemoveDirector value) {
        return new JAXBElement<RemoveDirector>(_RemoveDirector_QNAME, RemoveDirector.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getDirectorsResponse")
    public JAXBElement<GetDirectorsResponse> createGetDirectorsResponse(GetDirectorsResponse value) {
        return new JAXBElement<GetDirectorsResponse>(_GetDirectorsResponse_QNAME, GetDirectorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirector }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsServices/", name = "getDirector")
    public JAXBElement<GetDirector> createGetDirector(GetDirector value) {
        return new JAXBElement<GetDirector>(_GetDirector_QNAME, GetDirector.class, null, value);
    }

}
