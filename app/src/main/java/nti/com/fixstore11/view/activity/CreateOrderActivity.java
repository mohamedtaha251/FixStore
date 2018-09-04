package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.CreateOrderFragements.CreateOrderFirstFrag;
import nti.com.fixstore11.view.fragment.CreateOrderFragements.CreateOrderSecondFrag;
import nti.com.fixstore11.view.fragment.CreateOrderFragements.CreateOrderThirdFrag;
import nti.com.fixstore11.view.fragment.HandymanFragement;


public class CreateOrderActivity extends AppCompatActivity {

    Fragment FirstFrag;
    Fragment SecondFrag;
    Fragment ThirdFrag;

    Button btnFirstFrag;
    Button btnSecondFrag;
    Button btnThirdFrag;

    public Order order;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        init();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_create_order, FirstFrag);
        fragmentTransaction.commit();

    }

    private void init() {
        FirstFrag = new CreateOrderFirstFrag();
        SecondFrag = new CreateOrderSecondFrag();
        ThirdFrag = new CreateOrderThirdFrag();



    }

}
