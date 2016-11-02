package jsfBeans;

import dao.DAO;
import dao.VacancyDAO;
import entities.Vacancy;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "vacancyBean", eager = true)
@SessionScoped
public class VacancyController {
    protected final static Logger logger = Logger.getLogger(DirectorController.class);
    private DAO<Integer, Vacancy> dao;
    private Vacancy currentVacancy;
    private int currentCompanyID;

    public VacancyController() {
        dao = new VacancyDAO();
    }

    public List<Vacancy> getVacancyList() {
        return dao.getAllObjects();
    }

    public String insert() {
        dao.updateObject(currentVacancy);
        return "index?faces-redirect=true";
    }

    public String toAdd(){
        currentVacancy = new Vacancy();
        return "addVacancy";
    }

    public String remove(Vacancy vacancy) {
        dao.deleteObject(vacancy.getId());
        return "index?faces-redirect=true";
    }

    public String toEdit(Vacancy vacancy) {
        this.currentVacancy = vacancy;
        this.currentCompanyID = this.currentVacancy.getCompany().getId();
        return "addVacancy";
    }

    public Vacancy getCurrentVacancy() {
        return currentVacancy;
    }

    public void setCurrentVacancy(Vacancy currentVacancy) {
        this.currentVacancy = currentVacancy;
    }

    public int getCurrentCompanyID() {
        return currentCompanyID;
    }

    public void setCurrentCompanyID(int currentCompanyID) {
        this.currentCompanyID = currentCompanyID;
    }
}
