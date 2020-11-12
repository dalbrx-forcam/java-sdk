////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Staff member activity record model.
 */
@ApiModel(value = "staffMemberLoginPeriodRecord")
@JsonPropertyOrder({ "workplaceId", "operationId", "operationPhase", "timePeriod", "proportion" })
public class StaffMemberLoginPeriodRecordWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace ID. */
    private String mWorkplaceId;

    /** The operation ID. */
    private String mOperationId;

    /** The identifier of the operation phase. */
    private String mOperationPhase;

    /** Time period from start date to end date of the activity. */
    private TimePeriodWSModel mTimePeriod;

    /** Proportion of total registered personnel capacity, i.e. 1 / n where n is the number of operations which are as-signed to the person. */
    private double mProportion;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace ID.
     *
     * @return The workplace ID.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    @ApiModelProperty(value = "UUID of the workplace", position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
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
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    @ApiModelProperty(value = "UUID of the operation", position = 1)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Provides the operation phase.
     *
     * @return The operation phase.
     */
    public String getOperationPhase() {
        return mOperationPhase;
    }

    /**
     * Sets the operation phase.
     *
     * @param operationPhase The operation phase.
     */
    @ApiModelProperty(value = "ID of the operation phase", position = 2)
    public void setOperationPhase(String operationPhase) {
        mOperationPhase = operationPhase;
    }

    /**
     * Provides the time period.
     *
     * @return The time period.
     */
    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    /**
     * Sets the time period.
     *
     * @param timePeriod The time period.
     */
    @ApiModelProperty(value = "Time period from the start timestamp to the end timestamp of the activity", position = 3)
    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    /**
     * Provides the proportion.
     *
     * @return The proportion.
     */
    public double getProportion() {
        return mProportion;
    }

    /**
     * Sets the proportion.
     *
     * @param proportion The proportion.
     */
    @ApiModelProperty(value = "Proportion of the personnel capacity assigned to the respective operation", position = 4)
    public void setProportion(double proportion) {
        mProportion = proportion;
    }

    @Override
    public Date getPaginationDate() {
        return mTimePeriod.getStartDate();
    }
}