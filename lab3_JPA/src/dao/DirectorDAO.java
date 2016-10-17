package dao;

import entities.Director;

import javax.persistence.TypedQuery;
import java.util.List;

public class DirectorDAO extends DAO<Integer, Director> {
    @Override
    public List<Director> getAllObjects() {
        TypedQuery<Director> namedQuery = em.createNamedQuery("Director.getAll", Director.class);
        return namedQuery.getResultList();
    }

    @Override
    public Director getObject(Integer id) {
        return em.find(Director.class, id);
    }

    @Override
    public void addObject(Director object) {
        em.getTransaction().begin();
        Director directorFromDB = em.merge(object);
        em.getTransaction().commit();
    }
}
