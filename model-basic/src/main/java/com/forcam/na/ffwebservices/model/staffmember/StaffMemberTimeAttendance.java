////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-Nov-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

/**
 * Enum for person/staff member time attendance state.
 */
public enum StaffMemberTimeAttendance {

    COMING(1),

    GOING(2);

    /** The code. */
    private final long mCode;

    /**
     * Creates a new time attendance status with a code.
     *
     * @param code The code.
     */
    StaffMemberTimeAttendance(long code) {
        mCode = code;
    }

    /**
     * Returns the code.
     *
     * @return The code.
     */
    public long getCode() {
        return mCode;
    }

    /**
     * Returns the time attendance status by code.
     *
     * @param code The code.
     * @return The time attendance status.
     */
    public static StaffMemberTimeAttendance getByCode(long code) {
        switch ((int) code) {
            case 1:
                return COMING;
            case 2:
                return GOING;
        }

        throw new IllegalArgumentException();
    }

}
