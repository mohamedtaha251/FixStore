package nti.com.fixstore11.model.remote;

import
        android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.activity.SignUpActivity;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.SignUpClientFragement;


public final class FireBase {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference OrderReferene;
    private DatabaseReference HandymanReferene;
    private DatabaseReference ClientReferene;
    private FirebaseUser firebaseUser;
    String s;
    DataSnapshot dataSnapshot;

    public FireBase() {
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        OrderReferene = database.getReference("order");
        HandymanReferene = database.getReference("handyman");
        ClientReferene = database.getReference("client");
    }

    public String generateKey(DatabaseReference reference) {
        return reference.push().getKey();
    }

    public boolean isLogged(String mobile, String password) {

        return true;
    }

    public boolean isValidUser(String mobile, String password) {
        return true;
    }




        public boolean addOrder (Order order){
            String key = OrderReferene.push().getKey();
            DatabaseReference orderRecord = OrderReferene.child(key);
            orderRecord.child("Description").setValue(order.getDescription());
            orderRecord.child("ClientName").setValue(order.getClientName());
            orderRecord.child("ClientRate").setValue(order.getClientRate());
            orderRecord.child("Fromdays").setValue(order.getFromdays());

            return true;
        }

        public boolean addClient (Client client){

            String key = ClientReferene.push().getKey();
            DatabaseReference userRecord = ClientReferene.child(key);
            userRecord.child("name").setValue(client.getName());
            userRecord.child("password").setValue(client.getPassword());
            userRecord.child("phone").setValue(client.getPhone());


            return true;
        }

        public boolean addHandyMan (HandyMan handyMan){
            String key = HandymanReferene.push().getKey();
            DatabaseReference userRecord = HandymanReferene.child(key);
            userRecord.child("name").setValue(handyMan.getName());
            userRecord.child("age").setValue(handyMan.getAge());
            userRecord.child("password").setValue(handyMan.getPassword());
            userRecord.child("phone").setValue(handyMan.getPhone());


            return true;
        }

        public boolean notifyWithNewOrder (Context context){
            return true;
        }

        public boolean notifyWithOrderAction (Context context){
            return true;
        }

//    public String retrieveclient() {
//
//        ClientReferene.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Client client = dataSnapshot.getValue(Client.class);
//                // Toast.makeText(MainActivity.this, user.getName() + user.getAddress(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
//                    Client client = dataSnapshot.getValue(Client.class);
//                    s = dataSnapshot.child("user1").child("name").getValue(String.class);
//
//                }
//            }
//        });
//        return s;
//    }
    }
