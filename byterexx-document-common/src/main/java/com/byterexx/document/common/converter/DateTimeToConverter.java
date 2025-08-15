package com.byterexx.document.common.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.byterexx.document.common.constants.AppConstants;
import com.byterexx.document.common.utils.DateUtils;

import java.util.Date;

public class DateTimeToConverter extends StdConverter <Date, String>{

    public String convert(Date date) {
        return DateUtils.format(date, AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS, AppConstants.CST);
    }
}
