////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoperatingstate;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class RecordedOperatingStateEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for operating state. */
    public static String OPERATING_STATE = "operatingState";

    /** Constant string for operating state details. */
    public static String OPERATING_STATE_DETAILS = "operatingStateDetails";

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
     * @return The RecordedOperatingStateEmbed object with the new value.
     */
    public RecordedOperatingStateEmbed operatingState(boolean operatingState) {
        mOperatingState = operatingState;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isOperatingState()) {
            builder.append(RecordedOperatingStateEmbed.OPERATING_STATE);
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