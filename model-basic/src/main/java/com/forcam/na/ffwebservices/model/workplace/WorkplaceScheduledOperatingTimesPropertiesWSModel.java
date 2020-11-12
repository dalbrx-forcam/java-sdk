////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/21/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Workplace scheduled operating times properties model.
 */
@JsonPropertyOrder({ "elements" })
public class WorkplaceScheduledOperatingTimesPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace scheduled operating times elements. */
    private List<TimePeriodWSModel> mElements;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link WorkplaceScheduledOperatingTimesPropertiesWSModel#mElements}.
     *
     * @param elements Workplace scheduled operating times elements.
     */
    @ApiModelProperty(value = "Array of time periods from the start date to the end date of an uninterrupted segment of the scheduled operating time", position = 0)
    public void setElements(List<TimePeriodWSModel> elements) {
        mElements = elements;
    }

    /**
     * Getter for {@link WorkplaceScheduledOperatingTimesPropertiesWSModel#mElements}.
     *
     * @return Workplace scheduled operating times elements.
     */
    public List<TimePeriodWSModel> getElements() {
        return mElements;
    }
}