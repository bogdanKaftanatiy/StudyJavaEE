package servlets;

import dao.CandidateDAO;
import dao.DAO;
import entities.Candidate;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "CandidateController", urlPatterns = "/CandidateController")
public class CandidateController extends HttpServlet {
    private static Logger logger;
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

        candidateDAO = new CandidateDAO(logger);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String cvURI = request.getParameter("cvURI");

        String candidateID = request.getParameter("id");
        if(candidateID == null || candidateID.isEmpty()) {
            candidateDAO.addObject(new Candidate(firstname, surname, email, cvURI));
        } else {
            int id = Integer.parseInt(candidateID);
            Candidate candidate = candidateDAO.getObject(id);
            candidate.setFirstname(firstname);
            candidate.setSurname(surname);
            candidate.setEmail(email);
            candidate.setCvURI(cvURI);

            candidateDAO.updateObject(candidate);
        }

        response.sendRedirect(request.getContextPath() + "/DBController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/JSP/candidate.jsp").forward(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Candidate candidate = candidateDAO.getObject(id);
            request.setAttribute("candidate", candidate);
            request.getRequestDispatcher("/JSP/candidate.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            candidateDAO.deleteObject(id);
            response.sendRedirect(request.getContextPath() + "/DBController");
        }
    }
}