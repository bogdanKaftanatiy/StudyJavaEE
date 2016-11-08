package managedBeans;

import beans.DirectorBean;
import entities.Director;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "directorBean", eager = true)
@SessionScoped
public class DirectorController {
    private final static Logger logger = Logger.getLogger(DirectorController.class);
    @EJB
    private DirectorBean dao;
    private Director currentDirector;

    public List<Director> getDirectorList() {
        return dao.getAllObjects();
    }

    public String insert() {
        dao.updateObject(currentDirector);
        return "index?faces-redirect=true";
    }

    public String toAdd(){
        currentDirector = new Director();
        return "addDirector";
    }

    public String remove(Director director) {
        dao.deleteObject(director.getId());
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
