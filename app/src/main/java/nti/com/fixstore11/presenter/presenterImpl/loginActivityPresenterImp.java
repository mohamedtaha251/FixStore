package nti.com.fixstore11.presenter.presenterImpl;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.LoginActivityPresenter;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

public class loginActivityPresenterImp implements LoginActivityPresenter {


    @Override
    public void checkValidUser(LoginActivityView view, Client client) {
        FireBase fireBase=new FireBase();
        fireBase.checkLoginClient(view,client);
        fireBase.checkLoginHandyman(view,client);

    }
}
