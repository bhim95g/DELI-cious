package com.pluralsight;


public class Topping {
    private String name;        // Name of the topping (e.g., "ham")
    private boolean isPremium;  // True if premium (meats, cheeses), false if regular
    private int quantity;       // How many servings

    public Topping(String name, boolean isPremium, int quantity) {
        this.name = name;
        this.isPremium = isPremium;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }
    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional: override toString for display
    @Override
    public String toString() {
        return name + (quantity > 1 ? " x" + quantity : "");
    }
}

