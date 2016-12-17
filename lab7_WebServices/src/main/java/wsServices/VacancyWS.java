package wsServices;

import entities.Vacancy;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint Interface for Vacancy entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@WebService
public interface VacancyWS {
    @WebMethod
    Vacancy getVacancy(Integer id);

    @WebMethod
    List<Vacancy> getVacancies();

    @WebMethod
    void updateVacancy(Vacancy vacancy);

    @WebMethod
    void removeVacancy(Vacancy vacancy);
}
