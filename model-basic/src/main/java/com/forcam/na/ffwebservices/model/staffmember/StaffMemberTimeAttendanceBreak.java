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
public enum StaffMemberTimeAttendanceBreak {

    BREAK_START(1),

    BREAK_END(2);

    /** The code. */
    private final long mCode;

    /**
     * Creates a new time attendance break status with a code.
     *
     * @param code The code.
     */
    StaffMemberTimeAttendanceBreak(long code) {
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
     * Returns the time attendance break status by code.
     *
     * @param code The code.
     * @return The time attendance status.
     */
    public static StaffMemberTimeAttendanceBreak getByCode(long code) {
        switch ((int) code) {
            case 1:
                return BREAK_START;
            case 2:
                return BREAK_END;
        }

        throw new IllegalArgumentException();
    }

}
