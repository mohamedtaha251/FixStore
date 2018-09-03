package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class Order implements Serializable{
    String id;
    String Description;
    String ClientName;
    String ClientRate;
    String Fromdays;

    public Order() {
        this.id = "0";
        Description = "fix electric";
        ClientName = "Mohamed taha";
        ClientRate = "5";
        Fromdays = "6";
    }

    public Order(String id, String description, String clientName, String clientRate, String fromdays) {
        this.id = id;
        Description = description;
        ClientName = clientName;
        ClientRate = clientRate;
        Fromdays = fromdays;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientRate() {
        return ClientRate;
    }

    public void setClientRate(String clientRate) {
        ClientRate = clientRate;
    }

    public String getFromdays() {
        return Fromdays;
    }

    public void setFromdays(String fromdays) {
        Fromdays = fromdays;
    }

    public void setId(String id) {
        this.id = id;
    }
}
