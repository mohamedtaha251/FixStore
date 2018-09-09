package nti.com.fixstore11.presenter.presenterImpl;

import android.content.Context;

import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.OrderDetailPresenter;
import nti.com.fixstore11.utils.NotificationUtils;
import nti.com.fixstore11.view.Interfaces.OrderDetailActivityView;

public class OrderDetailPresenterImp implements OrderDetailPresenter {
    OrderDetailActivityView view;

    @Override
    public void acceptOrder(Order order) {
        FireBase fireBase = new FireBase();
        fireBase.acceptOrder(order);
    }

    @Override
    public void pushAcceptOrderNotification(Context context, Order order) {
        NotificationUtils.pushAcceptOrderNotification(context,order);
    }

    @Override
    public void rejectOrder(Order order) {
        FireBase fireBase = new FireBase();
        fireBase.rejectOrder(order);
    }

    @Override
    public void pushRejectOrderNotification(Context context, Order order) {
        NotificationUtils.pushRejectOrderNotification(context,order);

    }


}
