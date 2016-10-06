package test.java;

import main.java.dao.CompanyDAO;
import main.java.dao.DAO;
import main.java.dao.DirectorDAO;
import main.java.dbUtilities.ConnectionManager;
import main.java.model.Company;
import main.java.model.Director;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestCompanyDAO {
    private static DAO<Integer, Director> directorDAO;
    private static DAO<Integer, Company> companyDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws SQLException, IOException, ClassNotFoundException {
        directorDAO = new DirectorDAO();
        companyDAO = new CompanyDAO();
    }

    @Test
    public void testAddCompany() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        Company newObj = companyDAO.getObject(companyObj.getId());

        Assert.assertEquals(companyObj, newObj);

        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testUpdateCompany() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        companyObj.setName("Test Update");
        companyDAO.updateObject(companyObj);
        Company newObj = companyDAO.getObject(companyObj.getId());

        Assert.assertEquals(companyObj, newObj);

        companyDAO.deleteObject(companyObj.getId());
        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testDeleteCompany() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        Company companyObj = new Company("TestCompany", directorObj.getId());
        companyObj.setId(companyDAO.addObject(companyObj));

        companyDAO.deleteObject(companyObj.getId());

        Assert.assertFalse(companyDAO.getAllObjects().contains(companyObj));

        directorDAO.deleteObject(directorObj.getId());
    }

    @AfterClass
    public static void closeAfterClass() throws SQLException, IOException, ClassNotFoundException {
        ConnectionManager.getInstance().close();
    }
}
