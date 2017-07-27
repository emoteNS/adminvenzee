package com.venzee.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by antoniohernandez on 7/27/17.
 */
public class DateHelper {

    public static LocalDateTime getDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zz yyyy");
        return LocalDateTime.parse(dateString, formatter);
    }

    public static void main(String [] args) {
        System.out.println(DateHelper.getDate("Thu Jul 27 16:31:46 UTC 2017"));
    }
}
