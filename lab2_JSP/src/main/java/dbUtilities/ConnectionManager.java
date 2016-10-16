package main.java.dbUtilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionManager {
    private String URL;
    private String username;
    private String password;

    private List<Connection> availableConns;
    private List<Connection> usedConns;
    private int initCounts;

    private static ConnectionManager instance = null;

    private ConnectionManager(int initCounts, InputStream is) throws IOException, SQLException, ClassNotFoundException {
        this.initCounts = initCounts;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Creating driver failed");
            throw e;
        }

        Properties property = new Properties();
        property.load(is);
        URL = property.getProperty("db.url");
        username = property.getProperty("db.login");
        password = property.getProperty("db.password");
        is.close();

        availableConns = new ArrayList<>();
        usedConns = new ArrayList<>();

        init();
    }

    private void init() throws SQLException {
        for (int i = 0; i < initCounts; i++) {
            availableConns.add(getConnection());
        }
    }

    private Connection getConnection() throws SQLException {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.out.println("ERROR: Creating connection failed");
            throw e;
        }

        return connection;
    }

    public synchronized Connection retrive() throws SQLException {
        Connection newConn = null;

        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = availableConns.get(0);
            availableConns.remove(newConn);
        }

        usedConns.add(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) {
        if (c != null) {
            if (usedConns.remove(c)) {
                availableConns.add(c);
            } else {
                throw new IllegalArgumentException("ERROR: Connection isn't in pool");
            }
        } else {
            throw new NullPointerException("ERROR: Connection is null");
        }
    }

    public void close() throws SQLException {
        if(!usedConns.isEmpty()) {
            throw new RuntimeException("Some connection in using now");
        } else {
            for (Connection c: availableConns) {
                c.close();
            }
        }
    }

    public static ConnectionManager getInstance(InputStream is) throws SQLException, IOException, ClassNotFoundException {
        return getInstance(8, is);
    }

    public static ConnectionManager getInstance(int initCounts, InputStream is) throws SQLException, IOException, ClassNotFoundException {
        if(instance == null) {
            instance = new ConnectionManager(initCounts, is);
        }
        return instance;
    }
}
