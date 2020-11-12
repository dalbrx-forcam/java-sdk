////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.shift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.ZonedTimePeriodWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * WS model for shift break.
 */
@ApiModel(value = "shiftBreak")
@JsonPropertyOrder({ "timePeriod" })
public class ShiftBreakWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Shift break time period. */
    private ZonedTimePeriodWSModel mTimePeriod = new ZonedTimePeriodWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Time period of the shift break", position = 0)
    public void setTimePeriod(ZonedTimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    public ZonedTimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }
}