package nti.com.fixstore11.model.entities;

import java.io.Serializable;

public class WorkManShip implements Serializable {
    int id;
    String Name;
    String ImageIcon;

    public WorkManShip() {
        this.id = 0;
        Name = "electrican";
        ImageIcon = "https://cdn0.iconfinder.com/data/icons/electricity-4/318/electrician_icon.png";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageIcon() {
        return ImageIcon;
    }

    public void setImageIcon(String imageIcon) {
        ImageIcon = imageIcon;
    }
}
