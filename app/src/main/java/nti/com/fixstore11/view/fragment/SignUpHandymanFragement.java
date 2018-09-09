package nti.com.fixstore11.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.presenter.presenterImpl.signUpHandymanPresenterImp;
import nti.com.fixstore11.utils.HandyManUtils;
import nti.com.fixstore11.view.activity.MainActivity;
import nti.com.fixstore11.view.activity.SplashActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;

public class SignUpHandymanFragement extends Fragment {
    signUpHandymanPresenterImp presenterImp;
    Button btnSubmit;
    Spinner spinnerJobName;
    EditText handyman_name, handyman_age, handyman_password;


    public SignUpHandymanFragement() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_handyman_signup, container, false);


        init(rootView);
        actions();


        return rootView;
    }

    private void init(View rootView) {
        handyman_name = rootView.findViewById(R.id.ed_hname);
        handyman_age = rootView.findViewById(R.id.ed_hage);
        handyman_password = rootView.findViewById(R.id.ed_hpassword);
        btnSubmit = rootView.findViewById(R.id.btn_handyman_submit);
        spinnerJobName = rootView.findViewById(R.id.spinner);

        //set adapter to spinner
        @SuppressLint("ResourceType")
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, HandyManUtils.jobs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJobName.setAdapter(adapter);

    }

    private void actions() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fill new objects with values from UI
                HandyMan newHandyMan = getHandyman();

                //add handyman in database
                presenterImp = new signUpHandymanPresenterImp();
                presenterImp.addHandyman(newHandyMan);


                //pass handyman to mainActivity and start it
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("User", newHandyMan);
                startActivity(intent);
                getActivity().finish();


            }
        });
    }

    private HandyMan getHandyman() {
        HandyMan handyMan = new HandyMan();
        handyMan.setName(handyman_name.getText().toString());
        handyMan.setAge(Integer.parseInt(handyman_age.getText().toString()));
        handyMan.setPassword(handyman_password.getText().toString());

        //get job index from spinner then get corresponding job name from class HandyManUtils
        handyMan.setJobName(HandyManUtils.jobs[spinnerJobName.getSelectedItemPosition()]);

        //get phone from previuous activity
        handyMan.setPhone(getActivity().getIntent().getStringExtra("phone"));

        return handyMan;

    }

}
