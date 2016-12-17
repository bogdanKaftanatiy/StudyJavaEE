package wsServices;

import entities.Candidate;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint Interface for Candidate entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@WebService
public interface CandidateWS {
    @WebMethod
    Candidate getCandidate(Integer id);

    @WebMethod
    List<Candidate> getCandidates();

    @WebMethod
    void updateCandidate(Candidate candidate);

    @WebMethod
    void removeCandidate(Candidate candidate);
}
