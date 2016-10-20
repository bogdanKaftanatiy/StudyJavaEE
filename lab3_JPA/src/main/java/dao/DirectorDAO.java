package dao;

import entities.Director;

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

        return result;
    }

    @Override
    public Director getObject(Integer id) {
        return em.find(Director.class, id);
    }
}
