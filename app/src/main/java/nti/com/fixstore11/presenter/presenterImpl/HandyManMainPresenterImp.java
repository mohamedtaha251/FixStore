package nti.com.fixstore11.presenter.presenterImpl;

import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.HandyManMainPresenter;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;

public class HandyManMainPresenterImp implements HandyManMainPresenter {


    @Override
    public void updateOrders(HandymanFragementView handymanFragementView,HandyMan handyMan) {
        FireBase fireBase = new FireBase();
         fireBase.refreshOrders(handymanFragementView,handyMan);

    }
}
