package beans;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;


public abstract class AbstractDAO<DataT> {
    protected final static Logger logger = Logger.getLogger(AbstractDAO.class);
    @PersistenceContext(unitName = "vacancy_pu")
    protected EntityManager em;

    public abstract List<DataT> getAllObjects();

    public abstract DataT getObject(int id);

    public void updateObject(DataT object) {
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException | IllegalStateException e) {
            em.getTransaction().rollback();
            logger.error("Transaction failed!");
        }
        logger.info("Updated object: " + object);
    }

    public void deleteObject(int id) {
        em.getTransaction().begin();
        em.remove(getObject(id));
        em.flush();
        em.getTransaction().commit();
        logger.info("Deleted object with id = " + id);
    }
}
