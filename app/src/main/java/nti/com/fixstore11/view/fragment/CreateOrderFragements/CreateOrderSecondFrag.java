package nti.com.fixstore11.view.fragment.CreateOrderFragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import nti.com.fixstore11.R;

public class CreateOrderSecondFrag extends Fragment {
    EditText etLocation;
    Button btnNext;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_create_order_second, container, false);

        etLocation =  rootView.findViewById(R.id.et_location_fragment_create_order_second);
        btnNext =  rootView.findViewById(R.id.btn_next_fragment_create_order_second);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CreateOrderThirdFrag thirdFrag=new CreateOrderThirdFrag();
                fragmentTransaction.replace(R.id.fragment_container_create_order, thirdFrag);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
