////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 08.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

/**
 * An Enum to map with the state of a ticket.
 */
public enum TicketState {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    NEW(10),

    IN_PROGRESS(20),

    DONE(30),

    CONFIRMED(40),

    REOPENED(50);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Value of state. */
    private final int mCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * initialises the value of the state.
     *
     * @param code Status-Wert
     */
    TicketState(int code) {
        mCode = code;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Return the id of the state
     *
     * @return id of the state
     */
    public int getCode() {
        return mCode;
    }

    public static TicketState valueOf(int code) throws IllegalArgumentException {
        for (TicketState state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown ticket state code:" + code);
    }
}
