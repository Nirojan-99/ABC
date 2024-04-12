package org.abc.common;

import org.abc.model.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class CommonConstant {
    public static final Queue<Customer> reservedCustomers = new LinkedList<>();
    public static final Queue<Customer> confirmedCustomers = new LinkedList<>();
    public static final Queue<Customer> canceledCustomers = new LinkedList<>();
    public static int customerPerSlot = 0;
}
