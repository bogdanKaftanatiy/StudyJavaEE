package test.java;

import main.java.dao.*;
import main.java.dbUtilities.ConnectionManager;
import main.java.model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestVacancyDAO {
    private static DAO<Integer, Director> directorDAO;
    private static DAO<Integer, Company> companyDAO;
    private static DAO<Integer, Vacancy> vacancyDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws SQLException, IOException, ClassNotFoundException {
        directorDAO = new DirectorDAO();
        companyDAO = new CompanyDAO();
        vacancyDAO = new VacancyDAO();
    }

    @Test
    public void testAddVacancy() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        Vacancy vacancyObj = new Vacancy(companyObj.getId(), "testVac", "testVac", "testVac", "testVac");
        vacancyObj.setId(vacancyDAO.addObject(vacancyObj));

        Vacancy newObj = vacancyDAO.getObject(vacancyObj.getId());

        Assert.assertEquals(vacancyObj, newObj);

        vacancyDAO.deleteObject(vacancyObj.getId());
        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testUpdateVacancy() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        Vacancy vacancyObj = new Vacancy(companyObj.getId(), "testVac", "testVac", "testVac", "testVac");
        vacancyObj.setId(vacancyDAO.addObject(vacancyObj));

        vacancyObj.setPosition("Test Update");
        vacancyDAO.updateObject(vacancyObj);
        Vacancy newObj = vacancyDAO.getObject(vacancyObj.getId());

        Assert.assertEquals(vacancyObj, newObj);

        vacancyDAO.deleteObject(vacancyObj.getId());
        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testDeleteVacancy() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        Vacancy vacancyObj = new Vacancy(companyObj.getId(), "testVac", "testVac", "testVac", "testVac");
        vacancyObj.setId(vacancyDAO.addObject(vacancyObj));

        vacancyDAO.deleteObject(vacancyObj.getId());

        Assert.assertFalse(vacancyDAO.getAllObjects().contains(vacancyObj));

        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());
    }

    @AfterClass
    public static void closeAfterClass() throws SQLException, IOException, ClassNotFoundException {
        ConnectionManager.getInstance().close();
    }
}
