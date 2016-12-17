package managedBeans;

import org.apache.log4j.Logger;
import wsClient.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "companyBean", eager = true)
@SessionScoped
public class CompanyController {
    private final static Logger logger = Logger.getLogger(CompanyController.class);
    private CompanyWS dao;
    private Company currentCompany;
    private int currentDirectorID;

    @PostConstruct
    public void init() {
        CompanyWSImplService companyWSImplService = new CompanyWSImplService();
        dao = companyWSImplService.getCompanyWSImplPort();
    }

    public List<Company> getCompanyList() {
        return dao.getCompanies();
    }

    public String insert() {
        dao.updateCompany(currentCompany);
        return "index?faces-redirect=true";
    }

    public String toAdd() {
        currentCompany = new Company();
        currentDirectorID = 0;
        return "addCompany";
    }

    public String remove(Company company) {
        dao.removeCompany(company);
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
