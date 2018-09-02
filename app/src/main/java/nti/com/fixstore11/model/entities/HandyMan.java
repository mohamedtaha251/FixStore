package nti.com.fixstore11.model.entities;

public class HandyMan {

    private String id;
    private String name;
    private String phone;
    private String password;
    private int Age;

    public HandyMan() {
    }

    public HandyMan(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        Age = age;
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
