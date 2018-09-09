package nti.com.fixstore11.view.Interfaces;


import java.util.ArrayList;

import nti.com.fixstore11.model.entities.Order;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface HandymanFragementView {
    void updateOrdersFromFireBase(ArrayList<Order> orders);
    void notifyWithNewOrder(Order order);

}
