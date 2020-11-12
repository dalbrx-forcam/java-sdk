////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 24.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.config;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Request converter factory for data format java.util.Date.
 */
public class RequestConverterFactory extends Converter.Factory {

    public static RequestConverterFactory create() {
        return new RequestConverterFactory();
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        boolean isQueryParam = false;
        for (final Annotation annotation : annotations) {
            if (annotation
                .annotationType()
                .equals(Query.class)) {
                isQueryParam = true;
            }
        }
        if (type.equals(Date.class) && isQueryParam) {
            return new DateStringConverter();
        }
        return super.stringConverter(type, annotations, retrofit);
    }
}
