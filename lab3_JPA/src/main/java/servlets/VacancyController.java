package servlets;

import dao.CompanyDAO;
import dao.DAO;
import dao.VacancyDAO;
import entities.Vacancy;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "VacancyController", urlPatterns = "/VacancyController")
public class VacancyController extends HttpServlet {
    private static Logger logger;
    private DAO<Integer, Vacancy> vacancyDAO;

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

        vacancyDAO = new VacancyDAO(logger);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String position = request.getParameter("position");
        String requirements = request.getParameter("requirements");
        String description = request.getParameter("description");
        String email = request.getParameter("email");

        String companyStr = request.getParameter("companyID");
        int companyID = 0;
        try {
            companyID = Integer.parseInt(companyStr);
        } catch (NumberFormatException e) {
            logger.error("Error parsing company ID: " + e);
            request.setAttribute("e", e);
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }

        String vacancyId = request.getParameter("id");
        if (vacancyId == null || vacancyId.isEmpty()) {
            vacancyDAO.addObject(new Vacancy(new CompanyDAO(logger).getObject(companyID), position, requirements, description, email));
        } else {
            int id = Integer.parseInt(vacancyId);
            Vacancy vacancy = vacancyDAO.getObject(id);
            vacancy.setCompany(new CompanyDAO(logger).getObject(companyID));
            vacancy.setPosition(position);
            vacancy.setRequirements(requirements);
            vacancy.setDescription(description);
            vacancy.setEmail(email);

            vacancyDAO.updateObject(vacancy);
        }

        response.sendRedirect(request.getContextPath() + "/DBController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/JSP/vacancy.jsp").forward(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Vacancy vacancy = vacancyDAO.getObject(id);
            request.setAttribute("vacancy", vacancy);
            request.getRequestDispatcher("/JSP/vacancy.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            vacancyDAO.deleteObject(id);
            response.sendRedirect(request.getContextPath() + "/DBController");
        }
    }
}
