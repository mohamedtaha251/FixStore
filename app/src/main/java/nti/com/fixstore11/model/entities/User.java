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

    public User(User user) {
        id=user.getId();
        name=user.getName();
        password=user.getPassword();
        phone=user.getPhone();
    }

    public User(String password, String phone) {
        id="0";
        name="default";
        this.password = password;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
