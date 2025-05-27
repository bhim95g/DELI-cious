package com.pluralsight;

public class Drinks {
    private String type;
    private double price;
    //Constructor
    public Drinks(String type, double price) {
        this.type = type;
        this.price = price;
    }
    //Getters and Setters
    public String getType() {
        return type;
    }
    public void setType(String Type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
