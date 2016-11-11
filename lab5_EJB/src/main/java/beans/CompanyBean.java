package beans;

import entities.Company;

import javax.ejb.*;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompanyBean extends AbstractDAO<Company> {

    @Override
    public List<Company> getAllObjects() {
        TypedQuery<Company> namedQuery = em.createNamedQuery("Company.getAll", Company.class);
        List<Company> result = namedQuery.getResultList();

        logger.info("Received all objects from table 'Companies'");

        return result;
    }

    @Override
    public Company getObject(int id) {
        logger.info("Get company with id = " + id);
        return em.find(Company.class, id);
    }
}
