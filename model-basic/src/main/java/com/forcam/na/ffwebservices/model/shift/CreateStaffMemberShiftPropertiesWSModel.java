////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.shift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * WS model to create a staff member shift.
 */
@ApiModel(value = "createStaffMemberShiftProperties")
@JsonPropertyOrder({ "staffMemberId", "shift", "shiftTypeId" })
public class CreateStaffMemberShiftPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Staff member ID. */
    private String mStaffMemberId;

    /** The shift model */
    private ShiftWSModel mShift = new ShiftWSModel();

    /** Shift type unique id. */
    private String mShiftTypeId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the staff member", position = 1)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    @ApiModelProperty(value = "The respective shift including its breaks", position = 2)
    public void setShift(ShiftWSModel shift) {
        mShift = shift;
    }

    public ShiftWSModel getShift() {
        return mShift;
    }

    @ApiModelProperty(value = "UUID of the shift type", required = true, position = 3)
    public void setShiftTypeId(String shiftTypeId) {
        mShiftTypeId = shiftTypeId;
    }

    public String getShiftTypeId() {
        return mShiftTypeId;
    }
}