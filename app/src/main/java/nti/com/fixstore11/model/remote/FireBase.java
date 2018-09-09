package nti.com.fixstore11.model.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.presenter.presenter.LoginActivityPresenter;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

public final class FireBase {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference OrderReferene;
    private DatabaseReference HandymanReferene;
    private DatabaseReference ClientReferene;
    private FirebaseUser firebaseUser;
    private ArrayList<Order> orders;
    private ArrayList<String> ordersString;
    private HandymanFragementView handymanFragementView;
    private ArrayList<String> OrderKeys;


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


    public boolean addOrder(Order order, String job) {


        String key = OrderReferene.push().getKey();
        DatabaseReference orderRecord = OrderReferene.child(job).child(key);
        orderRecord.child("id").setValue(key);
        orderRecord.child("Description").setValue(order.getDescription());
        orderRecord.child("ClientPrice").setValue(order.getClientPrice());
        orderRecord.child("Fromdays").setValue(order.getFromdays());
        orderRecord.child("Latitude").setValue(order.getLatitude());
        orderRecord.child("Longitude").setValue(order.getLongitude());
        orderRecord.child("State").setValue(order.getState());
        orderRecord.child("Client").child("name").setValue(order.getClient().getName());
        orderRecord.child("Client").child("phone").setValue(order.getClient().getPhone());

        return true;
    }

    public boolean addClient(Client client) {

        String key = ClientReferene.push().getKey();
        DatabaseReference userRecord = ClientReferene.child(key);
        userRecord.child("name").setValue(client.getName());
        userRecord.child("password").setValue(client.getPassword());
        userRecord.child("phone").setValue(client.getPhone());

        return true;

    }

    public void refreshOrders(HandymanFragementView View, final HandyMan handyMan) {

        this.handymanFragementView = View;

        OrderReferene.child(handyMan.getJobName()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Order> orders = new ArrayList<>();


                for (DataSnapshot ds : dataSnapshot.getChildren()) {


                    //get data from fire base
                    String ClientPrice = dataSnapshot.child(ds.getKey()).child("ClientPrice").getValue(String.class);
                    String Description = dataSnapshot.child(ds.getKey()).child("Description").getValue(String.class);
                    String Fromdays = dataSnapshot.child(ds.getKey()).child("Fromdays").getValue(String.class);
                    String Latitude = dataSnapshot.child(ds.getKey()).child("Latitude").getValue(String.class);
                    String Longitude = dataSnapshot.child(ds.getKey()).child("Longitude").getValue(String.class);
                    String State = dataSnapshot.child(ds.getKey()).child("State").getValue(String.class);
                    String ClientName = dataSnapshot.child(ds.getKey()).child("Client").child("name").getValue(String.class);
                    String ClientPhone = dataSnapshot.child(ds.getKey()).child("Client").child("phone").getValue(String.class);


                    //save data order in object
                    Order order = new Order();
                    order.setId(ds.getKey());
                    order.setOrderType(handyMan.getJobName());
                    order.setClientPrice(ClientPrice);
                    order.setDescription(Description);
                    order.setFromdays(Fromdays);
                    order.setLatitude(Latitude);
                    order.setLongitude(Longitude);
                    order.setState(State);

                    //save data in client object
                    Client client = new Client();
                    client.setName(ClientName);
                    client.setPhone(ClientPhone);
                    order.setClient(client);

                    orders.add(order);

                }

                handymanFragementView.updateOrdersFromFireBase(orders);

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
        userRecord.child("phone").setValue(handyMan.getPhone());
        userRecord.child("jobName").setValue(handyMan.getJobName());


        return true;
    }

    public boolean notifyWithNewOrder(final HandymanFragementView View, final HandyMan handyMan) {
        OrderReferene.child(handyMan.getJobName()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Order order = new Order();
                String cn = dataSnapshot.child("ClientName").getValue(String.class);
                order.getClient().setName(cn);
                View.notifyWithNewOrder(order);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Order order = new Order();
                String cn = dataSnapshot.child("ClientName").getValue(String.class);
                order.getClient().setName(cn);
                View.notifyWithNewOrder(order);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return true;
    }

    public void checkLoginClient(final LoginActivityView view, final Client client) {

        ClientReferene.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Client> clients = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String phone = dataSnapshot.child(ds.getKey()).child("phone").getValue(String.class);
                    String password = dataSnapshot.child(ds.getKey()).child("password").getValue(String.class);

                    String phoneuser = client.getPhone();
                    String passworduser = client.getPassword();

                    if (phoneuser.equals(phone) && passworduser.equals(password)) {
                        view.isValidUser(true);
                        break;
                    }
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    public void checkLoginHandyman(final LoginActivityView view, final Client client) {

        HandymanReferene.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Client> clients = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String phone = dataSnapshot.child(ds.getKey()).child("phone").getValue(String.class);
                    String password = dataSnapshot.child(ds.getKey()).child("password").getValue(String.class);

                    String phoneuser = client.getPhone();
                    String passworduser = client.getPassword();

                    if (phoneuser.equals(phone) && passworduser.equals(password)) {
                        view.isValidUser(false);
                        break;
                    }
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    public boolean notifyWithOrderAction(Context context) {
        return true;
    }


    public void callClients(final LoginActivityPresenter presenter) {
        ClientReferene.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Client> clients = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String phone = dataSnapshot.child(ds.getKey()).child("phone").getValue(String.class);
                    String password = dataSnapshot.child(ds.getKey()).child("password").getValue(String.class);
                    Client client = new Client(phone, password);
                    clients.add(client);
                }

                presenter.receiveClients(clients);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void callHandMan(final LoginActivityPresenter presenter) {

        HandymanReferene.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<HandyMan> HandyMans = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String phone = dataSnapshot.child(ds.getKey()).child("phone").getValue(String.class);
                    String password = dataSnapshot.child(ds.getKey()).child("password").getValue(String.class);
                    String jobName = dataSnapshot.child(ds.getKey()).child("jobName").getValue(String.class);
                    HandyMan handyMan = new HandyMan(phone, password, jobName);
                    HandyMans.add(handyMan);
                }

                presenter.receiveHandyMans(HandyMans);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void acceptOrder(Order order) {
        DatabaseReference orderRecord = OrderReferene.child(order.getOrderType()).child(order.getId());
        orderRecord.child("State").setValue("accepted");
    }

    public void rejectOrder(Order order) {
        DatabaseReference orderRecord = OrderReferene.child(order.getOrderType()).child(order.getId());
        Map<String, Object> userUpdates = new HashMap<>();
        orderRecord.child("State").setValue("rejected");

    }
}
