package dao;

import entities.Company;
import org.apache.log4j.Logger;

import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyDAO extends DAO<Integer, Company> {
    public CompanyDAO(Logger l) {
        super(l);
    }

    @Override
    public List<Company> getAllObjects() {
        TypedQuery<Company> namedQuery = em.createNamedQuery("Company.getAll", Company.class);
        List<Company> result = namedQuery.getResultList();

        for (Company c : result) {
            em.refresh(c);
        }

        logger.info("Received all objects from table 'Companies'");

        return result;
    }

    @Override
    public Company getObject(Integer id) {
        logger.info("Get company with id = " + id);
        return em.find(Company.class, id);
    }
}
