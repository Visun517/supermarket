package lk.ijse.gdse.supermarket.Dao;

import lk.ijse.gdse.supermarket.Dao.custom.impl.CustomerDaoImpl;
import lk.ijse.gdse.supermarket.Dao.custom.impl.ItemDaoImpl;
import lk.ijse.gdse.supermarket.Dao.custom.impl.OrderDaoImpl;
import lk.ijse.gdse.supermarket.Dao.custom.impl.OrderDetailsDaoImpl;

public class Daofactory {
    private static Daofactory daoFactory;

    private Daofactory(){

    }

    public static Daofactory getInstance(){
        if(daoFactory==null){
            daoFactory=new Daofactory();
        }
        return daoFactory;
    }
    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS
    }
    public SuperDao getDAO(DAOType type){

        switch (type){
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailsDaoImpl();
            default:
                return null;
        }
    }
}
