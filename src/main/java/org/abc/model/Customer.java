package org.abc.model;

public class Customer {
    private String customerName;
    private String contactNumber;
    private Order order;

    public Customer() {
    }

    public Customer(String customerName, String contactNumber, Order order) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
