////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 14.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Properties of the staff members scheduled working times.
 */
@ApiModel(value = "staffMembersScheduledWorkingTimesProperties")
@JsonPropertyOrder({ "elements" })
public class StaffMembersScheduledWorkingTimesPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The list of scheduled working times. */
    private List<ScheduledWorkingTimeWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of scheduled working times.
     *
     * @param elements List of scheduled working time WS models.
     */
    @ApiModelProperty(position = 0)
    public void setElements(List<ScheduledWorkingTimeWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of scheduled working times.
     *
     * @return The list of scheduled working time WS models.
     */
    public List<ScheduledWorkingTimeWSModel> getElements() {
        return mElements;
    }
}