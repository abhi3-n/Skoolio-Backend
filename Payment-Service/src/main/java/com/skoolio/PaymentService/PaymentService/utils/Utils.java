package com.skoolio.PaymentService.PaymentService.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String convertEpochToMonthYear(long epochValue) {
        // Convert epoch value to LocalDate
        LocalDate date = Instant.ofEpochSecond(epochValue)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Format LocalDate to MM/YYYY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return date.format(formatter);
    }
}
