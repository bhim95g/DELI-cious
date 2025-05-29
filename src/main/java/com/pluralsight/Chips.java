package com.pluralsight;

public class Chips {
    private String flavor;
    private double price = 1.50;

    //Constructor
    public Chips(String flavor) {
        this.flavor = flavor;

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
        return flavor + " chips ($" + String.format("%.2f", price) + ")";
    }
}
