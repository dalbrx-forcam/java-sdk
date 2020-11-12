////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class OperationSpecificationEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for target workplace. */
    public static String TARGET_WORKPLACE = "targetWorkplace";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should target workplace be embedded? */
    private boolean mTargetWorkplace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if target workplace should be embedded.
     *
     * @param targetWorkplace Should target workplace be embedded?
     * @return The OperationSpecificationEmbed object with the new value.
     */
    public OperationSpecificationEmbed targetWorkplace(boolean targetWorkplace) {
        mTargetWorkplace = targetWorkplace;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isTargetWorkplace()) {
            builder.append(OperationSpecificationEmbed.TARGET_WORKPLACE);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isTargetWorkplace() {
        return mTargetWorkplace;
    }
}