package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class Order implements Serializable{
    String id;
    String Description;
    Client client;
    String ClientRate;
    String Fromdays;

    public Order() {
        this.id = "0";
        Description = "fix electric";
        client=new Client();
        client.setName("Mohamed taha");
        ClientRate = "5";
        Fromdays = "6";
    }

    public Order(String id, String description, Client clientName, String clientRate, String fromdays) {
        this.id = id;
        Description = description;
        client = clientName;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientName) {
        client = clientName;
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
