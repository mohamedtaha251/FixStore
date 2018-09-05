package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class Client extends User implements Serializable {


    public Client() {
        super();

    }

    public Client(String phone, String password) {
        super();
        this.phone = phone;
        this.password = password;
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
