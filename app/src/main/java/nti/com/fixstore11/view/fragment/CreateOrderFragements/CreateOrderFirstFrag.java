package nti.com.fixstore11.view.fragment.CreateOrderFragements;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.activity.CreateOrderActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;


public class CreateOrderFirstFrag extends Fragment {

    EditText etDesc;
    Button btnNext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_create_order_first, container, false);

        etDesc = (EditText) rootView.findViewById(R.id.et_desc_fragment_create_order_first);
        btnNext = rootView.findViewById(R.id.btn_next_fragment_create_order_first);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc = etDesc.getText().toString();
                ((CreateOrderActivity) getActivity()).order.setDescription(desc);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CreateOrderSecondFrag secondFrag = new CreateOrderSecondFrag();
                fragmentTransaction.replace(R.id.fragment_container_create_order, secondFrag);
                fragmentTransaction.commit();
            }
        });


        return rootView;
    }
}
