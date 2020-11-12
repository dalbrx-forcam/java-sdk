////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.01.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.event;

import java.io.Serializable;

/**
 * Model containing information about a shift change.
 */
public class ShiftChangeEventWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = -4705753262273946607L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mShiftId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getShiftId() {
        return mShiftId;
    }

    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

}
