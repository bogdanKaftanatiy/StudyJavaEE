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
public class LinkCandidateIDValidator implements Validator {
    private final static Logger logger = Logger.getLogger(LinkCandidateIDValidator.class);
    private CandidateWS candidateDAO;

    @PostConstruct
    public void init() {
        CandidateWSImplService candidateWSImplService = new CandidateWSImplService();
        candidateDAO = candidateWSImplService.getCandidateWSImplPort();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String data = o.toString();
        int candidateID;
        try {
            candidateID = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            logger.error("Failed parse candidate id!");
            throw new ValidatorException(new FacesMessage("Failed parse id!"));
        }
        if(candidateDAO.getCandidate(candidateID) == null) {
            logger.error("Candidate with such id do not exist!");
            throw new ValidatorException(new FacesMessage("Candidate with such id do not exist!"));
        }
    }
}
