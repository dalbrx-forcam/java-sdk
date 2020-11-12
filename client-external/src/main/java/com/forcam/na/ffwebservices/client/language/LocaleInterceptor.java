////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 10.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.language;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Locale;

/**
 * {@link Interceptor} which sets the language header based on a locale.
 */
public class LocaleInterceptor implements Interceptor {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The locale of the interceptor. */
    private Locale mLocale;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param locale The locale of the interceptor.
     */
    public LocaleInterceptor(Locale locale) {
        mLocale = locale;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request originalRequest = chain.request();
        final Request requestWithHeaders = originalRequest
            .newBuilder()
            .header("Accept-Language", mLocale.toLanguageTag())
            .build();

        return chain.proceed(requestWithHeaders);

    }

}
