////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.operation;

import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;

/**
 * Generic command request.
 */
public class CommandRequest<T extends AbstractCommandDataWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private boolean mAsync;

    private T mCommand;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CommandRequest(T command) {
        mCommand = command;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isAsync() {
        return mAsync;
    }

    public void setAsync(boolean async) {
        mAsync = async;
    }

    public T getCommand() {
        return mCommand;
    }

    public void setCommand(T command) {
        mCommand = command;
    }

}
