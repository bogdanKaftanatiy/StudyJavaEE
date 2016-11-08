package validators;

import beans.CompanyBean;
import entities.Company;
import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.VacancyValidator")
public class VacancyValidator implements Validator {
    private final static Logger logger = Logger.getLogger(VacancyValidator.class);
    @EJB
    private CompanyBean companyDAO;
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int companyID;
        try {
            companyID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse company id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }

        Company company = companyDAO.getObject(companyID);
        if(company == null) {
            logger.error("Company with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Company with such id do not exist!"));
        }

        Object obj =  uiComponent.getAttributes().get("currentVacancy");
        Vacancy vacancy = (Vacancy) obj;
        vacancy.setCompany(company);
    }
}
