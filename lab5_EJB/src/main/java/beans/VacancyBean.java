package beans;

import entities.Vacancy;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VacancyBean extends AbstractDAO<Vacancy> {
    @Override
    public List<Vacancy> getAllObjects() {
        TypedQuery<Vacancy> namedQuery = em.createNamedQuery("Vacancy.getAll", Vacancy.class);
        List<Vacancy> result = namedQuery.getResultList();

        logger.info("Received all objects from table 'Vacancies'");

        return result;
    }

    @Override
    public Vacancy getObject(int id) {
        logger.info("Get vacancy with id = " + id);
        return em.find(Vacancy.class, id);
    }
}
