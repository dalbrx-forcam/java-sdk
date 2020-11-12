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

import java.util.ArrayList;
import java.util.List;

/**
 * Properties of the staff member scheduled working times.
 */
@ApiModel(value = "staffMemberScheduledWorkingTimesProperties")
@JsonPropertyOrder({ "elements" })
public class StaffMemberScheduledWorkingTimesPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member scheduled working time period. */
    private List<TimePeriodWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of staff member scheduled working time period.
     *
     * @param elements List of time period WS models.
     */
    @ApiModelProperty(position = 0)
    public void setElements(List<TimePeriodWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of staff member scheduled working time period.
     *
     * @return The list of time period WS models.
     */
    public List<TimePeriodWSModel> getElements() {
        return mElements;
    }
}