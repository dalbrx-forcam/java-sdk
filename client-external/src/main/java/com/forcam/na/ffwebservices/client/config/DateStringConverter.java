////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.config;

import retrofit2.Converter;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Converts date to string with specified format pattern.
 */
public class DateStringConverter<Date> implements Converter<Date, String> {

    @Override
    public String convert(Date dateToConvert) throws IOException {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return simpleDateFormat.format(dateToConvert);
    }
}
