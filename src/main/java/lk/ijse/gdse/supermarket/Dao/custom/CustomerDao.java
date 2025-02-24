package lk.ijse.gdse.supermarket.Dao.custom;

import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.Dao.CrudDao;
import lk.ijse.gdse.supermarket.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao extends CrudDao<Customer> {
     ArrayList<String> getAllCustomerIds() throws SQLException;
     Customer findById(String selectedCusId) throws SQLException;
}
