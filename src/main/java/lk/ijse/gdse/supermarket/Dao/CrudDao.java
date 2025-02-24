package lk.ijse.gdse.supermarket.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T> extends SuperDao {
    String getNextId() throws SQLException;
    ArrayList<T> getAll() throws SQLException;
    boolean save(T dto) throws SQLException;
    boolean update(T dto) throws SQLException;
    boolean delete(String id) throws SQLException;
}
