////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class OperatingStateEmbed extends StatusDefinitionEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for operating state class. */
    public static String OPERATING_STATE_CLASS = "operatingStateClass";

    /** Constant string for workplace state. */
    public static String WORKPLACE_STATE = "workplaceState";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should operating state class be embedded? */
    private boolean mOperatingStateClass;

    /** Should workplace state be embedded? */
    private boolean mWorkplaceState;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if workplace state should be embedded.
     *
     * @param workplaceState Should workplace state be embedded?
     * @return The OperatingStateEmbed object with the new value.
     */
    public OperatingStateEmbed workplaceState(boolean workplaceState) {
        mWorkplaceState = workplaceState;
        return this;
    }

    /**
     * Determines if operating state class should be embedded.
     *
     * @param operatingStateClass Should operating state class be embedded?
     * @return The OperatingStateEmbed object with the new value.
     */
    public OperatingStateEmbed operatingStateClass(boolean operatingStateClass) {
        mOperatingStateClass = operatingStateClass;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isWorkplaceState()) {
            builder.append(OperatingStateEmbed.WORKPLACE_STATE);
            builder.append(",");
        }

        if (this.isOperatingStateClass()) {
            builder.append(OperatingStateEmbed.OPERATING_STATE_CLASS);
            builder.append(",");
        }

        builder.append(super.toString());

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isOperatingStateClass() {
        return mOperatingStateClass;
    }

    public boolean isWorkplaceState() {
        return mWorkplaceState;
    }
}