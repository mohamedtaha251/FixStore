package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class HandyMan extends User implements Serializable {

    private String jobName;
    private int Age;

    public HandyMan() {
        super();
        jobName="PLUMBER";
        Age=0;

    }

    public HandyMan(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        Age = age;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
