////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 13.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.exception;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class OkHttpRequestDescriptor implements IRequestDescriptor {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mURL;

    private String mMethod;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    private OkHttpRequestDescriptor(String method, String url) {
        mURL = url;
        mMethod = method;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public String getURL() {
        return mURL;
    }

    @Override
    public String getMethod() {
        return mMethod;
    }

    // ------------------------------------------------------------------------
    // static inner class
    // ------------------------------------------------------------------------

    public static class OkHttpRequestDescriptorBuilder {

        // ------------------------------------------------------------------------
        // constructors
        // ------------------------------------------------------------------------
        private OkHttpRequestDescriptorBuilder() {}

        // ------------------------------------------------------------------------
        // methods
        // ------------------------------------------------------------------------
        public static IRequestDescriptor build(Request request) {
            final String method = request.method();
            final HttpUrl url = request.url();
            return new OkHttpRequestDescriptor(method, url.toString());
        }

    }

}
