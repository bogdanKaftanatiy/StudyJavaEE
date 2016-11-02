package jsfBeans;

import dao.CandidateDAO;
import dao.DAO;
import entities.Candidate;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "candidateBean", eager = true)
@SessionScoped
public class CandidateController {
    protected final static Logger logger = Logger.getLogger(CandidateController.class);
    private DAO<Integer, Candidate> dao;
    private Candidate currentCandidate;

    public CandidateController() {
        dao = new CandidateDAO();
    }

    public List<Candidate> getCandidateList() {
        return dao.getAllObjects();
    }

    public String insert() {
        dao.updateObject(currentCandidate);
        return "index?faces-redirect=true";
    }

    public String toAdd() {
        currentCandidate = new Candidate();
        return "addCandidate";
    }

    public String remove(Candidate candidate) {
        dao.deleteObject(candidate.getId());
        return "index?faces-redirect=true";
    }

    public String toEdit(Candidate candidate) {
        this.currentCandidate = candidate;
        return "addCandidate";
    }

    public Candidate getCurrentCandidate() {
        return currentCandidate;
    }

    public void setCurrentCandidate(Candidate currentCandidate) {
        this.currentCandidate = currentCandidate;
    }
}
