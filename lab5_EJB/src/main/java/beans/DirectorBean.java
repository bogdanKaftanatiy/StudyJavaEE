package beans;

import entities.Director;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DirectorBean extends AbstractDAO<Director> {

    @Override
    public List<Director> getAllObjects() {
        TypedQuery<Director> namedQuery = em.createNamedQuery("Director.getAll", Director.class);
        List<Director> result = namedQuery.getResultList();

        logger.info("Received all objects from table 'Directors'");

        return result;
    }

    @Override
    public Director getObject(int id) {
        logger.info("Get director with id = " + id);
        return em.find(Director.class, id);
    }
}
