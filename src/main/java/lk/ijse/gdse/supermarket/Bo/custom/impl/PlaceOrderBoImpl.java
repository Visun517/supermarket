package lk.ijse.gdse.supermarket.Bo.custom.impl;

import lk.ijse.gdse.supermarket.Bo.custom.PlaceOrderBo;
import lk.ijse.gdse.supermarket.Dao.custom.ItemDao;
import lk.ijse.gdse.supermarket.db.DBConnection;
import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.Dao.Daofactory;
import lk.ijse.gdse.supermarket.Dao.custom.OrderDao;
import lk.ijse.gdse.supermarket.Dao.custom.OrderDetailsDao;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Order;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    OrderDao orderDao = (OrderDao) Daofactory.getInstance().getDAO(Daofactory.DAOType.ORDER);
    OrderDetailsDao orderDetailsDao = (OrderDetailsDao) Daofactory.getInstance().getDAO(Daofactory.DAOType.ORDERDETAILS);
    ItemDao itemDao = (ItemDao) Daofactory.getInstance().getDAO(Daofactory.DAOType.ITEM);


    // ORDERS
    @Override
    public String getNextId() throws SQLException {
        return orderDao.getNextId();
    }

    @Override
    public boolean saveOrder(OrderDTO orderDto) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false); // 1

            boolean isOrderSaved = orderDao.saveOrder(new Order(
                    orderDto.getOrderId(),
                    orderDto.getCustomerId(),
                    orderDto.getOrderDate()
            ));
            System.out.println(" 2 step = isOrderSaved "+ isOrderSaved);

            if (isOrderSaved) {
                boolean isOrderDetailListSaved = saveOrderDetailsList(orderDto.getOrderDetailsDTOS());
                if (isOrderDetailListSaved) {
                    connection.commit(); // 2
                    return true;
                }
            }
            connection.rollback(); // 3
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true); // 4
        }
    }

    @Override
    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsDTOS) throws SQLException {

        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
            boolean isOrderDetailsSaved = orderDetailsDao.saveOrderDetail(new OrderDetails(
                    orderDetailsDTO.getOrderId(),
                    orderDetailsDTO.getItemId(),
                    orderDetailsDTO.getQuantity(),
                    orderDetailsDTO.getPrice()
            ));
            System.out.println(" 3 step isOrderDetailsSaved " + isOrderDetailsSaved);
            if (!isOrderDetailsSaved) {
                return false;
            }

            boolean isItemUpdated = itemDao.reduceQty(orderDetailsDTO);
            System.out.println("4 step isItemUpdated  "+ isItemUpdated);
            if (!isItemUpdated) {
                return false;
            }
        }
        return true;
    }
}
