package wsServices;

import beans.VacancyBean;
import entities.Vacancy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * JAXWSService Endpoint implementation class for Vacancy entity
 * Created by Bogdan Kaftanatiy on 17.12.2016.
 */
@Stateless
@WebService(endpointInterface = "wsServices.VacancyWS")
public class VacancyWSImpl implements VacancyWS {
    @EJB
    private VacancyBean vacancyDao;

    public Vacancy getVacancy(Integer id) {
        return vacancyDao.getObject(id);
    }

    public List<Vacancy> getVacancies() {
        return vacancyDao.getAllObjects();
    }

    public void updateVacancy(Vacancy vacancy) {
        vacancyDao.updateObject(vacancy);
    }

    public void removeVacancy(Vacancy vacancy) {
        vacancyDao.deleteObject(vacancy.getId());
    }
}
