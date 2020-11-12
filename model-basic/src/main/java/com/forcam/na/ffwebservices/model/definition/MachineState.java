////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 15.08.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

/**
 * Defines the available machine states in the API.
 */
public enum MachineState {

    DOWNTIME(1),

    PRODUCTION(2),

    SETUP(3);

    /** The code. */
    private final long mCode;

    /**
     * Creates a new machine status with a code.
     *
     * @param code The code.
     */
    MachineState(long code) {
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
     * Returns the machine status by code.
     *
     * @param code The code.
     * @return The machine status.
     */
    public static MachineState getByCode(long code) {
        switch ((int) code) {
            case 1:
                return DOWNTIME;
            case 2:
                return PRODUCTION;
            case 3:
                return SETUP;
        }

        throw new IllegalArgumentException();
    }
}
