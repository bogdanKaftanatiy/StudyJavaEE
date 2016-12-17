package managedBeans;

import org.apache.log4j.Logger;
import wsClient.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "directorBean", eager = true)
@SessionScoped
public class DirectorController {
    private final static Logger logger = Logger.getLogger(DirectorController.class);
    private DirectorWS dao;
    private Director currentDirector;

    @PostConstruct
    public void init() {
        DirectorWSImplService directorWSImplService = new DirectorWSImplService();
        dao = directorWSImplService.getDirectorWSImplPort();
    }

    public List<Director> getDirectorList() {
        return dao.getDirectors();
    }

    public String insert() {
        dao.updateDirector(currentDirector);
        return "index?faces-redirect=true";
    }

    public String toAdd(){
        currentDirector = new Director();
        return "addDirector";
    }

    public String remove(Director director) {
        dao.removeDirector(director);
        return "index?faces-redirect=true";
    }

    public String toEdit(Director director) {
        this.currentDirector = director;
        return "addDirector";
    }

    public Director getCurrentDirector() {
        return currentDirector;
    }

    public void setCurrentDirector(Director currentDirector) {
        this.currentDirector = currentDirector;
    }
}
