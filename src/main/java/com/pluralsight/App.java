package com.pluralsight;

import java.util.*;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;
    private Order currentOrder;

    public void run() {
        while (isRunning) {
            showHomeMenu();
        }
        scanner.close(); // Close scanner when done
    }

    private void showHomeMenu() {
        System.out.println("======Welcome to DELI-cious======");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Please select an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                startNewOrder();
                break;
            case 0:
                isRunning = false; // Exit program
                System.out.println("Thank you! Goodbye.");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private void startNewOrder() {
        currentOrder = new Order(); // Create a new order object
        showOrderMenu();
    }

    // Implement the order menu here
    private void showOrderMenu() {
        boolean orderInProgress = true;
        while (orderInProgress) {
            System.out.println("\nOrder Menu: ");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    orderInProgress = false; // End order
                    break;
                case 0:
                    currentOrder = null; // Cancel order
                    orderInProgress = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
    //Building a sandwich
    // Sandwich size
    private void addSandwich() {
        System.out.println("Choose a size: (1) 4\" (2) 8\" (3) 12\"");
        int sizeChoice = scanner.nextInt(); //Reads number input
        scanner.nextInt(); //consume newline
        int size = 4;
        if (sizeChoice == 2) size = 8;
        else if (sizeChoice == 3) size = 12;

        //chose bread type
        System.out.println("Choose bread: (1) White, (2) Wheat, (3) Rye, (4) Wrap");
        int breadChoice = scanner.nextInt();
        scanner.nextInt();
        String bread = "Wheat";
        switch (breadChoice) {
            case 2 -> bread = "Wheat";
            case 3 -> bread = "Rye";
            case 4 -> bread = "Wrap";
        }
        // Toasted or not toasted
        System.out.println("Do you want your bread to be toasted? Please choose (yes or no)");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        // 4. Choose regular toppings (free)
        List<String> regularToppings = new ArrayList<>();
        System.out.println("Add regular toppings (lettuce, tomato, onion, etc). Type 'done' when finished:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            regularToppings.add(topping); // add topping to list
        }

        // 5. Choose premium toppings (meat/cheese)
        Map<String, Integer> premiumToppings = new HashMap<>();
        System.out.println("Add premium toppings (meat, cheese, etc). Type 'done' when finished:");
        while (true) {
            System.out.print("Enter topping name (or 'done'): ");
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;

            System.out.print("How many servings of " + topping + "? ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // clear newline
            premiumToppings.put(topping, quantity); // store topping and how many
        }

    }

    private void addDrink() {
        System.out.println("Adding a drink...");
        // TO DO
    }

    private void addChips() {
        System.out.println("Adding chips...");
        // TO DO
    }

    private void checkout() {
        System.out.println("Order Details:");
        if (currentOrder != null) {
            currentOrder.displayOrder();
            currentOrder.saveReceipt();
        }
        System.out.println("Order completed. Returning to main menu...");
    }
}

