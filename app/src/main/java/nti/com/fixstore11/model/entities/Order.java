package nti.com.fixstore11.model.entities;

import java.io.Serializable;
import java.util.Calendar;

import nti.com.fixstore11.utils.HandyManUtils;

public class Order implements Serializable{
    String id;
    String OrderType;
    String Description;
    Client client;
    String ClientPrice;
    String Fromdays;
    String Latitude;
    String Longitude;
    String State;

    public Order() {
        this.id = "0";
        this.OrderType = HandyManUtils.jobs[0];
        Description = "fix electric";
        client=new Client();
        client.setName("Mohamed taha");
        ClientPrice = "5";
        Fromdays = Calendar.getInstance().getTime().toString();
        Latitude="-34";
        Longitude="-34";
        State="pending";
    }

    public Order(String id, String description, Client clientName, String clientRate, String fromdays) {
        this.id = id;
        Description = description;
        client = clientName;
        ClientPrice = clientRate;
        Fromdays = fromdays;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
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

    public String getClientPrice() {
        return ClientPrice;
    }

    public void setClientPrice(String clientPrice) {
        ClientPrice = clientPrice;
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
