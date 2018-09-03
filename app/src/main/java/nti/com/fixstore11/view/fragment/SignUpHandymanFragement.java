package nti.com.fixstore11.view.fragment;

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
import nti.com.fixstore11.view.activity.MainActivity;
import nti.com.fixstore11.view.activity.SplashActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;

public class SignUpHandymanFragement extends Fragment implements AdapterView.OnItemSelectedListener {
    signUpHandymanPresenterImp presenterImp;
    Button btnSubmit;
    HandyMan handyMan;
    EditText handyman_name, handyman_age, handyman_email, handyman_password, handyman_position;
    String pos, hname, hage, phone, hpassword;

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference OrderReferene;
    private DatabaseReference HandymanReferene;
    private DatabaseReference ClientReferene;
    private FirebaseUser firebaseUser;
   DatabaseReference referenc;
//    FirebaseAuth auth;
//    FirebaseDatabase database;
//    DatabaseReference referenc;
//    FirebaseUser firebaseUser;

    public SignUpHandymanFragement() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_handyman_signup, container, false);

        phone = getActivity().getIntent().getStringExtra("phone");


        init(rootView);
        actions();


        return rootView;
    }

    private void init(View rootView) {
        handyman_name = rootView.findViewById(R.id.ed_hname);
        handyman_age = rootView.findViewById(R.id.ed_hage);
        handyman_password = rootView.findViewById(R.id.ed_hpassword);
        btnSubmit = rootView.findViewById(R.id.btn_handyman_submit);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(getActivity(), R.array.positions,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        Spinner staticSpinner = (Spinner) rootView.findViewById(R.id.spinner);
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner.setOnItemSelectedListener(this);
    }

    private void actions() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenterImp = new signUpHandymanPresenterImp();
                presenterImp.addHandyman(new HandyMan());


                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("isClient", false);
                startActivity(intent);
//
//                if (getArguments() != null) {
//                    phone = getArguments().getString("phone2");
//                    Toast.makeText(getActivity(),phone,Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }

    private HandyMan getHandyman() {
        HandyMan handyMan = new HandyMan();
        handyMan.setName(handyman_name.getText().toString());
        handyMan.setAge(Integer.parseInt(handyman_age.getText().toString()));
        handyMan.setPassword(hpassword);
        handyMan.setPhone(phone);


//        database = FirebaseDatabase.getInstance();
//
//        HandymanReferene = database.getReference("handyman");
//        referenc = database.getReference("handyman");
//        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//       // DatabaseReference userref = referenc.child("handyman");
//
//        referenc.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                HandyMan user = dataSnapshot.getValue(HandyMan.class);
////                Toast.makeText(getActivity(), user.getName() + user.getName(), Toast.LENGTH_SHORT).show();
////
//                for (int i=0;i<dataSnapshot.getChildrenCount();i++)
//                {
//                    HandyMan user=dataSnapshot.getValue(HandyMan.class);
//                    String s=dataSnapshot.child("handyman").child("name").getValue(String.class);
//                    Toast.makeText(getActivity(), user.getName(), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });











//
//        referenc.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                HandyMan user = dataSnapshot.getValue(HandyMan.class);
//                Toast.makeText(getActivity(), user.getName() + user.getName(), Toast.LENGTH_SHORT).show();
//
//                for (int i=0;i<dataSnapshot.getChildrenCount();i++)
//                {
//                    HandyMan handyMan=dataSnapshot.getValue(HandyMan.class);
//                    String s=dataSnapshot.child("handyman").child("name").getValue(String.class);
//                    Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        return handyMan;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {


        pos = (String) parent.getItemAtPosition(i);
        //  Toast.makeText(getActivity(), pos, Toast.LENGTH_LONG).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
