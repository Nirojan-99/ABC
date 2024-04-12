package org.abc.utils;

public class InputUtil {
    public static boolean isValidString(String value) {
        return !value.trim().isEmpty();
    }

    public static boolean isValidNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
