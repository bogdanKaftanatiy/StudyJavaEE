package main.java.dao;

import main.java.dbUtilities.ConnectionManager;
import main.java.model.Director;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO implements DAO<Integer, Director> {
    private ConnectionManager connectionManager;

    public DirectorDAO(InputStream is) throws SQLException, IOException, ClassNotFoundException {
        connectionManager = ConnectionManager.getInstance(is);
    }

    @Override
    public List<Director> getAllObjects() throws SQLException {
        Connection connection = connectionManager.retrive();
        List<Director> result = new ArrayList<>();
        String query = "SELECT * FROM lab1_jdbc.managers;";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        result.addAll(getObjects(resultSet));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Director getObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        Director result;
        String query = "SELECT * FROM lab1_jdbc.managers WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        result = new Director(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

        connectionManager.putback(connection);
        return result;
    }

    @Override
    public Integer addObject(Director object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "INSERT INTO lab1_jdbc.managers (firstName, surname) " +
                        "VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, object.getFirstName());
        statement.setString(2, object.getSurName());
        statement.executeUpdate();

        connectionManager.putback(connection);
        return getMaxID();
    }

    @Override
    public void updateObject(Director object) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "UPDATE lab1_jdbc.managers SET firstName = ?, surname = ? " +
                        "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, object.getFirstName());
        statement.setString(2, object.getSurName());
        statement.setInt(3, object.getId());
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    @Override
    public void deleteObject(Integer id) throws SQLException {
        Connection connection = connectionManager.retrive();
        String query =  "DELETE FROM lab1_jdbc.managers WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);
        statement.executeUpdate();

        connectionManager.putback(connection);
    }

    private List<Director> getObjects(ResultSet resultSet) throws SQLException {
        List<Director> result = new ArrayList<>();

        while (resultSet.next()) {
            int id;
            String firstName;
            String surname;

            id = resultSet.getInt(1);
            firstName = resultSet.getString(2);
            surname = resultSet.getString(3);

            result.add(new Director(id, firstName, surname));
        }

        return result;
    }

    private int getMaxID() throws SQLException {
        Connection connection = connectionManager.retrive();
        int result;
        String query = "SELECT  MAX(id) FROM lab1_jdbc.managers";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        result = resultSet.getInt(1);
        connectionManager.putback(connection);
        return result;
    }
}
