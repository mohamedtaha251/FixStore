package nti.com.fixstore11.presenter.presenterImpl;

import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenter.MainPresenter;
import nti.com.fixstore11.presenter.presenter.SignUpHandymanPresenter;

public class signUpHandymanPresenterImp implements SignUpHandymanPresenter {

    @Override
    public void addHandyman(HandyMan handyMan) {
        FireBase fireBase=new FireBase();
        fireBase.addHandyMan(handyMan);
    }
}
