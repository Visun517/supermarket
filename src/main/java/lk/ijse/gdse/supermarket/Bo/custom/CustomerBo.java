package lk.ijse.gdse.supermarket.Bo.custom;

import lk.ijse.gdse.supermarket.Bo.SuperBo;
import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SuperBo {

     String getNextId() throws SQLException;
     boolean save(CustomerDTO customerDTO) throws SQLException;
     ArrayList<CustomerDTO> getAll() throws SQLException;
     boolean update(CustomerDTO customerDTO) throws SQLException;
     boolean delete(String customerId) throws SQLException;
     ArrayList<String> getAllCustomerIds() throws SQLException;
     CustomerDTO findById(String selectedCusId) throws SQLException;
}
