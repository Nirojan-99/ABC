package org.abc.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderID;
    private HashMap<Food, Double> items;

    private int confirmationAttempts;

    public int getConfirmationAttempts() {
        return confirmationAttempts;
    }

    public void setConfirmationAttempts(int confirmationAttempts) {
        this.confirmationAttempts = confirmationAttempts;
    }

    public Order() {
        long currentTimeMillis = System.currentTimeMillis();
        String eightDigitNumber = String.format("%08d", currentTimeMillis % 100000000L);

        items = new HashMap<>();
        orderID = eightDigitNumber;
        confirmationAttempts = 0;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public HashMap<Food, Double> getItems() {
        return items;
    }

    public void setItems(HashMap<Food, Double> items) {
        this.items = items;
    }

    public String getItemsToPrint() {
        String value = "";
        for (Map.Entry<Food, Double> entry : items.entrySet()) {
            value += entry.getKey().getFoodName() + ": " + entry.getValue() + " || ";
        }
        return value;
    }
}
