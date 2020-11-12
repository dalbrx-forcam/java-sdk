////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.callback;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;

/**
 * The response object for a callback notification.
 */
public class CallbackNotificationResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the callback notification. */
    private CallbackNotificationResponsePropertiesWSModel mProperties;

    /** The embedded callback. */
    private LinkEmbeddedWSModel<CallbackPropertiesWSModel> mCallback;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(CallbackNotificationResponsePropertiesWSModel properties) {
        mProperties = properties;
    }

    public CallbackNotificationResponsePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setCallback(LinkEmbeddedWSModel<CallbackPropertiesWSModel> callback) {
        mCallback = callback;
    }

    public LinkEmbeddedWSModel<CallbackPropertiesWSModel> getCallback() {
        return mCallback;
    }
}