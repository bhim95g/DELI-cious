package com.pluralsight;

import java.util.Arrays;
import java.util.List;

public class Menu {

    // Available sandwich sizes
    public static List<Integer> getSandwichSizes() {
        return Arrays.asList(4, 8, 12);
    }

    // Available bread types
    public static List<String> getBreadTypes() {
        return Arrays.asList("white", "wheat", "rye", "wrap");
    }

    // Available drink sizes
    public static List<String> getDrinkSizes() {
        return Arrays.asList("small", "medium", "large");
    }

    // Available drink flavors
    public static List<String> getDrinkFlavors() {
        return Arrays.asList("Coke", "Sprite", "Water", "Lemonade", "Iced Tea");
    }

    // Available chip flavors
    public static List<String> getChipFlavors() {
        return Arrays.asList("BBQ", "Sour Cream", "Jalapeño", "Regular", "Cheddar");
    }

    // Available regular toppings
    public static List<String> getRegularToppings() {
        return Arrays.asList("lettuce", "tomato", "onion", "pickles", "peppers", "cucumber", "spinach");
    }

    // Available premium toppings
    public static List<String> getPremiumToppings() {
        return Arrays.asList("turkey", "ham", "roast beef", "chicken", "bacon", "cheddar", "swiss", "provolone");
    }

    // Optional: display options to user
    public static void showDrinkMenu() {
        System.out.println("Available Drink Sizes: " + getDrinkSizes());
        System.out.println("Available Flavors: " + getDrinkFlavors());
    }

    public static void showChipMenu() {
        System.out.println("Available Chip Flavors: " + getChipFlavors());
    }

    public static void showBreadMenu() {
        System.out.println("Available Breads: " + getBreadTypes());
    }

    public static void showToppingsMenu() {
        System.out.println("Regular Toppings: " + getRegularToppings());
        System.out.println("Premium Toppings: " + getPremiumToppings());
    }
}

