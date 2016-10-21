package dao;

import entities.Director;
import org.apache.log4j.Logger;

import javax.persistence.TypedQuery;
import java.util.List;

public class DirectorDAO extends DAO<Integer, Director> {
    @Override
    public List<Director> getAllObjects() {
        TypedQuery<Director> namedQuery = em.createNamedQuery("Director.getAll", Director.class);
        List<Director> result = namedQuery.getResultList();

        for (Director d : result) {
            em.refresh(d);
        }

        logger.info("Received all objects from table 'Directors'");

        return result;
    }

    @Override
    public Director getObject(Integer id) {
        logger.info("Get director with id = " + id);
        return em.find(Director.class, id);
    }
}
