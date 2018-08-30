package nti.com.fixstore11.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.HandymanFragement;
import nti.com.fixstore11.view.fragment.SignUpClientFragement;
import nti.com.fixstore11.view.fragment.SignUpHandymanFragement;

public class SignUpActivity extends AppCompatActivity {

    Boolean isClient;
    SignUpClientFragement signUpClientFragement;
    SignUpHandymanFragement signUpHandymanFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        isClient = getIntent().getBooleanExtra("SignUpSelection", true);

        signUpClientFragement = new SignUpClientFragement();
        signUpHandymanFragement = new SignUpHandymanFragement();

        //call fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, isClient  ? signUpClientFragement : signUpHandymanFragement);
        fragmentTransaction.commit();

    }
}
