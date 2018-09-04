package nti.com.fixstore11.presenter.presenter;


import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface HandyManMainPresenter {

    void updateOrders(HandymanFragementView handymanFragementView, HandyMan handyMan);
}
