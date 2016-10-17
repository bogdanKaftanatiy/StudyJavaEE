package dao;

import entities.Candidate;

import javax.persistence.TypedQuery;
import java.util.List;

public class CandidateDAO extends DAO<Integer, Candidate> {
    @Override
    public List<Candidate> getAllObjects() {
        TypedQuery<Candidate> namedQuery = em.createNamedQuery("Candidate.getAll", Candidate.class);
        return namedQuery.getResultList();
    }

    @Override
    public Candidate getObject(Integer id) {
        return em.find(Candidate.class, id);
    }

    @Override
    public void addObject(Candidate object) {
        em.getTransaction().begin();
        Candidate candidateFromDB = em.merge(object);
        em.getTransaction().commit();
    }
}