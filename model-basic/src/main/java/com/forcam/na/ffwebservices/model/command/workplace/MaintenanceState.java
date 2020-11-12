////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.workplace;

/**
 * Maintenance state.
 */
public enum MaintenanceState {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    /** Maintenance status code: no maintenance */
    NO_MAINTENANCE(1),

    /** Maintenance status code: waiting for maintenance */
    WAITING_FOR_MAINTENANCE(2),

    /** Maintenance status code: in maintenance */
    MAINTENANCE(3),

    /** Maintenance status code: maintenance interrupted */
    MAINTENANCE_INTERRUPTED(4);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private final int mCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    MaintenanceState(int code) {
        mCode = code;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

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
    public static MaintenanceState getByCode(long code) {
        switch ((int) code) {
            case 1:
                return NO_MAINTENANCE;
            case 2:
                return WAITING_FOR_MAINTENANCE;
            case 3:
                return MAINTENANCE;
            case 4:
                return MAINTENANCE_INTERRUPTED;
        }

        throw new IllegalArgumentException();
    }

}
