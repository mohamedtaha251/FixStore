package nti.com.fixstore11.presenter.presenterImpl;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.SignUpClientPresenter;
import nti.com.fixstore11.presenter.presenter.SignUpHandymanPresenter;

public class signUpClientPresenterImp implements SignUpClientPresenter {

    @Override
    public void addClient(Client client) {
        FireBase fireBase=new FireBase();
        fireBase.addClient(client);
    }


}
