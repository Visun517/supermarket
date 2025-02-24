package lk.ijse.gdse.supermarket.Dao.custom;

import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.Dao.CrudDao;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDao extends CrudDao<Item> {

     ArrayList<String> getAllItemIds() throws SQLException;
     Item findById(String selectedItemId) throws SQLException;
     boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException;
}
