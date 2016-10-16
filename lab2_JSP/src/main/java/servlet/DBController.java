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
    private String DISPLAY_DB = "/JSP/displayDB.jsp";
    private String ERROR = "/JSP/errorPage.jsp";

    private DAO<Integer, Director> directorDAO;
    private DAO<Integer, Company> companyDAO;
    private DAO<Integer, Vacancy> vacancyDAO;

    private void initDAO() throws SQLException, IOException, ClassNotFoundException {
        if (directorDAO == null)
            directorDAO = new DirectorDAO(getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
        if (companyDAO == null)
            companyDAO = new CompanyDAO(getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
        if (vacancyDAO == null)
            vacancyDAO = new VacancyDAO(getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            initDAO();
        } catch (SQLException | ClassNotFoundException e) {
            RequestDispatcher view = request.getRequestDispatcher(ERROR);
            view.forward(handleException(e, request), response);
        }
        String type = request.getParameter("formName");
        if("vacancyForm".equalsIgnoreCase(type)) {
            String companyStr = request.getParameter("companyID");
            int companyID = 0;
            try {
                companyID = Integer.parseInt(companyStr);
            } catch (NumberFormatException e) {
                RequestDispatcher view = request.getRequestDispatcher(ERROR);
                view.forward(handleException(e, request), response);
            }
            String position = request.getParameter("position");
            String requirements = request.getParameter("requirements");
            String description = request.getParameter("description");
            String email = request.getParameter("email");

            String vacancyId = request.getParameter("id");
            if (vacancyId == null || vacancyId.isEmpty()) {
                try {
                    vacancyDAO.addObject(new Vacancy(companyID, position, requirements, description, email));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            } else {
                int id = 0;
                try {
                    id = Integer.parseInt(vacancyId);
                } catch (NumberFormatException e){
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
                try {
                    vacancyDAO.updateObject(new Vacancy(id, companyID, position, requirements, description, email));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            }
        } else if ("companyForm".equalsIgnoreCase(type)) {
            String name = request.getParameter("name");
            String directorStr = request.getParameter("directorID");
            int directorID = 0;
            try {
                directorID = Integer.parseInt(directorStr);
            } catch (NumberFormatException e) {
                RequestDispatcher view = request.getRequestDispatcher(ERROR);
                view.forward(handleException(e, request), response);
            }
            String companyID = request.getParameter("id");
            if(companyID == null || companyID.isEmpty()) {
                try {
                    companyDAO.addObject(new Company(name, directorID));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            } else {
                int id = 0;
                try {
                    id = Integer.parseInt(companyID);
                }catch (NumberFormatException e){
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
                try {
                    companyDAO.updateObject(new Company(id, name, directorID));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            }
        } else if ("directorForm".equalsIgnoreCase(type)) {
            String firstName = request.getParameter("firstName");
            String surName = request.getParameter("surName");

            String directorID = request.getParameter("id");
            if(directorID == null || directorID.isEmpty()) {
                try {
                    directorDAO.addObject(new Director(firstName, surName));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            } else {
                int id = 0;
                try {
                    id = Integer.parseInt(directorID);
                } catch (NumberFormatException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
                try {
                    directorDAO.updateObject(new Director(id, firstName, surName));
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(DISPLAY_DB);
        try {
            request.setAttribute("allDirector", directorDAO.getAllObjects());
            request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
            request.setAttribute("allCompany", companyDAO.getAllObjects());
        } catch (SQLException e) {
            RequestDispatcher viewError = request.getRequestDispatcher(ERROR);
            viewError.forward(handleException(e, request), response);
        }
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            initDAO();
        } catch (SQLException | ClassNotFoundException e) {
            RequestDispatcher view = request.getRequestDispatcher(ERROR);
            view.forward(handleException(e, request), response);
        }
        String forward = "";
        String action = request.getParameter("action");
        String object = request.getParameter("object");
        String INSERT_OR_EDIT_VACANCY = "/JSP/vacancy.jsp";
        String INSERT_OR_EDIT_DIRECTOR = "/JSP/director.jsp";
        String INSERT_OR_EDIT_COMPANY = "/JSP/company.jsp";
        if("displayDB".equalsIgnoreCase(action)){
            try {
                request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
                request.setAttribute("allCompany", companyDAO.getAllObjects());
                request.setAttribute("allDirector", directorDAO.getAllObjects());
            } catch (SQLException e) {
                RequestDispatcher view = request.getRequestDispatcher(ERROR);
                view.forward(handleException(e, request), response);
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
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            } else if ("company".equalsIgnoreCase(object)) {
                try {
                    Company company = companyDAO.getObject(id);
                    request.setAttribute("company", company);
                    forward = INSERT_OR_EDIT_COMPANY;
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
                }
            } else if ("director".equalsIgnoreCase(object)) {
                try {
                    Director director = directorDAO.getObject(id);
                    request.setAttribute("director", director);
                    forward = INSERT_OR_EDIT_DIRECTOR;
                } catch (SQLException e) {
                    RequestDispatcher view = request.getRequestDispatcher(ERROR);
                    view.forward(handleException(e, request), response);
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
                RequestDispatcher view = request.getRequestDispatcher(ERROR);
                view.forward(handleException(e, request), response);
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

    private HttpServletRequest handleException(Exception e, HttpServletRequest request) {
        request.setAttribute("message", e.getMessage());
        request.setAttribute("stackTrace", e.getStackTrace());
        request.setAttribute("exceptionName", e.getClass().getName());
        return request;
    }
}
