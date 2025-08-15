package com.byterexx.document.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static String format (Date date, String format, String timezone) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone(timezone));
        return sdf.format(date);
    }

    public static Date parse (String date, String format, String timezone) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.setTimeZone(TimeZone.getTimeZone(timezone));
            return sdf.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
