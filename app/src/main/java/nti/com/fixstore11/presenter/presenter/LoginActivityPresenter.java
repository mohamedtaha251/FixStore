package nti.com.fixstore11.presenter.presenter;


import java.lang.reflect.Array;
import java.util.ArrayList;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public interface LoginActivityPresenter {
    void checkValidUser(LoginActivityView view, Client client);
     void isUserFound(LoginActivityView view,String phone, String password);

     //fire base call this function
     void receiveClients(ArrayList<Client> clients);
     void receiveHandyMans(ArrayList<HandyMan> handyMans);
     void checkValidation();
}
