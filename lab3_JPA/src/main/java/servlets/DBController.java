package servlets;

import dao.*;
import entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DBController", urlPatterns = "/DBController")
public class DBController extends HttpServlet {
    private String DISPLAY_DB = "/JSP/displayDB.jsp";

    private DAO<Integer, Director> directorDAO;
    private DAO<Integer, Company> companyDAO;
    private DAO<Integer, Vacancy> vacancyDAO;
    private DAO<Integer, Candidate> candidateDAO;

    public DBController() {
        directorDAO = new DirectorDAO();
        companyDAO = new CompanyDAO();
        vacancyDAO = new VacancyDAO();
        candidateDAO = new CandidateDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allDirector", directorDAO.getAllObjects());
        request.setAttribute("allCompany", companyDAO.getAllObjects());
        request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
        request.setAttribute("allCandidate", candidateDAO.getAllObjects());
        RequestDispatcher view = request.getRequestDispatcher(DISPLAY_DB);
        view.forward(request, response);
    }
}
