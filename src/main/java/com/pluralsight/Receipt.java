package com.pluralsight;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    public void printReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("======Deli-cious Receipt======\n\n");

        }


    }
}
