////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/15/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

/**
 * Operation status types.
 */
public enum OperationStatus {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    UNASSIGNED(1),
    DOWNTIME(2),
    SETUP(3),
    PRODUCTION(4),
    TRAINING(5),
    MAINTAINANCE(6),
    BREAK(7),
    FREE_CAPACITY_OUTSIDE_SHIFT(8),
    FREE_CAPACITY_INSIDE_SHIFT(9),
    WITHOUT_PERSONNEL(10),
    FINISHED(11),
    CLOSED(12),
    WAITING_FOR_PROCESSING(13),
    WAITING_FOR_POST_PROCESSING(14),
    MAINTENANCE_INTERRUPTED(15),
    WAITING_FOR_MAINTENANCE(16);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The code. */
    private long mCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new operation status with a code.
     *
     * @param code The code.
     */
    OperationStatus(int code) {
        this.mCode = code;
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
     * Returns the operation status by code.
     *
     * @param code The code.
     * @return The operation status.
     */
    public static OperationStatus getByCode(long code) {
        switch ((int) code) {
            case 1:
                return UNASSIGNED;
            case 2:
                return DOWNTIME;
            case 3:
                return SETUP;
            case 4:
                return PRODUCTION;
            case 5:
                return TRAINING;
            case 6:
                return MAINTAINANCE;
            case 7:
                return BREAK;
            case 8:
                return FREE_CAPACITY_OUTSIDE_SHIFT;
            case 9:
                return FREE_CAPACITY_INSIDE_SHIFT;
            case 10:
                return WITHOUT_PERSONNEL;
            case 11:
                return FINISHED;
            case 12:
                return CLOSED;
            case 13:
                return WAITING_FOR_PROCESSING;
            case 14:
                return WAITING_FOR_POST_PROCESSING;
            case 15:
                return MAINTENANCE_INTERRUPTED;
            case 16:
                return WAITING_FOR_MAINTENANCE;

        }

        throw new IllegalArgumentException();
    }

    /**
     * Get operation status name by code.
     *
     * @param code Status code.
     * @return Operation status.
     */
    public static String getNameByCode(long code) {
        return getByCode(code).name();
    }
}
