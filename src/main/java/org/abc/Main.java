package org.abc;

import org.abc.utils.TimeSlotUtil;
import java.util.Scanner;


public class Main {

    static {
        TimeSlotUtil.generateTimeSlotForTheDay();
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Reserve a delivery slot");
            System.out.println("2. Confirm a delivery slot");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            Thread.sleep(100);

            switch (choice) {
                case 1:
                    TimeSlotUtil.reserveSlot();
                    break;
                case 2:
                    TimeSlotUtil.confirmSlot();
                    break;
                case 3:
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