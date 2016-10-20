package servlets;

import dao.CandidateDAO;
import dao.DAO;
import dao.VacancyDAO;
import entities.Candidate;
import entities.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VacancyCandidateLinkController", urlPatterns = "/VacancyCandidateLinkController")
public class VacancyCandidateLinkController extends HttpServlet {
    DAO<Integer, Vacancy> vacancyDAO;
    DAO<Integer, Candidate> candidateDAO;

    public VacancyCandidateLinkController() {
        vacancyDAO = new VacancyDAO();
        candidateDAO = new CandidateDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vacancyStr = request.getParameter("vacancyID");
        String candidateStr = request.getParameter("candidateID");
        int vacancyID = 0;
        int candidateID = 0;

        try {
            vacancyID = Integer.parseInt(vacancyStr);
            candidateID = Integer.parseInt(candidateStr);
        } catch (NumberFormatException e) {
            request.setAttribute("e", e);
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }

        Vacancy vacancy = vacancyDAO.getObject(vacancyID);
        Candidate candidate = candidateDAO.getObject(candidateID);
        if (vacancy == null || candidate == null) {
            request.setAttribute("e", new IllegalArgumentException("Object with such ID not found"));
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }

        vacancy.addCandidate(candidate);
        vacancyDAO.updateObject(vacancy);

        response.sendRedirect(request.getContextPath() + "/DBController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/JSP/vacancy_candidate.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            int vacancyID = Integer.parseInt(request.getParameter("vacID"));
            int candidateID = Integer.parseInt(request.getParameter("canID"));
            Vacancy vacancy = vacancyDAO.getObject(vacancyID);
            vacancy.removeCancidate(candidateID);
            vacancyDAO.updateObject(vacancy);
            response.sendRedirect(request.getContextPath() + "/DBController");
        }
    }
}
