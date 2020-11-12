////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 16.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The production order scheduling result properties.
 */
@JsonPropertyOrder({ "scheduledStartDate", "scheduledEndDate", "elements" })
public class ProductionOrderSchedulingResultPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The scheduled start date. */
    private Date mScheduledStartDate;

    /** The scheduled end date. */
    private Date mScheduledEndDate;

    /** List of production order scheduled dates. */
    private List<ProductionOrderScheduledDatesWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the scheduled start date.
     *
     * @param scheduledStartDate The scheduled start date.
     */
    @ApiModelProperty(position = 0, required = true)
    public void setScheduledStartDate(Date scheduledStartDate) {
        mScheduledStartDate = scheduledStartDate;
    }

    /**
     * Provides the scheduled start date.
     *
     * @return The scheduled start date.
     */
    public Date getScheduledStartDate() {
        return mScheduledStartDate;
    }

    /**
     * Sets the scheduled end date.
     *
     * @param scheduledEndDate The scheduled end date.
     */
    @ApiModelProperty(position = 1, required = true)
    public void setScheduledEndDate(Date scheduledEndDate) {
        mScheduledEndDate = scheduledEndDate;
    }

    /**
     * Provides the scheduled end date.
     *
     * @return The scheduled end date.
     */
    public Date getScheduledEndDate() {
        return mScheduledEndDate;
    }

    /**
     * Sets the list of production order scheduled dates.
     *
     * @param elements The list of production order scheduled dates.
     */
    @ApiModelProperty(position = 2, required = true)
    public void setElements(List<ProductionOrderScheduledDatesWSModel> elements) {
        mElements = elements;
    }

    /**
     * Provides the list of production order scheduled dates.
     *
     * @return The list of production order scheduled dates.
     */
    public List<ProductionOrderScheduledDatesWSModel> getElements() {
        return mElements;
    }
}