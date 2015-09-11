package io.downto.courierondemand;

/**
 * Created by James on 9/12/2015.
 */
public class Item {
    private String pickUp;
    private String dropOff;
    private String userId;
    private double weight;
    private int height;
    private int width;

    public Item(String pickUp, String dropOff, String userId, double weight, int height, int width) {
        this.pickUp = pickUp;
        this.dropOff = dropOff;
        this.userId = userId;
        this.weight = weight;
        this.height = height;
        this.width = width;
    }

    public String getPickUp() {
        return pickUp;
    }

    public String getDropOff() {
        return dropOff;
    }

    public String getUserId() {
        return userId;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
