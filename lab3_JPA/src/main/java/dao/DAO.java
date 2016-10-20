package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public abstract class DAO<KeyT, DataT> {
    protected EntityManager em;

    public DAO() {
        em = Persistence.createEntityManagerFactory("vacancyPU").createEntityManager();
    }

    public abstract List<DataT> getAllObjects();

    public abstract DataT getObject(KeyT id);

    public void addObject(DataT object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    public void updateObject(DataT object) {
        em.getTransaction().begin();
        em.merge(object);
        em.flush();
        em.getTransaction().commit();
    }

    public void deleteObject(KeyT id) {
        em.getTransaction().begin();
        em.remove(getObject(id));
        em.flush();
        em.getTransaction().commit();
    }
}
