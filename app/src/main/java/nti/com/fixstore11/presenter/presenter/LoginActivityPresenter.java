package nti.com.fixstore11.presenter.presenter;


import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface LoginActivityPresenter {
    void checkValidUser(LoginActivityView view, Client client);
}
