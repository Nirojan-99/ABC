package org.abc.common;

import org.abc.model.Customer;
import org.abc.model.Order;
import org.abc.model.TimeSlot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CommonConstant {
    public static final Queue<TimeSlot> availableTimeSlots = new LinkedList<>();
    public static final Queue<TimeSlot> reservedTimeSlots = new LinkedList<>();
    public static final Queue<TimeSlot> confirmedTimeSlots = new LinkedList<>();
}
