package org.abc;

import org.abc.utils.TimeSlotUtil;
import java.util.Scanner;


public class Main {

    static {
        System.out.println("\nHey, Good morning!\nYou can reserve customers for the slot 6PM - 7PM\n");
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Reserve slot");
            System.out.println("2. Confirm a customer");
            System.out.println("3. Display slot details");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TimeSlotUtil.reserveSlot();
                    break;
                case 2:
                    TimeSlotUtil.confirmSlot();
                    break;
                case 3:
                    TimeSlotUtil.displaySlots();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
        scanner.close();
    }
}