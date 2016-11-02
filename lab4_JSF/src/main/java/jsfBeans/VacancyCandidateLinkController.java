package jsfBeans;

import dao.CandidateDAO;
import dao.DAO;
import dao.VacancyDAO;
import entities.Candidate;
import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "linkBean", eager = true)
@SessionScoped
public class VacancyCandidateLinkController {
    protected final static Logger logger = Logger.getLogger(VacancyCandidateLinkController.class);
    private DAO<Integer, Vacancy> vacancyDAO;
    private DAO<Integer, Candidate> candidateDAO;
    private int currentVacancyID;
    private int currentCandidateID;

    public VacancyCandidateLinkController() {
        vacancyDAO = new VacancyDAO();
        candidateDAO = new CandidateDAO();
    }

    public String toAdd() {
        currentVacancyID = 0;
        currentCandidateID = 0;
        return "addVacancyCandidateLink";
    }

    public String remove(Vacancy vacancy, Candidate candidate){
        vacancy.removeCancidate(candidate.getId());
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
