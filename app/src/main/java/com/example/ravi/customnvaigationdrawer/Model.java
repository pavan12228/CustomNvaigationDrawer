package com.example.ravi.customnvaigationdrawer;

/**
 * Created by Ravi on 28-01-2017.
 */
public class Model
{
    String image;
    String name;

    public Float getName() {
        return Float.valueOf(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
