package nti.com.fixstore11.presenter.presenterImpl;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.CreateOrderPresenter;
import nti.com.fixstore11.presenter.presenter.HandyManMainPresenter;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;

public class HandyManMainPresenterImp implements HandyManMainPresenter {


    @Override
    public void updateOrders(HandymanFragementView handymanFragementView) {
        FireBase fireBase = new FireBase();
         fireBase.updateOrders(handymanFragementView);

    }
}
