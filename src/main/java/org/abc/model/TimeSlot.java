package org.abc.model;

public class TimeSlot {
    private int slotID;
    private String startHour;
    private String endHour;
    private String date;
    private boolean reserved;
    private int confirmationAttempts;
    private Order order;

    public TimeSlot() {
        confirmationAttempts = 0;
    }

    public TimeSlot(int slotID, String startHour, String endHour, String date, boolean reserved) {
        this.slotID = slotID;
        this.startHour = startHour;
        this.endHour = endHour;
        this.date = date;
        this.reserved = reserved;
        this.confirmationAttempts = 0;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getConfirmationAttempts() {
        return confirmationAttempts;
    }

    public void setConfirmationAttempts(int confirmationAttempts) {
        this.confirmationAttempts = confirmationAttempts;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
