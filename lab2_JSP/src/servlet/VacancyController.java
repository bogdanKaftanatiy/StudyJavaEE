package servlet;

import dao.VacancyDAO;
import model.Vacancy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Bogdan Kaftanatiy on 04.10.2016.
 */
@WebServlet(name = "VacancyController", urlPatterns = "/VacancyController")
public class VacancyController extends HttpServlet {
    private String INSERT_OR_EDIT = "/vacancy.jsp";
    private String LIST_VACANCY = "/listVacancy.jsp";
    private VacancyDAO dao;

    public VacancyController() {
        super();
        dao = new VacancyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        String requirements = request.getParameter("requirements");
        String description = request.getParameter("description");
        String email = request.getParameter("email");

        String vacancyId = request.getParameter("id");
        if (vacancyId == null || vacancyId.isEmpty()) {
            dao.addObject(new Vacancy(company, position, requirements, description, email));
        }
        else {
            int id = Integer.parseInt(vacancyId);
            dao.updateObject(new Vacancy(id, company, position, requirements, description, email));
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_VACANCY);
        request.setAttribute("allVacancy", dao.getAllObjects());
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteObject(id);
            forward = LIST_VACANCY;
            request.setAttribute("allVacancy", dao.getAllObjects());
        } else if (action.equalsIgnoreCase("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            Vacancy vacancy = dao.getObjectByID(id);
            request.setAttribute("vacancy", vacancy);
            forward = INSERT_OR_EDIT;
        } else if (action.equalsIgnoreCase("listVacancy")){
            request.setAttribute("allVacancy", dao.getAllObjects());
            forward = LIST_VACANCY;
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
