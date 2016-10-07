package main.java.servlet;

import main.java.dao.*;
import main.java.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DBController", urlPatterns = "/DBController")
public class DBController extends HttpServlet {
    private String INSERT_OR_EDIT_VACANCY = "/vacancy.jsp";
    private String INSERT_OR_EDIT_COMPANY = "/company.jsp";
    private String INSERT_OR_EDIT_DIRECTOR = "/director.jsp";
    private String DISPLAY_DB = "/displayDB.jsp";

    private DAO<Integer, Director> directorDAO;
    private DAO<Integer, Company> companyDAO;
    private DAO<Integer, Vacancy> vacancyDAO;

    public DBController() {
        super();
        try {
            directorDAO = new DirectorDAO();
            companyDAO = new CompanyDAO();
            vacancyDAO = new VacancyDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("formName");
        response.getWriter().println(type);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        String object = request.getParameter("object");
        if("displayDB".equalsIgnoreCase(action)){
            try {
                request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
                request.setAttribute("allCompany", companyDAO.getAllObjects());
                request.setAttribute("allDirector", directorDAO.getAllObjects());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = DISPLAY_DB;
        } else if("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if("vacancy".equalsIgnoreCase(object)){
                try {
                    Vacancy vacancy = vacancyDAO.getObject(id);
                    request.setAttribute("vacancy", vacancy);
                    forward = INSERT_OR_EDIT_VACANCY;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if ("company".equalsIgnoreCase(object)) {
                try {
                    Company company = companyDAO.getObject(id);
                    request.setAttribute("company", company);
                    forward = INSERT_OR_EDIT_COMPANY;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if ("director".equalsIgnoreCase(object)) {
                try {
                    Director director = directorDAO.getObject(id);
                    request.setAttribute("director", director);
                    forward = INSERT_OR_EDIT_DIRECTOR;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                if ("vacancy".equalsIgnoreCase(object)) {
                    vacancyDAO.deleteObject(id);
                } else if ("company".equalsIgnoreCase(object)) {
                    companyDAO.deleteObject(id);
                } else if ("director".equalsIgnoreCase(object)) {
                    directorDAO.deleteObject(id);
                }
                request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
                request.setAttribute("allCompany", companyDAO.getAllObjects());
                request.setAttribute("allDirector", directorDAO.getAllObjects());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = DISPLAY_DB;
        } else if ("insert".equalsIgnoreCase(action)) {
            if ("vacancy".equalsIgnoreCase(object)) {
                forward = INSERT_OR_EDIT_VACANCY;
            } else if ("company".equalsIgnoreCase(object)) {
                forward = INSERT_OR_EDIT_COMPANY;
            } else if ("director".equalsIgnoreCase(object)) {
                forward = INSERT_OR_EDIT_DIRECTOR;
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
