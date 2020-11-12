////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 16.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Production order scheduled dates.
 */
@ApiModel("productionOrderScheduledDates")
@JsonPropertyOrder({ "operationId", "scheduledDates" })
public class ProductionOrderScheduledDatesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** The operation scheduled dates properties. */
    private OperationScheduledDatesPropertiesWSModel mScheduledDates = new OperationScheduledDatesPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    @ApiModelProperty(position = 0, required = true)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the scheduled dates.
     *
     * @param scheduledDates The operation scheduled dates properties.
     */
    @ApiModelProperty(position = 1, required = true)
    public void setScheduledDates(OperationScheduledDatesPropertiesWSModel scheduledDates) {
        mScheduledDates = scheduledDates;
    }

    /**
     * Provides the schedules dates.
     *
     * @return The operation scheduled dates properties.
     */
    public OperationScheduledDatesPropertiesWSModel getScheduledDates() {
        return mScheduledDates;
    }
}