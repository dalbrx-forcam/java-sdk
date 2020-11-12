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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Properties WS model for shift.
 */
@XmlRootElement(name = "workplaceShiftProperties")
@ApiModel(value = "workplaceShiftProperties")
@JsonPropertyOrder({ "id", "workplaceId", "shift", "shiftTypeId", "isWorkingShift" })
public class WorkplaceShiftPropertiesWSModel extends CreateWorkplaceShiftPropertiesWSModel {

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

    @ApiModelProperty(value = "UUID of the workplace shift", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }
}