////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 19.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the available workplace states in the API.
 */
public enum WorkplaceState {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    DOWNTIME(1),

    //SETUP(2),

    PRODUCTION(3);

    //TRAINING(4),

    //MAINTENANCE(5),

    //BREAK(6);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkplaceState.class);

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /** The code. */
    private long mCode;

    /**
     * Creates a new operation phase with a code.
     *
     * @param code The code.
     */
    WorkplaceState(long code) {
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
     * Returns the operation phase by code.
     *
     * @param code The code.
     * @return The operation phase.
     */
    public static WorkplaceState getByCode(long code) {
        switch ((int) code) {
            case 1:
                return DOWNTIME;
            case 2:
                //SETUP
                return DOWNTIME;
            case 3:
                return PRODUCTION;
            case 4:
                // TRAINING
                return PRODUCTION;
            case 5:
                //MAINTENANCE
                return DOWNTIME;
            case 6:
                //BREAK
                return DOWNTIME;
            case 7:
                //FREE CAPACITY OUT OF SHIFT
                return DOWNTIME;
            case 8:
                //FREE CAPACITY INSIDE OF SHIFT
                return DOWNTIME;
            case 11:
                //MAINTENANCE INTERRUPTED
                return DOWNTIME;
            case 12:
                //WAITING FOR MAINTENANCE
                return DOWNTIME;
        }

        LOGGER.error("Unknown code {}, returning default value of {}", code, DOWNTIME);
        return DOWNTIME;
    }

    public static String getNameByCode(long code) {
        return getByCode(code).name();
    }
}
