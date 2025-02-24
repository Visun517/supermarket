package lk.ijse.gdse.supermarket.Bo.custom;

import lk.ijse.gdse.supermarket.Bo.SuperBo;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;


import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {
     ArrayList<String> getAllItemIds() throws SQLException;
     ItemDTO findById(String selectedItemId) throws SQLException;
     boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException;
     String getNextId() throws SQLException;
     ArrayList<ItemDTO> getAll() throws SQLException;
     boolean save(ItemDTO dto) throws SQLException;
     boolean update(ItemDTO dto) throws SQLException;
     boolean delete(String id) throws SQLException;
}
