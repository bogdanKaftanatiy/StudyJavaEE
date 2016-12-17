package validators;

import wsClient.*;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class LinkVacancyIDValidator implements Validator {
    private final static Logger logger = Logger.getLogger(LinkVacancyIDValidator.class);
    private VacancyWS vacancyDAO;

    @PostConstruct
    public void init() {
        VacancyWSImplService vacancyWSImplService = new VacancyWSImplService();
        vacancyDAO = vacancyWSImplService.getVacancyWSImplPort();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int vacancyID;
        try {
            vacancyID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse vacancy id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }
        if(vacancyDAO.getVacancy(vacancyID) == null) {
            logger.error("Vacancy with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Vacancy with such id do not exist!"));
        }
    }
}
