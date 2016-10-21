package servlets;

import dao.*;
import entities.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "DBController", urlPatterns = "/DBController")
public class DBController extends HttpServlet {
    private static Logger logger;

    private String DISPLAY_DB = "/JSP/displayDB.jsp";

    private DAO<Integer, Director> directorDAO;
    private DAO<Integer, Company> companyDAO;
    private DAO<Integer, Vacancy> vacancyDAO;
    private DAO<Integer, Candidate> candidateDAO;

    @Override
    public void init() throws ServletException {
        super.init();

        Properties properties = new Properties();
        try {
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/log4j.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PropertyConfigurator.configure(properties);
        logger = Logger.getRootLogger();

        directorDAO = new DirectorDAO(logger);
        companyDAO = new CompanyDAO(logger);
        vacancyDAO = new VacancyDAO(logger);
        candidateDAO = new CandidateDAO(logger);
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
