package org.abc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isvalidContactNumber(String phoneNumber) {
        String regex = "\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
