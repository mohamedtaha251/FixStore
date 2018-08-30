package nti.com.fixstore11.view.activity;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.HandymanFragement;

public class MainActivity extends AppCompatActivity {
    Boolean isClient = true;
    ClientFragement clientFragement;
    HandymanFragement handymanFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientFragement = new ClientFragement();
        handymanFragement = new HandymanFragement();

        //get type of user
        isClient = getIntent().getBooleanExtra("isClient", isClient);

        //call fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, isClient ? clientFragement : handymanFragement);
        fragmentTransaction.commit();
    }

}
