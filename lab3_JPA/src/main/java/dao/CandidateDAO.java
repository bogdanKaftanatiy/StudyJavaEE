package dao;

import entities.Candidate;
import org.apache.log4j.Logger;

import javax.persistence.TypedQuery;
import java.util.List;

public class CandidateDAO extends DAO<Integer, Candidate> {
    public CandidateDAO(Logger l) {
        super(l);
    }

    @Override
    public List<Candidate> getAllObjects() {
        TypedQuery<Candidate> namedQuery = em.createNamedQuery("Candidate.getAll", Candidate.class);
        List<Candidate> result = namedQuery.getResultList();

        for (Candidate c : result) {
            em.refresh(c);
        }

        logger.info("Received all objects from table 'Candidates'");

        return result;
    }

    @Override
    public Candidate getObject(Integer id) {
        logger.info("Get candidate with id = " + id);
        return em.find(Candidate.class, id);
    }
}
