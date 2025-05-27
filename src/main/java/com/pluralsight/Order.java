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
    public void addDrinks(Drinks drinks) {
        drinks.add(drinks);
    }
    public void addChips(Chips chips) {
        chips.add(chips);
    }
    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches)
            total += sandwich.calculatePriceOfSandwich();

        for (Drinks drinks1 : drinks)
            total += drinks1.getPrice();

        for (Chips chips1 : chips)
            total += chips1.getPrice();

        return total;

    }
}
