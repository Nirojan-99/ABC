package org.abc.utils;

import org.abc.common.CommonConstant;
import org.abc.model.Customer;
import org.abc.model.Order;
import org.abc.model.TimeSlot;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class TimeSlotUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void reserveSlot() {
        System.out.print("Enter Customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer contact number: ");
        String contactNumber = scanner.nextLine();
        Customer customer = new Customer(name, contactNumber);

        System.out.print("Enter Order ID: ");
        String orderID = scanner.nextLine();
        Order order = new Order(orderID, customer);

        System.out.println();
        System.out.println("Following are available timeslots");
        for (TimeSlot timeSlot : CommonConstant.availableTimeSlots) {
            System.out.println(timeSlot.getStartHour() + ":00 - " + timeSlot.getEndHour() + ":00\t\tID : " + timeSlot.getSlotID());
        }

        System.out.print("Enter slot ID :");
        int slotID = scanner.nextInt();
        Iterator<TimeSlot> iterator = CommonConstant.availableTimeSlots.iterator();

        while (iterator.hasNext()) {
            TimeSlot timeSlot = iterator.next();
            if (timeSlot.getSlotID() == slotID) {
                if (timeSlot.isReserved()) {
                    System.out.print("Entered slot is not available");
                    break;
                }
                timeSlot.setReserved(true);
                timeSlot.setOrder(order);

                CommonConstant.availableTimeSlots.remove(timeSlot);
                CommonConstant.reservedTimeSlots.add(timeSlot);

                break;
            }
        }
    }


    public static void generateTimeSlotForTheDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);

        int ID = 1;
        for (int i = 7; i < 22; i++) {
            TimeSlot timeSlot = new TimeSlot(ID, String.valueOf(i), String.valueOf(i + 1), today, false);
            CommonConstant.availableTimeSlots.add(timeSlot);
            ID++;
        }
    }

    public static void confirmSlot() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        boolean slotFound = false;

        for (TimeSlot timeSlot : CommonConstant.reservedTimeSlots) {
            if (timeSlot.getOrder().getCustomer().getCustomerName().equals(name)) {
                System.out.println("Customer contact number : " + timeSlot.getOrder().getCustomer().getContactNumber());
                if (timeSlot.getConfirmationAttempts() >= 3) {
                    System.out.println("Maximum confirmation attempts are finished");
                    break;
                } else {
                    System.out.print("Confirmed(1) || Canceled(2) || No Answer(3) : ");
                    int confirmation = scanner.nextInt();

                    if (confirmation == 2) {
                        timeSlot.setReserved(false);
                        timeSlot.setOrder(null);
                        CommonConstant.reservedTimeSlots.remove(timeSlot);
                        CommonConstant.availableTimeSlots.add(timeSlot);
                    } else if (confirmation == 3) {
                        if (timeSlot.getConfirmationAttempts() == 2) {
                            timeSlot.setReserved(false);
                            timeSlot.setOrder(null);
                            CommonConstant.reservedTimeSlots.remove(timeSlot);
                            CommonConstant.availableTimeSlots.add(timeSlot);
                        }
                    } else if (confirmation == 1) {
                        CommonConstant.reservedTimeSlots.remove(timeSlot);
                        CommonConstant.confirmedTimeSlots.add(timeSlot);
                    }
                    timeSlot.setConfirmationAttempts(timeSlot.getConfirmationAttempts() + 1);
                }
                break;
            }
        }

        if (!slotFound) {
            System.out.println("Slot not found. Please make a reservation first.");
        }
    }
}
