package servlets;

import dao.CompanyDAO;
import dao.DAO;
import dao.VacancyDAO;
import entities.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VacancyController", urlPatterns = "/VacancyController")
public class VacancyController extends HttpServlet {
    private DAO<Integer, Vacancy> vacancyDAO;

    public VacancyController() {
        vacancyDAO = new VacancyDAO();
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
            request.setAttribute("stackTrace", e.getStackTrace());
            request.setAttribute("message", e.getMessage());
            request.setAttribute("exceptionName", e.getClass().getName());
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }

        String vacancyId = request.getParameter("id");
        if (vacancyId == null || vacancyId.isEmpty()) {
            vacancyDAO.addObject(new Vacancy(new CompanyDAO().getObject(companyID), position, requirements, description, email));
        } else {
            int id = Integer.parseInt(vacancyId);
            Vacancy vacancy = vacancyDAO.getObject(id);
            vacancy.setCompany(new CompanyDAO().getObject(companyID));
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
