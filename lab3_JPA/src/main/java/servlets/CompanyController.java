package servlets;

import dao.CompanyDAO;
import dao.DAO;
import dao.DirectorDAO;
import entities.Company;
import entities.Director;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "CompanyController", urlPatterns = "/CompanyController")
public class CompanyController extends HttpServlet {
    private static Logger logger;
    private DAO<Integer, Company> companyDAO;

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

        companyDAO = new CompanyDAO(logger);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dirIdStr = request.getParameter("directorID");
        int directorID = 0;
        try {
            directorID = Integer.parseInt(dirIdStr);
        } catch (NumberFormatException e) {
            logger.error("Error parsing director ID: " + e);
            request.setAttribute("e", e);
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }
        Director director = new DirectorDAO(logger).getObject(directorID);
        String companyID = request.getParameter("id");
        if(companyID == null || companyID.isEmpty()) {
            companyDAO.addObject(new Company(name, director));
        } else {
            int id = Integer.parseInt(companyID);
            Company company = companyDAO.getObject(id);
            company.setName(name);
            company.setDirector(director);

            companyDAO.updateObject(company);
        }

        response.sendRedirect(request.getContextPath() + "/DBController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/JSP/company.jsp").forward(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Company company = companyDAO.getObject(id);
            request.setAttribute("company", company);
            request.getRequestDispatcher("/JSP/company.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            companyDAO.deleteObject(id);
            response.sendRedirect(request.getContextPath() + "/DBController");
        }
    }
}
