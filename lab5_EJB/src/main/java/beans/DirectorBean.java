package beans;

import entities.Director;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;
import java.util.List;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class DirectorBean {
    private final static Logger logger = Logger.getLogger(DirectorBean.class);
    @Resource
    private UserTransaction userTransaction;
    @PersistenceContext(unitName = "vacancy_pu")
    protected EntityManager em;

    public void updateObject(Director object) {
        try {
            try {
                userTransaction.begin();
                em.merge(object);
                logger.info("Updated object: " + object);
            } finally {
                userTransaction.commit();
            }
        } catch (Exception e) {
            logger.error("Transaction failed!");
            throw new EJBException(e);
        }
    }

    public void deleteObject(int id) {
        try {
            try {
                userTransaction.begin();
                em.remove(getObject(id));
                logger.info("Deleted object with id = " + id);
            } finally {
                userTransaction.commit();
            }
        } catch (Exception e) {
            logger.error("Transaction failed!");
            throw new EJBException(e);
        }
    }

    public List<Director> getAllObjects() {
        TypedQuery<Director> namedQuery = em.createNamedQuery("Director.getAll", Director.class);
        List<Director> result = namedQuery.getResultList();

        logger.info("Received all objects from table 'Directors'");

        return result;
    }

    public Director getObject(int id) {
        logger.info("Get director with id = " + id);
        return em.find(Director.class, id);
    }
}
