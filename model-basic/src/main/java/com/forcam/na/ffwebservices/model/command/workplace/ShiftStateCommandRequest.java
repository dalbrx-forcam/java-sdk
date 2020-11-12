////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 25.06.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.workplace;

import com.forcam.na.ffwebservices.model.command.AbstractCommandRequest;

import java.util.Date;

/**
 * An shift state command model.
 */
public class ShiftStateCommandRequest extends AbstractCommandRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mWorkplaceId;

    private String mShiftId;

    private String mShiftStateId;

    private String mShiftTypeId;

    private Date mAssociatedDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new shift state command request.
     *
     * @param associatedDate The associated day of the shift.
     * @param shiftId        The shift id.
     * @param shiftStateId   The shift state id.
     * @param shiftTypeId    The shift type id.
     * @param workplaceId    The workplace id.
     */
    public ShiftStateCommandRequest(String workplaceId, String shiftId, String shiftStateId, String shiftTypeId, Date associatedDate) {
        mWorkplaceId = workplaceId;
        mShiftId = shiftId;
        mShiftStateId = shiftStateId;
        mShiftTypeId = shiftTypeId;
        mAssociatedDate = associatedDate;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getAssociatedDate() {
        return mAssociatedDate;
    }

    public String getShiftTypeId() {
        return mShiftTypeId;
    }

    public String getShiftStateId() {
        return mShiftStateId;
    }

    public String getShiftId() {
        return mShiftId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }
}
