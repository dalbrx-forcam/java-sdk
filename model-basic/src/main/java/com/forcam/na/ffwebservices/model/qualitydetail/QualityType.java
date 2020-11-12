////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.qualitydetail;

/**
 *
 */
public enum QualityType {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    YIELD(1),

    SCRAP(2),

    REWORK(3);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private long mCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param code The internal code.
     */
    QualityType(long code) {
        mCode = code;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public long getCode() {
        return mCode;
    }

    public static QualityType getByCode(long code) {
        switch ((int) code) {
            case 1:
                return YIELD;
            case 2:
                return SCRAP;
            case 3:
                return REWORK;
        }

        throw new IllegalArgumentException();
    }

}
