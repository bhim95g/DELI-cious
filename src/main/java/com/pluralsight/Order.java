package com.pluralsight;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void addDrink(Drinks drink1) {
        drinks.add(drink1);
    }
    public void addChips(Chips chips1) {
        chips.add(chips1);
    }

    //Calculate the total price of the order
    public double calculateTotal() {
        double total = 0.0;

        //adding up price of the sandwich
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }
        //adding price of the drinks
        for (Drinks drinks1 : drinks) {
            total += drinks1.getPrice();
        }
        //adding prices of the chips
        for (Chips chips1 : chips) {
            total += chips1.getPrice();
        }

            return total;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- Order Summary -----\n");
        for (Sandwich s : sandwiches) sb.append(s.toString()).append("\n");
        for (Drinks d : drinks) sb.append(d.toString()).append("\n");
        for (Chips c : chips) sb.append(c.toString()).append("\n");
        sb.append("--------------------------\n");
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }


}
