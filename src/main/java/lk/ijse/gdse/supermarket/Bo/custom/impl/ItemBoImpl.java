package lk.ijse.gdse.supermarket.Bo.custom.impl;

import lk.ijse.gdse.supermarket.Bo.custom.ItemBo;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.Dao.Daofactory;
import lk.ijse.gdse.supermarket.Dao.custom.ItemDao;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) Daofactory.getInstance().getDAO(Daofactory.DAOType.ITEM);

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException {
        return itemDao.getAllItemIds();
    }

    @Override
    public ItemDTO findById(String selectedItemId) throws SQLException {
        Item item =  itemDao.findById(selectedItemId);
        return new ItemDTO(
                item.getItemId(),
                item.getItemName(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        return itemDao.reduceQty(orderDetailsDTO);
    }

    @Override
    public String getNextId() throws SQLException {
        return itemDao.getNextId();
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException {
        ArrayList<Item> items =  itemDao.getAll();

        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();

        for (Item item : items){
            itemDTOS.add(new ItemDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getQuantity(),
                    item.getPrice()
            ));
        }
        return itemDTOS;
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException {
        return itemDao.save(new Item(
                dto.getItemId(),
                dto.getItemName(),
                dto.getQuantity(),
                dto.getPrice()
        ));
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException {
        return itemDao.update(new Item(
                dto.getItemId(),
                dto.getItemName(),
                dto.getQuantity(),
                dto.getPrice()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return itemDao.delete(id);
    }
}
