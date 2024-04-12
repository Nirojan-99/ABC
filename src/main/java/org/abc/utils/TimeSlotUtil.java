package org.abc.utils;

import org.abc.common.CommonConstant;
import org.abc.model.Customer;
import org.abc.model.Food;
import org.abc.model.Order;

import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class TimeSlotUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void reserveSlot() {
        System.out.print("Enter number of Customers to reserve : ");
        String count = scanner.nextLine();
        if (!InputUtil.isValidNumber(count)) {
            System.out.println("Invalid value entered !!");
            return;
        }
        CommonConstant.customerPerSlot = Integer.parseInt(count);
        for (int i = 1; i <= Integer.parseInt(count); i++) {
            reserveOneCustomer(i);
        }
    }

    public static void reserveOneCustomer(int index) {
        System.out.print("\nEnter Customer " + index + " name : ");
        String name = scanner.nextLine();
        if (!InputUtil.isValidString(name)) {
            System.out.println("Invalid value entered !!");
            return;
        }

        System.out.print("Enter Customer " + index + " contact number : ");
        String contactNumber = scanner.nextLine();
        if (!InputUtil.isValidNumber(contactNumber)) {
            System.out.println("Invalid value entered !!");
            return;
        }

        HashMap<Food, Double> orderList = new HashMap<>();
        while (true) {
            System.out.print("Enter food name to order (-1 to exit) : ");
            String foodName = scanner.nextLine();
            if (foodName.equals("-1") || !InputUtil.isValidString(foodName)) {
                break;
            }

            System.out.print("Enter quantity : ");
            String quantity = scanner.nextLine();
            if (!InputUtil.isValidNumber(quantity)) {
                System.out.println("Invalid value entered !!");
                return;
            }

            Food food = new Food(foodName);
            orderList.put(food, Double.valueOf(quantity));

        }

        Order order = new Order();
        order.setItems(orderList);

        Customer customer = new Customer(name, contactNumber, order);

        CommonConstant.reservedCustomers.add(customer);
    }


    public static void confirmSlot() {
        System.out.print("Enter customer name : ");
        String name = scanner.nextLine();
        if (!InputUtil.isValidString(name)) {
            System.out.println("Invalid value entered !!");
            return;
        }

        boolean customerFound = false;

        for (Customer customer : CommonConstant.reservedCustomers) {
            if (customer.getCustomerName().equals(name)) {
                customerFound = true;

                System.out.println("\nMake a call to Customer contact number : " + customer.getContactNumber());

                System.out.print("Confirmed(1) || Canceled(2) || No Answer(3) : ");
                int confirmation = scanner.nextInt();

                if (confirmation == 2) {
                    CommonConstant.reservedCustomers.remove(customer);
                    CommonConstant.canceledCustomers.add(customer);
                } else if (confirmation == 3) {
                    if (customer.getOrder().getConfirmationAttempts() == 2) {
                        CommonConstant.reservedCustomers.remove(customer);
                        CommonConstant.canceledCustomers.add(customer);
                    }
                } else if (confirmation == 1) {
                    CommonConstant.reservedCustomers.remove(customer);
                    CommonConstant.confirmedCustomers.add(customer);
                }
                customer.getOrder().setConfirmationAttempts(customer.getOrder().getConfirmationAttempts() + 1);

                break;
            }
        }

        if (!customerFound) {
            System.out.println("Customer not found. Please make a reservation first.\n");
        }

    }

    public static void displaySlots() {
        boolean running = true;

        while (running) {
            System.out.println("\n1. Reserved customers");
            System.out.println("2. Confirmed customers");
            System.out.println("3. Canceled customers");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Reserved customers\n");
                    TimeSlotUtil.displaySlot(CommonConstant.reservedCustomers);
                    break;
                case 2:
                    System.out.println("Confirmed customers\n");
                    TimeSlotUtil.displaySlot(CommonConstant.confirmedCustomers);
                    break;
                case 3:
                    System.out.println("Canceled customers\n");
                    TimeSlotUtil.displaySlot(CommonConstant.canceledCustomers);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public static void displaySlot(Queue<Customer> customers) {
        System.out.println("CustomerName\t\tContactNumber\t\torderID\t\titems");
        System.out.println("-----------------------------------------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer.getCustomerName() + "\t\t" + customer.getContactNumber() + "\t\t" + customer.getOrder().getOrderID() + "\t\t" + customer.getOrder().getItemsToPrint());
        }
    }
}
