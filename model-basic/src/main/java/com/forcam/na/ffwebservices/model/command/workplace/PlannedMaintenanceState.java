////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.workplace;

/**
 * Planned maintenance state.
 */
public enum PlannedMaintenanceState {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    PLANNED_MAINTENANCE(1),

    NO_PLANNED_MAINTENANCE(2);

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    private final int mCode;

    PlannedMaintenanceState(int code) {
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
     * Returns the personnel status by code.
     *
     * @param code The code.
     * @return The personnel status.
     */
    public static PlannedMaintenanceState getByCode(long code) {
        switch ((int) code) {
            case 1:
                return PLANNED_MAINTENANCE;
            case 2:
                return NO_PLANNED_MAINTENANCE;
        }

        throw new IllegalArgumentException();
    }
}
