package wsServices;

import entities.Company;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint Interface for Company entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@WebService
public interface CompanyWS {
    @WebMethod
    Company getCompany(Integer id);

    @WebMethod
    List<Company> getCompanies();

    @WebMethod
    void updateCompany(Company company);

    @WebMethod
    void removeCompany(Company company);
}
