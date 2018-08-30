package nti.com.fixstore11.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.activity.MainActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;

public class SignUpClientFragement extends Fragment {

    Button btnSubmit;

    public SignUpClientFragement() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_client_signup, container, false);
        btnSubmit = rootView.findViewById(R.id.btn_client_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("isClient", true);
                startActivity(intent);
            }
        });


        return rootView;
    }

}
