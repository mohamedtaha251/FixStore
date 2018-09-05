package nti.com.fixstore11.view.fragment.CreateOrderFragements;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.activity.CreateOrderActivity;
import nti.com.fixstore11.view.activity.MapsActivity;

public class CreateOrderSecondFrag extends Fragment {
    Button btnLocation;
    Button btnNext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_create_order_second, container, false);

        btnLocation = rootView.findViewById(R.id.btn_get_location);
        btnNext = rootView.findViewById(R.id.btn_next_fragment_create_order_second);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CreateOrderThirdFrag thirdFrag = new CreateOrderThirdFrag();
                fragmentTransaction.replace(R.id.fragment_container_create_order, thirdFrag);
                fragmentTransaction.commit();
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivityForResult(i, 1);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == CreateOrderActivity.RESULT_OK) {
                String lat = data.getStringExtra("Latitude");
                String lng = data.getStringExtra("Longitude");

                ((CreateOrderActivity)getActivity()).order.setLatitude(lat);
                ((CreateOrderActivity)getActivity()).order.setLatitude(lng);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }


        }
    }

}
