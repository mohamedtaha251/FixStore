package nti.com.fixstore11.presenter.presenter;


import nti.com.fixstore11.model.entities.Order;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface CreateOrderPresenter {
    boolean saveOrder(Order order);
}
