package ru.netology.delivery;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateManager {
    public static Date convertLocalDateToDate(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate convertDateToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String formatLocalDate(LocalDate dateToFormat) {
        return dateToFormat.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
