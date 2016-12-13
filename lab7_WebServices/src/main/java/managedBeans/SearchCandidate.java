package managedBeans;

import beans.SearchBean;
import entities.Vacancy;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "search", eager = true)
@SessionScoped
public class SearchCandidate {
    @EJB
    private SearchBean searchBean;

    public void searchCandidate(Vacancy vacancy) {
        searchBean.searchCandidate(vacancy, vacancy.getRequirements());
    }
}
