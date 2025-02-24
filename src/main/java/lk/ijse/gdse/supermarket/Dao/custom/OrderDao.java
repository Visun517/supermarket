package lk.ijse.gdse.supermarket.Dao.custom;

import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.Dao.CrudDao;
import lk.ijse.gdse.supermarket.entity.Order;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<Order> {
     boolean saveOrder(Order order) throws SQLException;
}
