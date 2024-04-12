package org.abc.model;


public class Order {
    private String orderID;
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
        orderID = eightDigitNumber;
        confirmationAttempts = 0;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

}
