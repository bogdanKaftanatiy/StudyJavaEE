package rsServices;

import beans.CandidateBean;
import entities.Candidate;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Restful service for Candidate entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Path("/candidate")
public class CandidateService {
    @EJB
    CandidateBean candidateDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candidate> getCandidates() {
        return  candidateDao.getAllObjects();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Candidate getCandidate(@PathParam("id") int id) {
        return candidateDao.getObject(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCandidate(Candidate candidate) {
        candidateDao.updateObject(candidate);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCandidate(@PathParam("id") int id) {
        candidateDao.deleteObject(id);
    }
}
