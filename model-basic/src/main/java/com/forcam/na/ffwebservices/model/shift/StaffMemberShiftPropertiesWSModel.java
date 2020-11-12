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
 * Properties WS model for a staff member shift.
 */
@ApiModel(value = "staffMemberShiftProperties")
@JsonPropertyOrder({ "id", "staffMemberId", "shift", "shiftTypeId" })
public class StaffMemberShiftPropertiesWSModel extends CreateStaffMemberShiftPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Shift unique id. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the personnel shift", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }
}