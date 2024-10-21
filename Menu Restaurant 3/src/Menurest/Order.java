package Menurest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<MenuItem, Integer> orderItems;

    public Order() {
        orderItems = new HashMap<>();
    }

    public void addItem(MenuItem item, int quantity) {
        if (orderItems.containsKey(item)) {
            orderItems.put(item, orderItems.get(item) + quantity);
        } else {
            orderItems.put(item, quantity);
        }
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            subtotal += item.getPrice() * quantity;
        }
        return subtotal;
    }

    public double calculateDiscount(double subtotal) {
        return (subtotal > 50) ? subtotal * 0.10 : 0.0;
    }

    public double calculateTax(double amount) {
        return amount * 0.13;
    }

    public String getOrderSummary() {
        StringBuilder summaryBuilder = new StringBuilder("ORDER SUMMARY:\n");
        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            summaryBuilder.append(String.format("%s x %d - $%.2f%n", item.getName(), quantity, item.getPrice() * quantity));
        }

        double subtotal = calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double tax = calculateTax(subtotal - discount);
        double total = subtotal - discount + tax;

        summaryBuilder.append(String.format("%n_______________%nSubtotal: $%.2f%n", subtotal));
        summaryBuilder.append(String.format("Discount: $%.2f%n", discount));
        summaryBuilder.append(String.format("Tax: $%.2f%n", tax));
        summaryBuilder.append(String.format("Total: $%.2f%n", total));

        return summaryBuilder.toString();
    }

    public void saveOrderSummaryToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(getOrderSummary());
            System.out.println("Order summary saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving order summary to file: " + e.getMessage());
        }
    }
}
