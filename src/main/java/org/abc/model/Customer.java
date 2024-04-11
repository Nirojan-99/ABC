package org.abc.model;

public class Customer {
    private String customerName;
    private String contactNumber;

    public Customer() {
    }

    public Customer(String customerName, String contactNumber) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
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
}
