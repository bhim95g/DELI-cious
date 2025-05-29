package com.pluralsight;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class App {

    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    private boolean isRunning = true;

    public static void main(String[] args) {
        new App().run();
    }

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
            scanner.nextLine(); //Adding a blank line

            switch (choice) {
                case 1:
                    Sandwich sandwich = buildSandwich(scanner);
                    currentOrder.addSandwich(sandwich);
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
    public static Sandwich buildSandwich(Scanner scanner) {
        // 1. Select sandwich size
        System.out.println("Choose sandwich size (4 / 8 / 12): ");
        int size = Integer.parseInt(scanner.nextLine()); // read user input and convert to integer

        // 2. Select bread type
        System.out.println("Choose bread type (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine(); // read bread type

        // 3. Toasted or not
        System.out.println("Would you like it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes"); // convert answer to true or false

        // 4. Build toppings list (regular + premium)
        List<Topping> toppings = new ArrayList<>();

        // 4a. Regular toppings (free)
        System.out.println("Add regular toppings (lettuce, tomato, etc). Type 'done' to finish:");
        while (true) {
            System.out.print("Enter topping: ");
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) break;

            // Always 1 serving for regular and not premium
            toppings.add(new Topping(toppingName, false, 1));
        }

        // 4b. Premium toppings (meats, cheeses)
        System.out.println("Add premium toppings (meat, cheese, etc). Type 'done' to finish:");
        while (true) {
            System.out.print("Enter premium topping: ");
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) break;

            System.out.print("How many servings of " + toppingName + "? ");
            int quantity = Integer.parseInt(scanner.nextLine());

            toppings.add(new Topping(toppingName, true, 1)); // mark as premium
        }

        return new Sandwich(size, bread, toppings, toasted);
    }

    private void addDrink() {
        System.out.println("Adding a drink...");

        // 1. Ask for drink size
        System.out.println("Choose a drink size (small / medium / large): ");
        String size = scanner.nextLine().trim().toLowerCase(); // read and sanitize input

        try {
            // 2. Create the drink object using user input
            Drinks drink = new Drinks(size);

            // 3. Add it to the current order
            currentOrder.addDrink(drink); // make sure your Order class has this method

            // 4. Confirm to user
            System.out.println("Drink added: " + drink.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Please try again");
        }
    }

        private void addChips () {
            System.out.println("Adding chips to your order...");

            // 1. Ask user for chip flavor
            System.out.println("Enter chip flavor (e.g., BBQ, Sour Cream, Jalapeño, Regular): ");
            String flavor = scanner.nextLine().trim(); // read and clean up input

            // 2. Create a Chips object
            Chips chips = new Chips(flavor);

            // 3. Add the chips to the current order
            currentOrder.addChips(chips); // make sure 'order' is the current Order object

            // 4. Confirm to the user
            System.out.println("Chips added: " + chips.toString());
        }


        private void checkout () {
            System.out.println("===== Checkout =====");

            // 1. Show the order summary
            System.out.println(currentOrder.toString()); // prints sandwiches, drinks, chips, total

            // 2. Ask for confirmation
            System.out.println("Would you like to confirm your order? (yes/no): ");
            String input = scanner.nextLine();

            // 3. If confirmed
            if (input.equalsIgnoreCase("yes")) {
                Receipt receipt = new Receipt();
                receipt.printReceipt(currentOrder);

                System.out.println("Thank you! Your order has been placed.");
                currentOrder = null; // clear the current order
            } else {
                System.out.println("Order canceled. Returning to main menu.");
            }
        }
        private void saveReceipt () {
            try {
                // 1. Create the "receipts" folder if it doesn't already exist
                File folder = new File("receipts");
                if (!folder.exists()) {
                    folder.mkdir(); // make the folder
                }

                // 2. Generate the filename based on current date and time
                LocalDateTime now = LocalDateTime.now(); // current date/time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); // format
                String fileName = now.format(formatter) + ".txt"; // example: 20250527-154830.txt

                // 3. Create the file inside the "receipts" folder
                File file = new File(folder, fileName);

                // 4. Write the order details into the file
                FileWriter writer = new FileWriter(file);
                writer.write(currentOrder.toString()); // order summary includes sandwiches, drinks, chips, and total
                writer.close();

                System.out.println("Receipt saved as: receipts/" + fileName); // let the user know

            } catch (IOException e) {
                System.out.println("Failed to save receipt: " + e.getMessage());
            }
        }
    }



