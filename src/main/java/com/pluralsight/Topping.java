package com.pluralsight;

import java.util.*;

public class Topping {
    private String name;

    private int quantity;
    private boolean isPremium;

    // Constructor
    public Topping(String name, int quantity, boolean isPremium) {
        this.name = name;
        this.quantity = quantity;
        this.isPremium = isPremium;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public boolean isPremium() { return isPremium; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return name + " x" + quantity + (isPremium ? " (Premium)" : "");
    }
}
