package nti.com.fixstore11.view.fragment.CreateOrderFragements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.presenter.presenterImpl.CreateOrderPresenterImp;
import nti.com.fixstore11.view.activity.CreateOrderActivity;
import nti.com.fixstore11.view.activity.LoginActivity;
import nti.com.fixstore11.view.activity.MainActivity;

public class CreateOrderThirdFrag extends Fragment {

    EditText etPrice;
    Button btnSendOrder;
    CreateOrderPresenterImp presenterImp;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_order_third, container, false);

        etPrice = rootView.findViewById(R.id.et_order_price_fragment_create_order_third);
        btnSendOrder = rootView.findViewById(R.id.btn_send_order);
        presenterImp = new CreateOrderPresenterImp();

        btnSendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String job=getActivity().getIntent().getStringExtra("HandyManJob");
                String price=etPrice.getText().toString();

                ((CreateOrderActivity)getActivity()).order.setClientPrice(price);

                presenterImp.saveOrder(((CreateOrderActivity)getActivity()).order,job);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("User", new Client());
                startActivity(intent);

                getActivity().finish();
            }

        });

        return rootView;
    }


}
