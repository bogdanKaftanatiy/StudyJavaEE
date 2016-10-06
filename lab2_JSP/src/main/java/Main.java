package main.java;

import main.java.dao.*;
import main.java.dbUtilities.ConnectionManager;
import main.java.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main{
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        DAO<Integer, Director> directorDAO = new DirectorDAO();
        DAO<Integer, Company> companyDAO = new CompanyDAO();
        DAO<Integer, Vacancy> vacancyDAO = new VacancyDAO();

        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));
        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));
        Vacancy vacancyObj = new Vacancy(companyObj.getId(), "testVac", "testVac", "testVac", "testVac");
        vacancyObj.setId(vacancyDAO.addObject(vacancyObj));

        printDB(vacancyDAO);

        vacancyObj.setPosition("Test Update");
        vacancyDAO.updateObject(vacancyObj);

        printDB(vacancyDAO);

        vacancyDAO.deleteObject(vacancyObj.getId());
        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());

        printDB(vacancyDAO);

        ConnectionManager.getInstance().close();
    }

    public static <T> void printDB(DAO<Integer, T> dao) throws SQLException {
        System.out.println("DB:");
        List<T> array = dao.getAllObjects();
        for (T v : array) {
            System.out.println(v);
        }
        System.out.println();
    }
}
