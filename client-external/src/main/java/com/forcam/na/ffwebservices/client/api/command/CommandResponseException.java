////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 23.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.command;

/**
 * Exception class for command responses.
 */
public class CommandResponseException extends Exception {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Constructs a new command response exception with the specified detail message.
     *
     * @param message The exception message.
     */
    public CommandResponseException(String message) {
        super(message);
    }
}