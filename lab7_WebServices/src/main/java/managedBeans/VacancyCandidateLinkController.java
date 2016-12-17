package managedBeans;

import beans.CandidateBean;
import beans.VacancyBean;
import entities.Candidate;
import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "linkBean", eager = true)
@SessionScoped
public class VacancyCandidateLinkController {
    private final static Logger logger = Logger.getLogger(VacancyCandidateLinkController.class);
    @EJB
    private VacancyBean vacancyDAO;
    @EJB
    private CandidateBean candidateDAO;
    private int currentVacancyID;
    private int currentCandidateID;

    public String toAdd() {
        currentVacancyID = 0;
        currentCandidateID = 0;
        return "addVacancyCandidateLink";
    }

    public String remove(Vacancy vacancy, Candidate candidate){
        vacancy.removeCandidate(candidate.getId());
        vacancyDAO.updateObject(vacancy);
        return "index?faces-redirect=true";
    }

    public String insert() {
        Vacancy vacancy = vacancyDAO.getObject(currentVacancyID);
        Candidate candidate = candidateDAO.getObject(currentCandidateID);
        vacancy.addCandidate(candidate);
        vacancyDAO.updateObject(vacancy);
        return "index?faces-redirect=true";
    }

    public int getCurrentVacancyID() {
        return currentVacancyID;
    }

    public void setCurrentVacancyID(int currentVacancyID) {
        this.currentVacancyID = currentVacancyID;
    }

    public int getCurrentCandidateID() {
        return currentCandidateID;
    }

    public void setCurrentCandidateID(int currentCandidateID) {
        this.currentCandidateID = currentCandidateID;
    }
}
