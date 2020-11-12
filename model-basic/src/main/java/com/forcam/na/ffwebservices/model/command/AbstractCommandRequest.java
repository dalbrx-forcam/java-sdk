////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 16.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command;

/**
 * An abstract command request.
 */
public abstract class AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should the request be sent asynchronously? */
    private boolean mAsync = false;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isAsync() {
        return mAsync;
    }

    public void setAsync(boolean async) {
        mAsync = async;
    }
}