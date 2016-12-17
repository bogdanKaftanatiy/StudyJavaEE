package wsServices;

import beans.CandidateBean;
import entities.Candidate;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint implementation class for Candidate entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Stateless
@WebService(endpointInterface = "wsServices.CandidateWS")
public class CandidateWSImpl implements CandidateWS {
    @EJB
    private CandidateBean candidateDao;

    public Candidate getCandidate(Integer id) {
        return candidateDao.getObject(id);
    }

    public List<Candidate> getCandidates() {
        return candidateDao.getAllObjects();
    }

    public void updateCandidate(Candidate candidate) {
        candidateDao.updateObject(candidate);
    }

    public void removeCandidate(Candidate candidate) {
        candidateDao.deleteObject(candidate.getId());
    }
}
