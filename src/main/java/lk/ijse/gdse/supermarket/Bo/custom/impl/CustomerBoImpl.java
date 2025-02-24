package lk.ijse.gdse.supermarket.Bo.custom.impl;

import lk.ijse.gdse.supermarket.Bo.custom.CustomerBo;
import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.Dao.Daofactory;
import lk.ijse.gdse.supermarket.Dao.custom.CustomerDao;
import lk.ijse.gdse.supermarket.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) Daofactory.getInstance().getDAO(Daofactory.DAOType.CUSTOMER);

    @Override
    public String getNextId() throws SQLException {
        return customerDao.getNextId();
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException {
        return customerDao.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getPhone()
        ));
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException {
        ArrayList<Customer> customers =  customerDao.getAll();

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers){
            customerDTOS.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getNic(),
                    customer.getEmail(),
                    customer.getPhone()
            ));
        }

        return customerDTOS;
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException {
        return customerDao.update(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getPhone()
        ));
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return customerDao.delete(customerId);
    }

    @Override
    public ArrayList<String> getAllCustomerIds() throws SQLException {
        return customerDao.getAllCustomerIds();
    }

    @Override
    public CustomerDTO findById(String selectedCusId) throws SQLException {
        Customer customers =  customerDao.findById(selectedCusId);

        return new CustomerDTO(
                customers.getId(),
                customers.getName(),
                customers.getNic(),
                customers.getEmail(),
                customers.getPhone()
        );
    }
}
