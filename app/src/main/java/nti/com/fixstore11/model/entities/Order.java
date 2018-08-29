package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class Order implements Serializable{
    int id;
    String Description;
    String ClientName;
    int ClientRate;
    int Fromdays;

    public Order() {
        this.id = 1;
        Description = "fix electric";
        ClientName = "Mohamed taha";
        ClientRate = 5;
        Fromdays = 6;
    }

    public Order(int id, String description, String clientName, int clientRate, int fromdays) {
        this.id = id;
        Description = description;
        ClientName = clientName;
        ClientRate = clientRate;
        Fromdays = fromdays;
    }

    public int getId() {
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

    public int getClientRate() {
        return ClientRate;
    }

    public void setClientRate(int clientRate) {
        ClientRate = clientRate;
    }

    public int getFromdays() {
        return Fromdays;
    }

    public void setFromdays(int fromdays) {
        Fromdays = fromdays;
    }

    public void setId(int id) {
        this.id = id;
    }
}
