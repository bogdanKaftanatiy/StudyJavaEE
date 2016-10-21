package servlets;

import dao.*;
import entities.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DBController", urlPatterns = "/DBController")
public class DBController extends HttpServlet {
    private final static Logger logger = Logger.getLogger(DBController.class);

    private String DISPLAY_DB = "/JSP/displayDB.jsp";

    private DAO<Integer, Director> directorDAO;
    private DAO<Integer, Company> companyDAO;
    private DAO<Integer, Vacancy> vacancyDAO;
    private DAO<Integer, Candidate> candidateDAO;

    @Override
    public void init() throws ServletException {
        super.init();

        directorDAO = new DirectorDAO();
        companyDAO = new CompanyDAO();
        vacancyDAO = new VacancyDAO();
        candidateDAO = new CandidateDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Display DB");
        request.setAttribute("allDirector", directorDAO.getAllObjects());
        request.setAttribute("allCompany", companyDAO.getAllObjects());
        request.setAttribute("allVacancy", vacancyDAO.getAllObjects());
        request.setAttribute("allCandidate", candidateDAO.getAllObjects());
        RequestDispatcher view = request.getRequestDispatcher(DISPLAY_DB);
        view.forward(request, response);
    }
}
