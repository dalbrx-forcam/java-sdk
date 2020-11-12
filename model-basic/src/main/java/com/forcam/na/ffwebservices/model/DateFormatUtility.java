////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/9/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Date format utility for the webservice.
 */
public final class DateFormatUtility {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Simple date formatter to parse dates. */
    public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /** Standard formatter for date time (yyyy-MM-dd HH:mm:ss.SSS). */
    public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss:SSS");

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Format the current date to UTC timestamp with formatter {@link DateFormatUtility#SIMPLE_DATE_FORMAT}.
     *
     * @param date Input date.
     * @return String representation of date in UTC.
     */
    public static String formatAsUTC(Date date) {
        final TimeZone central = TimeZone.getTimeZone("UTC");
        SIMPLE_DATE_FORMAT.setTimeZone(central);
        return SIMPLE_DATE_FORMAT.format(date);
    }

    /**
     * Format a date with formatter {@link DateFormatUtility#DATETIME_FORMAT}.
     *
     * @param date The date.
     * @return Formatted timestamp.
     */
    public static String formatLogging(Date date) {
        return Optional
                .ofNullable(date)
                .map(d -> "[UTC " + d.getTime() + ", " + DATETIME_FORMAT.format(d.getTime()) + "]")
                .orElse(null);
    }
}
