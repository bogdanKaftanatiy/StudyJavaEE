package validators;

import beans.DirectorBean;
import entities.Company;
import entities.Director;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class CompanyValidator implements Validator {
    private final static Logger logger = Logger.getLogger(CompanyValidator.class);
    @EJB
    private DirectorBean directorDAO;

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int directorID;
        try {
            directorID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse director id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }
        Director director = directorDAO.getObject(directorID);
        if(director == null) {
            logger.error("Director with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Director with such id do not exist!"));
        }

        Object obj =  uiComponent.getAttributes().get("currentCompany");
        Company company = (Company) obj;
        company.setDirector(director);
    }
}
