package servlets;

import dao.CompanyDAO;
import dao.DAO;
import dao.DirectorDAO;
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

@WebServlet(name = "DirectorController", urlPatterns = "/DirectorController")
public class DirectorController extends HttpServlet {
    private static Logger logger;
    private DAO<Integer, Director> directorDAO;

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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String companyStr = request.getParameter("companyID");

        String directorID = request.getParameter("id");
        if(directorID == null || directorID.isEmpty()) {
            directorDAO.addObject(new Director(firstname, surname));
        } else {
            int id = Integer.parseInt(directorID);
            Director addDirector = directorDAO.getObject(id);
            addDirector.setFirstname(firstname);
            addDirector.setSurname(surname);
            int companyID;
            if(companyStr != null && !companyStr.isEmpty()) {
                companyID = Integer.parseInt(companyStr);
                addDirector.setCompany(new CompanyDAO(logger).getObject(companyID));
            }

            directorDAO.updateObject(addDirector);
        }

        response.sendRedirect(request.getContextPath() + "/DBController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/JSP/director.jsp").forward(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Director director = directorDAO.getObject(id);
            request.setAttribute("director", director);
            request.getRequestDispatcher("/JSP/director.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            directorDAO.deleteObject(id);
            response.sendRedirect(request.getContextPath() + "/DBController");
        }
    }
}
