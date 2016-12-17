package managedBeans;

import wsClient.*;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "candidateBean", eager = true)
@SessionScoped
public class CandidateController {
    private final static Logger logger = Logger.getLogger(CandidateController.class);
    private CandidateWS dao;
    private Candidate currentCandidate;

    @PostConstruct
    public void init() {
        CandidateWSImplService candidateWSImplService = new CandidateWSImplService();
        dao = candidateWSImplService.getCandidateWSImplPort();
    }

    public List<Candidate> getCandidateList() {
        return dao.getCandidates();
    }

    public String insert() {
        dao.updateCandidate(currentCandidate);
        return "index?faces-redirect=true";
    }

    public String toAdd() {
        currentCandidate = new Candidate();
        return "addCandidate";
    }

    public String remove(Candidate candidate) {
        dao.removeCandidate(candidate);
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
