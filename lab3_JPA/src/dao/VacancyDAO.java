package dao;

import entities.Vacancy;

import javax.persistence.TypedQuery;
import java.util.List;

public class VacancyDAO extends DAO<Integer, Vacancy> {
    @Override
    public List<Vacancy> getAllObjects() {
        TypedQuery<Vacancy> namedQuery = em.createNamedQuery("Vacancy.getAll", Vacancy.class);
        return namedQuery.getResultList();
    }

    @Override
    public Vacancy getObject(Integer id) {
        return em.find(Vacancy.class, id);
    }

    @Override
    public void addObject(Vacancy object) {
        em.getTransaction().begin();
        Vacancy vacancyFromDB = em.merge(object);
        em.getTransaction().commit();
    }
}
