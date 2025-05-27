package com.pluralsight;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sandwich {
    private List<Topping> toppings = new ArrayList<>();
    private List<String> regularTopping; //Cost free = lettuce, tomato
    private Map<String, Integer> premiumTopping; // Additional cost (cheese, meat)
    private String sandwichSize; //4", 8", or 12"
    private String breadType; //white, wheat, rye, or wrap
    private boolean toasted; // if toasted or not
    //Constructor
    public Sandwich(String sandwichSize, String breadType, List<String> regularTopping, boolean toasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.regularTopping = regularTopping;
        this.premiumTopping = premiumTopping;
        this.toasted = toasted;
    }
    //Getter and Setter
    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public List<String> getRegularTopping() {
        return regularTopping;
    }

    public void setRegularTopping(List<String> regularTopping) {
        this.regularTopping = regularTopping;
    }

    public Map<String, Integer> getPremiumTopping() {
        return premiumTopping;
    }
    public void setPremiumTopping(Map<String, Integer> premiumTopping) {
        this.premiumTopping = premiumTopping;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    // Method calculate the price of the sandwich
    public double calculatePriceOfSandwich() {
        double price = 0.0;
        //Base price on size
        if (size.equals("4")) {
            return price = 4.0;
        } else if (size.equals("8")) {
            price = 6.0;
        } else if (size.equals("12")) {
            price = 8.0;
        }
        // Premium topping price $1.50 cent per unit
        //using for each loop to go through each item
        for (Map.Entry<String, Integer> entry : premiumTopping.entrySet()) {//
            int quantity = entry.getValue(); // how many premium topping customer wants it
            price += quantity * 1.50;
        }
        return price; //final price of sandwich
    }
    //override method shows the order sandwich details
    @Override //Directing Java to replace the default toString method
    public String toString() {
        return sandwichSize + "\" " + breadType + " sandwich\n" + //E.g 8" wheat sandwich
                "Toasted: " + (toasted ? "Yes" : "No") + "\n" + //Boolean choice yes or no
                "Regular topping: " + String.join(",", regularTopping) + "\n" + //Joining regular topping list into string
                "Premium toppings: " + premiumTopping.toString() + "\n" + //prints map like: {cheese = 2, ham = 1}
                "Price: $" + String.format("%.2f", calculatePriceOfSandwich()); //puts price into floats otherwise digits after (.) will be way too lonng

    }
}

