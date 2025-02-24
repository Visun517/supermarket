package lk.ijse.gdse.supermarket.Dao.custom.impl;

import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.Dao.custom.OrderDao;
import lk.ijse.gdse.supermarket.entity.Order;
import lk.ijse.gdse.supermarket.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

    public String getNextId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select orderId from orders order by orderId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // e.g., "O002"
            String substring = lastId.substring(1); // e.g., "002"
            int i = Integer.parseInt(substring); // 2
            int newIdIndex = i + 1; // 3
            return String.format("O%03d", newIdIndex);
        }
        return "O001";
    }



    public boolean saveOrder(Order order) throws SQLException {
        return CrudUtil.execute(
                    "insert into orders values (?,?,?)",
                order.getOrderId(),
                order.getCustomerId(),
                order.getOrderDate()
            );
    }

    @Override
    public boolean update(Order dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException {
        return false;
    }
}
