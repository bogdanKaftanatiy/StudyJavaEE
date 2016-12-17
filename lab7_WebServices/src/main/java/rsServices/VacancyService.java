package rsServices;

import beans.VacancyBean;
import entities.Vacancy;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Restful service for Vacancy entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Path("/vacancy")
public class VacancyService {
    @EJB
    VacancyBean vacancyDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacancy> getVacancies() {
        return  vacancyDao.getAllObjects();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacancy getVacancy(@PathParam("id") int id) {
        return vacancyDao.getObject(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateVacancy(Vacancy vacancy) {
        vacancyDao.updateObject(vacancy);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteVacancy(@PathParam("id") int id) {
        vacancyDao.deleteObject(id);
    }
}
