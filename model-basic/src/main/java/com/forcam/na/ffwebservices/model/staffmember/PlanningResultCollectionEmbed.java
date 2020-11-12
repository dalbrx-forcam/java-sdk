////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class PlanningResultCollectionEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for staff member. */
    public static final String STAFF_MEMBER = "staffMember";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should staff member be embedded? */
    private boolean mStaffMember;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if staff member should be embedded.
     *
     * @param staffMember Should staff member be embedded?
     * @return The planning result collection embed object with the new value.
     */
    public PlanningResultCollectionEmbed staffMember(boolean staffMember) {
        mStaffMember = staffMember;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isStaffMember()) {
            builder.append(STAFF_MEMBER);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isStaffMember() {
        return mStaffMember;
    }
}