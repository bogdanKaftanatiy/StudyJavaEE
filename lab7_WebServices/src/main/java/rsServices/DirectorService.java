package rsServices;

import beans.DirectorBean;
import entities.Director;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Restful service for Director entity
 * Created by Bogdan Kaftanatiy on 13.12.2016.
 */
@Path("/director")
public class DirectorService {
    @EJB
    DirectorBean directorDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Director> getDirectors() {
        return  directorDao.getAllObjects();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Director getDirector(@PathParam("id") int id) {
        return directorDao.getObject(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDirector(Director director) {
        directorDao.updateObject(director);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDirector(@PathParam("id") int id) {
        directorDao.deleteObject(id);
    }
}
