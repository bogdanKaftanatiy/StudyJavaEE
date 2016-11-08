package validators;

import beans.VacancyBean;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.vacancyID")
public class LinkVacancyIDValidator implements Validator {
    private final static Logger logger = Logger.getLogger(LinkVacancyIDValidator.class);
    @EJB
    private VacancyBean vacancyDAO;
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int vacancyID;
        try {
            vacancyID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse vacancy id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }
        if(vacancyDAO.getObject(vacancyID) == null) {
            logger.error("Vacancy with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Vacancy with such id do not exist!"));
        }
    }
}
