////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 8/1/2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.shift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * WS model to create a shift.
 */
@ApiModel(value = "createWorkplaceShiftProperties")
@JsonPropertyOrder({ "workplaceId", "shift", "shiftTypeId", "isWorkingShift" })
public class CreateWorkplaceShiftPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace unique id. */
    private String mWorkplaceId;
    /** The shift model */
    private ShiftWSModel mShift = new ShiftWSModel();
    /** Shift type unique id. */
    private String mShiftTypeId;
    /** Is it a working shift? */
    private Boolean mIsWorkingShift;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the workplace", position = 1)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
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

    @ApiModelProperty(value = "Boolean to indicate the shift as working shift or nonworking shift", position = 4)
    public void setIsWorkingShift(Boolean isWorkingShift) {
        mIsWorkingShift = isWorkingShift;
    }

    public Boolean isIsWorkingShift() {
        return mIsWorkingShift;
    }
}