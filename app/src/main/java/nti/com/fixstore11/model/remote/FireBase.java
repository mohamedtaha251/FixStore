package nti.com.fixstore11.model.remote;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;

public final class FireBase {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference referene;
    private FirebaseUser firebaseUser;


    public FireBase() {
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    public boolean addReference(String referenceName) {
        referene = database.getReference(referenceName);
        return true;
    }

    public String generateKey() {
        return referene.push().getKey();
    }

    public boolean isLogged(String mobile, String password) {

        return true;
    }

    public boolean isValidUser(String mobile, String password) {
        return true;
    }


    public boolean addOrder(Order order) {
        return true;
    }

    public boolean addClient(Client order) {
        return true;
    }

    public boolean addHandyMan(HandyMan handyMan) {
        return true;
    }

    public boolean notifyWithNewOrder(Context context) {
        return true;
    }

    public boolean notifyWithOrderAction(Context context) {
        return true;
    }


}
