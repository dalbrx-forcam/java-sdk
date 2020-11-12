////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 14.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Model for scheduled working times of a staff member.
 */
@ApiModel(value = "scheduledWorkingTime")
@JsonPropertyOrder({ "staffMemberId", "elements" })
public class ScheduledWorkingTimeWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** List of scheduled working time periods. */
    private List<TimePeriodWSModel> mScheduledWorkingTimes;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    @ApiModelProperty(value = "UUID of the staff member", position = 0)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public List<TimePeriodWSModel> getScheduledWorkingTimes() {
        return mScheduledWorkingTimes;
    }

    @ApiModelProperty(value = "Array of periods from the start timestamp to the end timestamp of an uninterrupted segment of the scheduled working time", position = 1)
    public void setScheduledWorkingTimes(List<TimePeriodWSModel> scheduledWorkingTimes) {
        mScheduledWorkingTimes = scheduledWorkingTimes;
    }
}