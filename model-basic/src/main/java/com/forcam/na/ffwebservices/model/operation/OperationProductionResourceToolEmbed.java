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
public class OperationProductionResourceToolEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mDescription;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The OperationProductionResourceToolEmbed object with the new value.
     */
    public OperationProductionResourceToolEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isDescription()) {
            builder.append(OperationProductionResourceToolEmbed.DESCRIPTION);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isDescription() {
        return mDescription;
    }
}