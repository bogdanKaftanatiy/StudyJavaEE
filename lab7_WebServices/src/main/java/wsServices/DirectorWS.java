package wsServices;

import entities.Director;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint Interface for Director entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@WebService
public interface DirectorWS {
    @WebMethod
    Director getDirector(Integer id);

    @WebMethod
    List<Director> getDirectors();

    @WebMethod
    void updateDirector(Director director);

    @WebMethod
    void removeDirector(Director director);
}
