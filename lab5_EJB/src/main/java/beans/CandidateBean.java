package beans;

import entities.Candidate;

import javax.ejb.*;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NEVER)
public class CandidateBean extends AbstractDAO<Candidate> {

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Candidate> getAllObjects() {
        TypedQuery<Candidate> namedQuery = em.createNamedQuery("Candidate.getAll", Candidate.class);
        List<Candidate> result = namedQuery.getResultList();

        logger.info("Received all objects from table 'Candidates'");

        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Candidate getObject(int id) {
        logger.info("Get candidate with id = " + id);
        return em.find(Candidate.class, id);
    }
}
