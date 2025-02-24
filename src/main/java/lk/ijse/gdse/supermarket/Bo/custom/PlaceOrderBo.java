package lk.ijse.gdse.supermarket.Bo.custom;

import lk.ijse.gdse.supermarket.Bo.SuperBo;
import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBo extends SuperBo {
     String getNextId() throws SQLException;
     boolean saveOrder(OrderDTO order) throws SQLException;
     boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsDTOS) throws SQLException;
}
