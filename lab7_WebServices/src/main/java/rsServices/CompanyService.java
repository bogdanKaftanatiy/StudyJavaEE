package rsServices;

import beans.CompanyBean;
import entities.Company;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Restful service for Company entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Path("/company")
public class CompanyService {
    @EJB
    CompanyBean companyDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getCompanies() {
        return  companyDao.getAllObjects();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getCompany(@PathParam("id") int id) {
        return companyDao.getObject(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCompany(Company company) {
        companyDao.updateObject(company);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCompany(@PathParam("id") int id) {
        companyDao.deleteObject(id);
    }
}
