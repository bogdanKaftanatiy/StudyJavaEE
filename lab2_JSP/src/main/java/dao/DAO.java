package main.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<KeyT, DataT> {
    List<DataT> getAllObjects() throws SQLException;

    DataT getObject(KeyT id) throws SQLException;

    KeyT addObject(DataT object) throws SQLException;

    void updateObject(DataT object) throws SQLException;

    void deleteObject(KeyT id) throws SQLException;
}
