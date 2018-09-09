package nti.com.fixstore11.utils;

import android.content.Context;
import android.content.SharedPreferences;

import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.User;

public class LoginUtils {

    private static final String PREFS_FIXSTORE_USER = "FixStoreUser";
    private static final String PREF_PHONE = "Phone";
    private static final String PREF_PASSWORD = "Password";
    private static final String PREF_USERTYPE = "UserType";

    private static final String DefaultPhoneValue = "";
    private static final String DefaultPasswordValue = "";
    private static final String DefaultUserTypeValue = "User";

    public static void savePreferences(Context context, User user) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_FIXSTORE_USER,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString(PREF_PHONE, user.getPhone());
        editor.putString(PREF_PASSWORD, user.getPassword());

        if(user instanceof HandyMan) {
            editor.putString(PREF_USERTYPE, "HandyMan");
        }

        if(user instanceof Client) {
            editor.putString(PREF_USERTYPE, "Client");
        }

        editor.commit();
    }


    public static User loadPreferences(Context context) {

        SharedPreferences settings = context.getSharedPreferences(PREFS_FIXSTORE_USER,Context.MODE_PRIVATE);

        // Get value from shared prefrence
        String PhoneValue = settings.getString(PREF_PHONE, DefaultPhoneValue);
        String PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        String UserTypeValue = settings.getString(PREF_USERTYPE, DefaultUserTypeValue);

        User user=new User(PhoneValue,PasswordValue);

        if(UserTypeValue.equals("HandyMan"))
            user=new HandyMan(user);

        if(UserTypeValue.equals("Client"))
            user=new Client(user);

        return user;
    }


}
