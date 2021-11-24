package main.java.domain;

import com.google.common.base.MoreObjects;

public class Automobile {
    private int id;
    private String model;
    private String colour;

    public Automobile(int id, String model, String colour){
        this.id = id;
        this.model=model;
        this.colour = colour;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("model", model)
                .add("colour", colour)
                .toString();
    }
}
