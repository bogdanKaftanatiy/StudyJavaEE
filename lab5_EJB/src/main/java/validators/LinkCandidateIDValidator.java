package validators;

import beans.CandidateBean;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.candidateID")
public class LinkCandidateIDValidator implements Validator {
    private final static Logger logger = Logger.getLogger(LinkCandidateIDValidator.class);
    @EJB
    private CandidateBean candidateDAO;
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int candidateID;
        try {
            candidateID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse candidate id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }
        if(candidateDAO.getObject(candidateID) == null) {
            logger.error("Candidate with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Candidate with such id do not exist!"));
        }
    }
}
