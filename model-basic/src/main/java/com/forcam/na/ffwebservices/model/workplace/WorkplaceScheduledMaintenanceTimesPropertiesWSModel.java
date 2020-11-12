////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 10.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Workplace scheduled maintenance times properties model.
 */
@JsonPropertyOrder({ "elements" })
public class WorkplaceScheduledMaintenanceTimesPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace scheduled maintenance times elements. */
    private List<TimePeriodWSModel> mElements;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link WorkplaceScheduledMaintenanceTimesPropertiesWSModel#mElements}.
     *
     * @param elements Workplace scheduled maintenance times elements.
     */
    @ApiModelProperty(value = "Array of time periods, i.e. the periods from the start date to th end date of a scheduled maintenance", position = 0)
    public void setElements(List<TimePeriodWSModel> elements) {
        mElements = elements;
    }

    /**
     * Getter for {@link WorkplaceScheduledMaintenanceTimesPropertiesWSModel#mElements}.
     *
     * @return Workplace scheduled maintenance times elements.
     */
    public List<TimePeriodWSModel> getElements() {
        return mElements;
    }
}