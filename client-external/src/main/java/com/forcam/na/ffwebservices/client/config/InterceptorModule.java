////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.config;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

import java.util.Collection;

/**
 * The interceptor module.
 */
@Module
public class InterceptorModule {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of interceptors. */
    private final Collection<Interceptor> mInterceptors;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public InterceptorModule(Collection<Interceptor> interceptors) {
        mInterceptors = interceptors;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Provides
    public Collection<Interceptor> interceptors() {
        return mInterceptors;
    }
}