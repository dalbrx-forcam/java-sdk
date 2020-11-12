////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shift;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class StaffMemberShiftEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for shift type. */
    public static String SHIFT_TYPE = "shiftType";

    /** Constant string for staff member. */
    public static String STAFF_MEMBER = "staffMember";

    /** Should shift type be embedded? */
    private boolean mShiftType;

    /** Should staff member be embedded? */
    private boolean mStaffMember;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if staff member should be embedded.
     *
     * @param staffMember Should staff member be embedded?
     * @return The ShiftEmbed object with the new value.
     */
    public StaffMemberShiftEmbed staffMember(boolean staffMember) {
        mStaffMember = staffMember;
        return this;
    }

    /**
     * Determines if shift type should be embedded.
     *
     * @param shiftType Should shift type be embedded?
     * @return The ShiftEmbed object with the new value.
     */
    public StaffMemberShiftEmbed shiftType(boolean shiftType) {
        mShiftType = shiftType;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isShiftType()) {
            embeds.add(SHIFT_TYPE);
        }

        if (this.isStaffMember()) {
            embeds.add(STAFF_MEMBER);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isShiftType() {
        return mShiftType;
    }

    public boolean isStaffMember() {
        return mStaffMember;
    }
}