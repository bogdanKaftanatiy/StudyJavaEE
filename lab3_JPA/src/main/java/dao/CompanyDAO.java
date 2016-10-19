package dao;

import entities.Company;

import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyDAO extends DAO<Integer, Company> {
    @Override
    public List<Company> getAllObjects() {
        TypedQuery<Company> namedQuery = em.createNamedQuery("Company.getAll", Company.class);
        List<Company> result = namedQuery.getResultList();

        for (Company c : result) {
            em.refresh(c);
        }

        return result;
    }

    @Override
    public Company getObject(Integer id) {
        return em.find(Company.class, id);
    }

    @Override
    public void addObject(Company object) {
        em.getTransaction().begin();
        Company companyFromDB = em.merge(object);
        em.getTransaction().commit();
    }
}
