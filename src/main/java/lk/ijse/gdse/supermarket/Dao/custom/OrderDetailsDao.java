package lk.ijse.gdse.supermarket.Dao.custom;

import lk.ijse.gdse.supermarket.Dao.CrudDao;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailsDao extends CrudDao<OrderDetails> {
    boolean saveOrderDetailsList(ArrayList<OrderDetails> orderDetails) throws SQLException;
    boolean saveOrderDetail(OrderDetails orderDetails) throws SQLException;
}
