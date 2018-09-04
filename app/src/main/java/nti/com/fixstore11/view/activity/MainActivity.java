package nti.com.fixstore11.view.activity;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.HandymanFragement;

public class MainActivity extends AppCompatActivity {
    Fragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get object from previuos activity
             User user = (User) getIntent().getSerializableExtra("User");

        //use polymorphism to get the type of user
        if (user instanceof Client) {
            mainFragment = new ClientFragement();
        } else if (user instanceof HandyMan) {
            mainFragment = new HandymanFragement();
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


        //call fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, mainFragment);
        fragmentTransaction.commit();
    }

}
