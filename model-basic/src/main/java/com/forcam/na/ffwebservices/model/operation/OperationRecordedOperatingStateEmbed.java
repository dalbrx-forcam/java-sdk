////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class OperationRecordedOperatingStateEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for operating state. */
    public static String OPERATING_STATE = "operatingState";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should operating state be embedded? */
    private boolean mOperatingState;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if operating state should be embedded.
     *
     * @param operatingState Should operating state be embedded?
     * @return The OperationRecordedOperatingStateEmbed object with the new value.
     */
    public OperationRecordedOperatingStateEmbed operatingState(boolean operatingState) {
        mOperatingState = operatingState;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isOperatingState()) {
            builder.append(OperationRecordedOperatingStateEmbed.OPERATING_STATE);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isOperatingState() {
        return mOperatingState;
    }
}