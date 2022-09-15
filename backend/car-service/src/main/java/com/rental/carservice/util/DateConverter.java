package com.rental.carservice.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class DateConverter {
    public static OffsetDateTime toDate(String date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return OffsetDateTime.of(LocalDateTime.parse(date, formatter), ZoneOffset.UTC);
    }
}
