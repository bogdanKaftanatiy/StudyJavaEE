package wsServices;

import beans.CompanyBean;
import entities.Company;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint implementation class for Company entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Stateless
@WebService(endpointInterface = "wsServices.CompanyWS")
public class CompanyWSImpl implements CompanyWS {
    @EJB
    private CompanyBean companyDao;

    public Company getCompany(Integer id) {
        return companyDao.getObject(id);
    }

    public List<Company> getCompanies() {
        return companyDao.getAllObjects();
    }

    public void updateCompany(Company company) {
        companyDao.updateObject(company);
    }

    public void removeCompany(Company company) {
        companyDao.deleteObject(company.getId());
    }
}
