package nti.com.fixstore11.presenter.presenterImpl;

import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.CreateOrderPresenter;
import nti.com.fixstore11.presenter.presenter.MainPresenter;

public class CreateOrderPresenterImp implements CreateOrderPresenter {


    @Override
    public boolean saveOrder(Order order,String job) {
        FireBase fireBase = new FireBase();
        fireBase.addOrder(order,job);
        return true;
    }
}
