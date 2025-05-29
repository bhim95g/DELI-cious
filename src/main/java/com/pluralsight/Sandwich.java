package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private List<Topping> toppings = new ArrayList<>();  // holds both regular and premium toppings
    private int sandwichSize; //4", 8", or 12"
    private String breadType; //white, wheat, rye, or wrap
    private boolean toasted; // if toasted or not

    //Constructor
    public Sandwich(int sandwichSize, String breadType, List<Topping> toppings, boolean toasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    //Getter and Setter
    public int getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    // Method calculate the price of the sandwich
    public double calculatePrice() {
        double price = 0.0;

        // Base price for bread size
        switch (sandwichSize) {
            case (4):
                price = 5.50;
                break;
            case (8):
                price = 7.00;
                break;
            case (12):
                price = 8.50;
                break;
        }

        // Add premium toppings price
        for (Topping topping : toppings) {
            if (topping.isPremium()) {
                String name = topping.getName().toLowerCase();
                int quantity = topping.getQuantity();

                // Determine price per unit by size and type
                double unitPrice = 0.0;

                // Meats
                if (name.equals("steak") || name.equals("ham") || name.equals("salami") ||
                        name.equals("roast beef") || name.equals("chicken") || name.equals("bacon")) {

                // Price of the premium topping according to the sandwich size
                    if (sandwichSize == 4) unitPrice = 1.00;
                    else if (sandwichSize == 8) unitPrice = 2.00;
                    else if (sandwichSize == 12) unitPrice = 3.00;

                    // Add extra meat price for more than 1
                    if (quantity > 1) {
                        double extra = (sandwichSize == 4) ? 0.50 :
                                (sandwichSize == 8) ? 1.00 : 1.50;
                        price += unitPrice + (quantity - 1) * extra;
                    } else {
                        price += unitPrice;
                    }
                }

                // Cheeses
                else if (name.equals("american") || name.equals("provolone") ||
                        name.equals("cheddar") || name.equals("swiss")) {

                    if (sandwichSize == 4) unitPrice = 0.75;
                    else if (sandwichSize == 8) unitPrice = 1.50;
                    else if (sandwichSize == 12) unitPrice = 2.25;

                    if (quantity > 1) {
                        double extra = (sandwichSize == 4) ? 0.30 :
                                (sandwichSize == 8) ? 0.60 : 0.90;
                        price += unitPrice + (quantity - 1) * extra;
                    } else {
                        price += unitPrice;
                    }
                }
            }
        }

        return price;
    }

    //override method shows the order sandwich details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sandwichSize).append("\" ").append(breadType).append(" sandwich\n");
        sb.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        sb.append("Toppings:\n");
        for (Topping topping : toppings) {
            sb.append("  - ").append(topping.getName());
            if (topping.getQuantity() > 1) sb.append(" x").append(topping.getQuantity());
            sb.append(topping.isPremium() ? " (premium)" : "");
            sb.append("\n");
        }

        sb.append("Price: $").append(String.format("%.2f", calculatePrice()));
        return sb.toString();
    }
}

