////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 15.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplacegroup;

/**
 * The type of a workplace group.
 */
public enum WorkplaceGroupType {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    CAPACITY_GROUP(1),

    PRODUCTION_LINE(4);

    /** The code. */
    private long mCode;

    /**
     * Creates a new workplace group type with a code.
     *
     * @param code The code.
     */
    WorkplaceGroupType(long code) {
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
     * Returns the workplace group type by code.
     *
     * @param code The code.
     * @return The workplace group type.
     */
    public static WorkplaceGroupType getByCode(long code) {
        switch ((int) code) {
            case 1:
                return CAPACITY_GROUP;
            case 4:
                return PRODUCTION_LINE;
        }

        throw new IllegalArgumentException();
    }

    public static String getNameByCode(long code) {
        return getByCode(code).name();
    }
}