package jsfBeans;

import dao.CompanyDAO;
import dao.DAO;
import entities.Company;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "companyBean", eager = true)
@SessionScoped
public class CompanyController {
    protected final static Logger logger = Logger.getLogger(DirectorController.class);
    private DAO<Integer, Company> dao;
    private Company currentCompany;
    private int currentDirectorID;

    public CompanyController() {
        dao = new CompanyDAO();
    }

    public List<Company> getCompanyList() {
        return dao.getAllObjects();
    }

    public String insert() {
        dao.updateObject(currentCompany);
        return "index?faces-redirect=true";
    }

    public String toAdd() {
        currentCompany = new Company();
        return "addCompany";
    }

    public String remove(Company company) {
        dao.deleteObject(company.getId());
        return "index?faces-redirect=true";
    }

    public String toEdit(Company company) {
        this.currentCompany = company;
        this.currentDirectorID = currentCompany.getDirector().getId();
        return "addCompany";
    }

    public Company getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    public int getCurrentDirectorID() {
        return currentDirectorID;
    }

    public void setCurrentDirectorID(int currentDirectorID) {
        this.currentDirectorID = currentDirectorID;
    }
}
