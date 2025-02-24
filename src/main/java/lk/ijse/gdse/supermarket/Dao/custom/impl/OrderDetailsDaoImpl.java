package lk.ijse.gdse.supermarket.Dao.custom.impl;

import lk.ijse.gdse.supermarket.Dao.custom.OrderDetailsDao;
import lk.ijse.gdse.supermarket.entity.OrderDetails;
import lk.ijse.gdse.supermarket.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    public boolean saveOrderDetail(OrderDetails orderDetails) throws SQLException {
        return CrudUtil.execute(
                "insert into orderdetails values (?,?,?,?)",
                orderDetails.getOrderId(),
                orderDetails.getItemId(),
                orderDetails.getQuantity(),
                orderDetails.getPrice()
        );
    }


    @Override
    public boolean saveOrderDetailsList(ArrayList<OrderDetails> orderDetailsDTOS) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
