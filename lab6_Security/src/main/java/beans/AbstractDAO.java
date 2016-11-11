package beans;

import org.apache.log4j.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public abstract class AbstractDAO<DataT> {
    protected final static Logger logger = Logger.getLogger(AbstractDAO.class);
    @PersistenceContext(unitName = "vacancy_pu")
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public abstract List<DataT> getAllObjects();

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public abstract DataT getObject(int id);

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateObject(DataT object) {
        em.merge(object);
        logger.info("Updated object: " + object);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteObject(int id) {
        em.remove(getObject(id));
        logger.info("Deleted object with id = " + id);
    }
}
