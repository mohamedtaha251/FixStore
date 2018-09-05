package nti.com.fixstore11.presenter.presenterImpl;

import java.util.ArrayList;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.LoginActivityPresenter;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

public class loginActivityPresenterImp implements LoginActivityPresenter {
    String Phone;
    String Password;
    LoginActivityView view;


    public loginActivityPresenterImp() {
    }

    @Override
    public void checkValidUser(LoginActivityView view, Client client) {
        this.view = view;
        FireBase fireBase = new FireBase();
        fireBase.checkLoginClient(view, client);
        fireBase.checkLoginHandyman(view, client);

    }

    @Override
    public void isUserFound(LoginActivityView view, String phone, String password) {
        this.view = view;
        Phone = phone;
        Password = password;

        FireBase fireBase = new FireBase();
        fireBase.callClients(this);
        fireBase.callHandMan(this);
    }

    @Override
    public void receiveClients(ArrayList<Client> clients) {

        //search user in clients
        for (int i = 0; i < clients.size(); i++) {
            if (Phone.equals(clients.get(i).getPhone()) && Password.equals(clients.get(i).getPassword())) {
                view.passUser(clients.get(i));
                return;
            }
        }

    }

    @Override
    public void receiveHandyMans(ArrayList<HandyMan> handyMans) {

        //search user in clients
        for (int i = 0; i < handyMans.size(); i++) {
            if (Phone.equals(handyMans.get(i).getPhone()) && Password.equals(handyMans.get(i).getPassword())) {
                view.passUser(handyMans.get(i));
                return;
            }
        }


    }

    @Override
    public void checkValidation() {


    }


}
