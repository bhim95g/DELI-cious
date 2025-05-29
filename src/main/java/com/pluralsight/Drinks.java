package com.pluralsight;

public class Drinks {

    private String size;
    private double price;

    //Constructor
    public Drinks(String size) {
        this.size = size.toLowerCase();
        this.price = calculatePrice(size);
    }
    private double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.0; //if invalid input it will go back to default value
        }
    }
    //Getters and Setters
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return size.substring(0, 1).toUpperCase() + size.substring(1) + " drink - $" + String.format("%.2f", price);
    }
}
