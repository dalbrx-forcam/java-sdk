////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.07.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Contains the properties of the scheduled dates of an operation.
 */
@ApiModel(value = "operationScheduledDatesProperties")
@JsonPropertyOrder({ "earliestStartDate", "latestStartDate", "earliestEndDate", "latestEndDate", "scheduledStartDate", "scheduledEndDate" })
public class OperationScheduledDatesPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The earliest start date. */
    private Date mEarliestStartDate;

    /** The latest start date. */
    private Date mLatestStartDate;

    /** The earliest end date. */
    private Date mEarliestEndDate;

    /** The latest end date. */
    private Date mLatestEndDate;

    /** The scheduled start date. */
    private Date mScheduledStartDate;

    /** The scheduled end date. */
    private Date mScheduledEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Earliest start timestamp determined by lead time scheduling", position = 0, required = true)
    public void setEarliestStartDate(Date earliestStartDate) {
        mEarliestStartDate = earliestStartDate;
    }

    public Date getEarliestStartDate() {
        return mEarliestStartDate;
    }

    @ApiModelProperty(value = "Latest start timestamp determined by lead time scheduling", position = 1, required = true)
    public void setLatestStartDate(Date latestStartDate) {
        mLatestStartDate = latestStartDate;
    }

    public Date getLatestStartDate() {
        return mLatestStartDate;
    }

    @ApiModelProperty(value = "Earliest end timestamp determined by lead time scheduling", position = 2, required = true)
    public void setEarliestEndDate(Date earliestEndDate) {
        mEarliestEndDate = earliestEndDate;
    }

    public Date getEarliestEndDate() {
        return mEarliestEndDate;
    }

    @ApiModelProperty(value = "Latest end time determined by lead time scheduling", position = 3, required = true)
    public void setLatestEndDate(Date latestEndDate) {
        mLatestEndDate = latestEndDate;
    }

    public Date getLatestEndDate() {
        return mLatestEndDate;
    }

    @ApiModelProperty(value = "Scheduled start timestamp determined by lead time scheduling", position = 4, required = true)
    public void setScheduledStartDate(Date scheduledStartDate) {
        mScheduledStartDate = scheduledStartDate;
    }

    public Date getScheduledStartDate() {
        return mScheduledStartDate;
    }

    @ApiModelProperty(value = "Scheduled end timestamp determined by lead time scheduling", position = 5, required = true)
    public void setScheduledEndDate(Date scheduledEndDate) {
        mScheduledEndDate = scheduledEndDate;
    }

    public Date getScheduledEndDate() {
        return mScheduledEndDate;
    }
}