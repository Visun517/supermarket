package lk.ijse.gdse.supermarket.Dao.custom.impl;

import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.Dao.custom.CustomerDao;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    public String getNextId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select id from customer order by id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // Last customer ID
            String substring = lastId.substring(1); // Extract the numeric part
            int i = Integer.parseInt(substring); // Convert the numeric part to integer
            int newIdIndex = i + 1; // Increment the number by 1
            return String.format("C%03d", newIdIndex); // Return the new customer ID in format Cnnn
        }
        return "C001"; // Return the default customer ID if no data is found
    }


    public boolean save(Customer customer) throws SQLException {
        return CrudUtil.execute(
                "insert into customer values (?,?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getNic(),
                customer.getEmail(),
                customer.getPhone()
        );
    }


    public ArrayList<Customer> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from customer");

        ArrayList<Customer> customers = new ArrayList<>();

        while (rst.next()) {
            Customer customer = new Customer(
                    rst.getString(1),  // Customer ID
                    rst.getString(2),  // Name
                    rst.getString(3),  // NIC
                    rst.getString(4),  // Email
                    rst.getString(5)   // Phone
            );
            customers.add(customer);
        }
        return customers;
    }

    public boolean update(Customer customer) throws SQLException {
        return CrudUtil.execute(
                "update customer set name=?, nic=?, email=?, phone=? where id=?",
                customer.getName(),
                customer.getNic(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getId()
        );
    }

    public boolean delete(String customerId) throws SQLException {
        return CrudUtil.execute("delete from customer where id=?", customerId);
    }

    public ArrayList<String> getAllCustomerIds() throws SQLException {
        ResultSet rst = CrudUtil.execute("select id from customer");

        ArrayList<String> customerIds = new ArrayList<>();

        while (rst.next()) {
            customerIds.add(rst.getString(1));
        }

        return customerIds;
    }

    public Customer findById(String selectedCusId) throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from customer where id=?", selectedCusId);

        if (rst.next()) {
            return new Customer(
                    rst.getString(1),  // Customer ID
                    rst.getString(2),  // Name
                    rst.getString(3),  // NIC
                    rst.getString(4),  // Email
                    rst.getString(5)   // Phone
            );
        }
        return null;
    }
}
