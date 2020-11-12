////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.callback;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for a callback.
 */
public class CallbackResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the callback. */
    private CallbackPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(CallbackPropertiesWSModel properties) {
        mProperties = properties;
    }

    public CallbackPropertiesWSModel getProperties() {
        return mProperties;
    }
}