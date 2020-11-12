////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 26.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

public enum TicketActivityState {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    NEW(10),

    IN_PROGRESS(20),

    DONE(30);

    /** Value of state. */
    private final int mCode;

    TicketActivityState(int code) {
        mCode = code;
    }

    /**
     * Return the id of the state
     *
     * @return id of the state
     */
    public int getCode() {
        return mCode;
    }

    public static TicketActivityState valueOf(int code) throws IllegalArgumentException {
        for (TicketActivityState state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown ticket state id:" + code);
    }
}
