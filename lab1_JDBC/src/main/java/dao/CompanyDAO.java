package main.java.dao;

import main.java.dbUtilities.ConnectionManager;
import main.java.model.Company;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO implements DAO<Integer, Company> {
    private ConnectionManager connectionManager;

    public CompanyDAO() throws SQLException, IOException, ClassNotFoundException {
        connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public List<Company> getAllObjects() throws SQLException {
        Connection connection = connectionManager.retrive();
        List<Company> result = new ArrayList<>();
        String query = "SELECT * FROM lab1_jdbc.company;";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        result.addAll(getObjects(resultSet));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Company getObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        Company result;
        String query = "SELECT * FROM lab1_jdbc.company WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        result = new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Integer addObject(Company object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "INSERT INTO lab1_jdbc.company (name, directorID) " +
                        "VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, object.getName());
        statement.setInt(2, object.getDirectorID());
        statement.executeUpdate();

        connectionManager.putback(connection);
        return getMaxID();
    }

    @Override
    public void updateObject(Company object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "UPDATE lab1_jdbc.company SET name = ?, directorID = ? " +
                        "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, object.getName());
        statement.setInt(2, object.getDirectorID());
        statement.setInt(3, object.getId());
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    @Override
    public void deleteObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "DELETE FROM lab1_jdbc.company WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    private List<Company> getObjects(ResultSet resultSet) throws SQLException {
        List<Company> result = new ArrayList<>();

        while (resultSet.next()) {
            int id;
            String name;
            int directorID;

            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            directorID = resultSet.getInt(3);

            result.add(new Company(id, name, directorID));
        }

        return result;
    }

    private int getMaxID() throws SQLException {
        Connection connection = connectionManager.retrive();
        int result;
        String query = "SELECT  MAX(id) FROM lab1_jdbc.company";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        result = resultSet.getInt(1);
        connectionManager.putback(connection);
        return result;
    }
}
