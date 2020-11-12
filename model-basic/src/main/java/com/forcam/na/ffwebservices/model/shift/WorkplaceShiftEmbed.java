////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shift;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class WorkplaceShiftEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for ERP context. */
    public static String SHIFT_TYPE = "shiftType";

    /** Constant string for machine. */
    public static String WORKPLACE = "workplace";

    /** Should ERP context be embedded? */
    private boolean mShiftType;

    /** Should machine be embedded? */
    private boolean mWorkplace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if workplace should be embedded.
     *
     * @param workplace Should workplace be embedded?
     * @return The ShiftEmbed object with the new value.
     */
    public WorkplaceShiftEmbed workplace(boolean workplace) {
        mWorkplace = workplace;
        return this;
    }

    /**
     * Determines if shift type should be embedded.
     *
     * @param shiftType Should shift type be embedded?
     * @return The ShiftEmbed object with the new value.
     */
    public WorkplaceShiftEmbed shiftType(boolean shiftType) {
        mShiftType = shiftType;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isShiftType()) {
            embeds.add(SHIFT_TYPE);
        }

        if (this.isWorkplace()) {
            embeds.add(WORKPLACE);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isShiftType() {
        return mShiftType;
    }

    public boolean isWorkplace() {
        return mWorkplace;
    }
}