package wsServices;

import beans.DirectorBean;
import entities.Director;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint implementation class for Director entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Stateless
@WebService(endpointInterface = "wsServices.DirectorWS")
public class DirectorWSImpl implements DirectorWS {
    @EJB
    private DirectorBean directorDao;

    public Director getDirector(Integer id) {
        return directorDao.getObject(id);
    }

    public List<Director> getDirectors() {
        return directorDao.getAllObjects();
    }

    public void updateDirector(Director director) {
        directorDao.updateObject(director);
    }

    public void removeDirector(Director director) {
        directorDao.deleteObject(director.getId());
    }
}
