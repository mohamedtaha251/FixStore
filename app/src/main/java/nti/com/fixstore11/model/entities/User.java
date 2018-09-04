package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class User implements Serializable {

    protected String id;
    protected String name;
    protected String password;
    protected String phone;

    public User() {
        id="0";
        name="default";
        password="default";
        phone="00000000000";
    }
}
