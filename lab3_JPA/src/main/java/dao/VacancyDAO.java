package dao;

import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.persistence.TypedQuery;
import java.util.List;

public class VacancyDAO extends DAO<Integer, Vacancy> {
    @Override
    public List<Vacancy> getAllObjects() {
        TypedQuery<Vacancy> namedQuery = em.createNamedQuery("Vacancy.getAll", Vacancy.class);
        List<Vacancy> result = namedQuery.getResultList();

        for (Vacancy v : result) {
            em.refresh(v);
        }

        logger.info("Received all objects from table 'Vacancies'");

        return result;
    }

    @Override
    public Vacancy getObject(Integer id) {
        logger.info("Get vacancy with id = " + id);
        return em.find(Vacancy.class, id);
    }
}
