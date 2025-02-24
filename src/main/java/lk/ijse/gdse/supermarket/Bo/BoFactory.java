package lk.ijse.gdse.supermarket.Bo;

import lk.ijse.gdse.supermarket.Bo.custom.impl.CustomerBoImpl;
import lk.ijse.gdse.supermarket.Bo.custom.impl.ItemBoImpl;
import lk.ijse.gdse.supermarket.Bo.custom.impl.PlaceOrderBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public  enum BOType{
        CUSTOMER,ITEM,ORDER
    }
    public SuperBo getBo(BOType type){

        switch (type){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case ORDER:
                return new PlaceOrderBoImpl();
            default:
                return null;
        }
    }
}
