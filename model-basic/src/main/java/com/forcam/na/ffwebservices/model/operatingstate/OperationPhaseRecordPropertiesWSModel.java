////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 2/1/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Operation phase record properties model for webservice.
 */
@ApiModel(value = "recordedOperationPhase")
@JsonPropertyOrder({ "workplaceId", "operationId", "operationPhaseId", "startDate", "endDate" })
public class OperationPhaseRecordPropertiesWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID of the workplace the operation has been executed during the phases SETUP and PROCESSING if exists. */
    private String mWorkplaceId;

    /** The operation ID. */
    private String mOperationId;

    /** ID of the operation phase. */
    private OperationPhase mOperationPhaseId;

    /** Start date of the operation phase. */
    private Date mStartDate;

    /** End date of the operation phase if exists. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for {@link OperationPhaseRecordPropertiesWSModel#mWorkplaceId}.
     *
     * @param workplaceId UUID of the workplace the operation has been executed during the phases SETUP and PROCESSING if exists.
     */
    @ApiModelProperty(value = "UUID of the workplace at which the operation was performed during the SETUP and PROCESSING phases, if these exist", position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    /**
     * Getter for {@link OperationPhaseRecordPropertiesWSModel#mWorkplaceId}.
     *
     * @return UUID of the workplace the operation has been executed during the phases SETUP and PROCESSING if exists.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    @ApiModelProperty(value = "UUID of the respective operation", position = 1)
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
     * Setter for {@link OperationPhaseRecordPropertiesWSModel#mOperationPhaseId}.
     *
     * @param operationPhaseId Name of the operation phase.
     */
    @ApiModelProperty(value = "ID of the operation phase", position = 2)
    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    /**
     * Getter for {@link OperationPhaseRecordPropertiesWSModel#mOperationPhaseId}.
     *
     * @return Name of the operation phase.
     */
    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    /**
     * Setter for {@link OperationPhaseRecordPropertiesWSModel#mStartDate}.
     *
     * @param startDate Start date of the operation phase.
     */
    @ApiModelProperty(value = "The start date of the operation phase", position = 3)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Getter for {@link OperationPhaseRecordPropertiesWSModel#mStartDate}.
     *
     * @return Start date of the operation phase.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Setter for {@link OperationPhaseRecordPropertiesWSModel#mEndDate}.
     *
     * @param endDate End date of the operation phase if exists.
     */
    @ApiModelProperty(value = "The end date of the operation phase", position = 4)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Getter for {@link OperationPhaseRecordPropertiesWSModel#mEndDate}.
     *
     * @return End date of the operation phase if exists.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    @Override
    public Date getPaginationDate() {
        return mStartDate;
    }
}