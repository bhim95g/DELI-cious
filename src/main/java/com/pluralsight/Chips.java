package com.pluralsight;

public class Chips {
    private String flavor;
    private double price;

    //Constructor
    public Chips(String flavor, double price) {
        this.flavor = flavor;
        this.price= price;
    }
    //Getters and Setters

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Chips{" +
                "flavor='" + flavor + '\'' +
                ", price=" + price +
                '}';
    }
}
