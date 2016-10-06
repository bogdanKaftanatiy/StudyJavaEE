package test.java;

import main.java.dao.DAO;
import main.java.dao.DirectorDAO;
import main.java.dbUtilities.ConnectionManager;
import main.java.model.Director;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestDirectorDAO {
    private static DAO<Integer, Director> directorDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws SQLException, IOException, ClassNotFoundException {
        directorDAO = new DirectorDAO();
    }

    @Test
    public void testAddDirector() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));
        Director newObj = directorDAO.getObject(directorObj.getId());

        Assert.assertEquals(directorObj, newObj);

        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testUpdateDirector() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        directorObj.setFirstName("Test Update");
        directorDAO.updateObject(directorObj);
        Director newObj = directorDAO.getObject(directorObj.getId());

        Assert.assertEquals(directorObj, newObj);

        directorDAO.deleteObject(directorObj.getId());
    }

    @Test
    public void testDeleteDirector() throws SQLException {
        Director directorObj = new Director("Merlin", "Tester");
        directorObj.setId(directorDAO.addObject(directorObj));

        directorDAO.deleteObject(directorObj.getId());

        Assert.assertFalse(directorDAO.getAllObjects().contains(directorObj));
    }

    @AfterClass
    public static void closeAfterClass() throws SQLException, IOException, ClassNotFoundException {
        ConnectionManager.getInstance().close();
    }
}
