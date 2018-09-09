package nti.com.fixstore11.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.presenter.presenterImpl.signUpClientPresenterImp;
import nti.com.fixstore11.presenter.presenterImpl.signUpHandymanPresenterImp;
import nti.com.fixstore11.view.activity.MainActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;

public class SignUpClientFragement extends Fragment {

    Button btnSubmit;
    Client client;
    String phone;
    EditText nameET, passwordEt;
    signUpClientPresenterImp presenterImp;


    public SignUpClientFragement() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_client_signup, container, false);
        phone = getActivity().getIntent().getStringExtra("phone");

        init(rootView);
        actions();

        return rootView;
    }

    private void init(View rootView) {
        btnSubmit = rootView.findViewById(R.id.btn_client_submit);
        nameET = rootView.findViewById(R.id.ed_hname);
        passwordEt = rootView.findViewById(R.id.ed_hpassword);
        //
//        if (getArguments() != null) {
//            phone = getArguments().getString("phone");
//            Toast.makeText(getActivity(),phone+"client phone",Toast.LENGTH_SHORT).show();
//        }


    }

    private void actions() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fill new objects with values from UI
                Client newClient = getClient();

                //add newClient in database
                presenterImp = new signUpClientPresenterImp();
                presenterImp.addClient(newClient);

                //pass newClient to main activity and start it
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("User", newClient);
                startActivity(intent);
                getActivity().finish();

            }
        });
    }

    private Client getClient() {
        client = new Client();
        client.setName(nameET.getText().toString());
        client.setPassword(passwordEt.getText().toString());
        client.setPhone(phone);

        return client;
    }

}
