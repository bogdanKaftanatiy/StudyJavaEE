package servlets;

import dao.CompanyDAO;
import dao.DAO;
import dao.DirectorDAO;
import entities.Company;
import entities.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyController", urlPatterns = "/CompanyController")
public class CompanyController extends HttpServlet {
    private DAO<Integer, Company> companyDAO;

    public CompanyController() {
        companyDAO = new CompanyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dirIdStr = request.getParameter("directorID");
        int directorID = 0;
        try {
            directorID = Integer.parseInt(dirIdStr);
        } catch (NumberFormatException e) {
            request.setAttribute("e", e);
            request.getRequestDispatcher("/JSP/errorPage.jsp").forward(request, response);
        }
        Director director = new DirectorDAO().getObject(directorID);
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
