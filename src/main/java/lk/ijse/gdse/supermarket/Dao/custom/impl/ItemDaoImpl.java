package lk.ijse.gdse.supermarket.Dao.custom.impl;

import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.Dao.custom.ItemDao;
import lk.ijse.gdse.supermarket.entity.Item;
import lk.ijse.gdse.supermarket.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {

    public ArrayList<String> getAllItemIds() throws SQLException {
        ResultSet rst = CrudUtil.execute("select itemId from item");
        ArrayList<String> itemIds = new ArrayList<>();

        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }

        return itemIds;
    }

    public Item findById(String selectedItemId) throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from item where itemId=?", selectedItemId);

        if (rst.next()) {
           return new Item(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getInt(3),
                   rst.getDouble(4)
           );
        }

        return null;
    }

    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        return CrudUtil.execute(
                "update item set quantity = quantity - ? where itemId = ?",
                orderDetailsDTO.getQuantity(),   // Quantity to reduce
                orderDetailsDTO.getItemId()      // Item ID
        );
    }

    @Override
    public String getNextId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select itemId from item order by itemId desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1); // Last customer ID
            String substring = lastId.substring(1); // Extract the numeric part
            int i = Integer.parseInt(substring); // Convert the numeric part to integer
            int newIdIndex = i + 1; // Increment the number by 1
            return String.format("I%03d", newIdIndex); // Return the new customer ID in format Cnnn
        }
        return "C001"; // Return the default customer ID if no data is found;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from item");

        ArrayList<Item> item = new ArrayList<>();

        while (rst.next()) {
            Item item1 = new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
            item.add(item1);
        }
        return item;
    }

    @Override
    public boolean save(Item dto) throws SQLException {
        return CrudUtil.execute(
                "insert into item values (?,?,?,?)",
                dto.getItemId(),
                dto.getItemName(),
                dto.getQuantity(),
                dto.getPrice()
        );
    }

    @Override
    public boolean update(Item dto) throws SQLException {
        return CrudUtil.execute(
                "update item set itemName=?, quantity=?, price=? where itemId=?",
                dto.getItemName(),
                dto.getQuantity(),
                dto.getPrice(),
                dto.getItemId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("delete from item where itemId=?", id);
    }
}
