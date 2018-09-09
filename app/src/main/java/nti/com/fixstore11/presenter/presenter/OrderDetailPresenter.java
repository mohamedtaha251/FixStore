package nti.com.fixstore11.presenter.presenter;


import android.content.Context;

import nti.com.fixstore11.model.entities.Order;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface OrderDetailPresenter {
    void acceptOrder(Order order);
    void pushAcceptOrderNotification(Context context,Order order);
    void rejectOrder(Order order);
    void pushRejectOrderNotification(Context context,Order order);
}
