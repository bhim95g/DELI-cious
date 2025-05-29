package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    public void printReceipt(Order order) {
        // Create the "receipts" folder if it doesn't exist
        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Create filename using current date & time
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timestamp + ".txt";

        // Write the receipt
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("====== Deli-cious Receipt ======\n\n");
            writer.write(order.toString()); // relies on Order having a good toString()
            writer.write("\nThank you for your order!\n");
            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
