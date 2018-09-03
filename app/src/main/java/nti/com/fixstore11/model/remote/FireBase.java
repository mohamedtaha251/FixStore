package nti.com.fixstore11.model.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;

public final class FireBase {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference OrderReferene;
    private DatabaseReference HandymanReferene;
    private DatabaseReference ClientReferene;
    private FirebaseUser firebaseUser;
    private ArrayList<Order> orders;
    private ArrayList<String> ordersString;

    private ArrayList<String> OrderKeys;
    private HandymanFragementView handymanFragementView;


    public FireBase() {
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        OrderReferene = database.getReference("order");
        HandymanReferene = database.getReference("handyman");
        ClientReferene = database.getReference("client");
        orders = new ArrayList<Order>();
        OrderKeys = new ArrayList<String>();
        ordersString = new ArrayList<String>();


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


    public boolean addOrder(Order order) {
        String key = OrderReferene.push().getKey();
        DatabaseReference orderRecord = OrderReferene.child(key);
        orderRecord.child("id").setValue(key);
        orderRecord.child("Description").setValue(order.getDescription());
        orderRecord.child("ClientName").setValue(order.getClientName());
        orderRecord.child("ClientRate").setValue(order.getClientRate());
        orderRecord.child("Fromdays").setValue(order.getFromdays());

        return true;
    }

    public boolean addClient(Client order) {
        return true;
    }

    public void updateOrders(HandymanFragementView View) {

        this.handymanFragementView = View;

        OrderReferene.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Order> orders=new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Order order = new Order();

                    String cn = dataSnapshot.child(ds.getKey()).child("ClientName").getValue(String.class);
                    order.setClientName(cn);
                    orders.add(order);

                }

                handymanFragementView.updateOrders(orders);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }






    public boolean addHandyMan(HandyMan handyMan) {
        String key = HandymanReferene.push().getKey();
        DatabaseReference userRecord = HandymanReferene.child(key);
        userRecord.child("name").setValue(handyMan.getName());
        userRecord.child("age").setValue(handyMan.getAge());
        userRecord.child("password").setValue(handyMan.getPassword());
        userRecord.child("phone").setValue(handyMan.getPhone());


        return true;
    }

    public boolean notifyWithNewOrder(Context context) {
        return true;
    }

    public boolean notifyWithOrderAction(Context context) {
        return true;
    }


}
