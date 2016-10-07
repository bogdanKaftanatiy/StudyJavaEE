package main.java.dao;

import main.java.dbUtilities.ConnectionManager;
import main.java.model.Vacancy;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO implements DAO<Integer, Vacancy> {
    private ConnectionManager connectionManager;

    public VacancyDAO(InputStream is) throws SQLException, IOException, ClassNotFoundException {
        connectionManager = ConnectionManager.getInstance(is);
    }

    @Override
    public List<Vacancy> getAllObjects() throws SQLException {
        Connection connection = connectionManager.retrive();
        List<Vacancy> result = new ArrayList<>();
        String query = "SELECT * FROM lab1_jdbc.vacancy;";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        result.addAll(getObjects(resultSet));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Vacancy getObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        Vacancy result;
        String query = "SELECT * FROM lab1_jdbc.vacancy WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        result = new Vacancy(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Integer addObject(Vacancy object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "INSERT INTO lab1_jdbc.vacancy (companyID, position, requirements, description, email)" +
                        "VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, object.getCompanyID());
        statement.setString(2, object.getPosition());
        statement.setString(3, object.getRequirements());
        statement.setString(4, object.getDescription());
        statement.setString(5, object.getEmail());
        statement.executeUpdate();

        connectionManager.putback(connection);
        return getMaxID();
    }

    @Override
    public void updateObject(Vacancy object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "UPDATE lab1_jdbc.vacancy SET companyID = ?, position = ?, requirements = ?, " +
                        "description = ?, email = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, object.getCompanyID());
        statement.setString(2, object.getPosition());
        statement.setString(3, object.getRequirements());
        statement.setString(4, object.getDescription());
        statement.setString(5, object.getEmail());
        statement.setInt(6, object.getId());
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    @Override
    public void deleteObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "DELETE FROM lab1_jdbc.vacancy WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    private List<Vacancy> getObjects(ResultSet resultSet) throws SQLException {
        List<Vacancy> result = new ArrayList<>();

        while (resultSet.next()) {
            int id;
            int companyID;
            String position;
            String requirements;
            String description;
            String email;

            id = resultSet.getInt(1);
            companyID = resultSet.getInt(2);
            position = resultSet.getString(3);
            requirements = resultSet.getString(4);
            description = resultSet.getString(5);
            email = resultSet.getString(6);

            result.add(new Vacancy(id, companyID, position, requirements, description, email));
        }

        return result;
    }

    private int getMaxID() throws SQLException {
        Connection connection = connectionManager.retrive();
        int result;
        String query = "SELECT  MAX(id) FROM lab1_jdbc.vacancy";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        result = resultSet.getInt(1);
        connectionManager.putback(connection);
        return result;
    }
}
