////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.operation.OperationEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetOperationsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private OperationEmbed mEmbed = new OperationEmbed();

    /** The production order number. */
    private String mProductionOrderNumber;

    /** The production order split. */
    private String mProductionOrderSplit;

    /** The operation number. */
    private String mOperationNumber;

    /** The operation split. */
    private String mOperationSplit;

    /** The material number. */
    private String mMaterialNumber;

    /** The workplace number. */
    private String mWorkplaceNumber;

    /** The workplace id. */
    private String mWorkplaceId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The operation phase id. */
    private OperationPhase mOperationPhaseId;

    /** The production order id. */
    private String mProductionOrderId;
    /** Is operation plannable i.e. operation phase is either {@code RELEASED} or {@code DISPATCHED}. */
    private Boolean mIsPlannable;

    /** {@code true} if a planning result exists for the operation. */
    private Boolean mIsDispatched;

    /** Flag if operation is in progress. */
    private Boolean mIsInProgress;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("productionOrderNumber", mProductionOrderNumber)
            .append("productionOrderSplit", mProductionOrderSplit)
            .append("operationNumber", mOperationNumber)
            .append("operationSplit", mOperationSplit)
            .append("materialNumber", mMaterialNumber)
            .append("workplaceNumber", mWorkplaceNumber)
            .append("workplaceId", mWorkplaceId)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("operationPhaseId", mOperationPhaseId)
            .append("productionOrderId", mProductionOrderId)
            .append("isPlannable", mIsPlannable)
            .append("isDispatched", mIsDispatched)
            .append("isInProgress", mIsInProgress)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getProductionOrderNumber() {
        return mProductionOrderNumber;
    }

    public void setProductionOrderNumber(String productionOrderNumber) {
        mProductionOrderNumber = productionOrderNumber;
    }

    public String getProductionOrderSplit() {
        return mProductionOrderSplit;
    }

    public void setProductionOrderSplit(String productionOrderSplit) {
        mProductionOrderSplit = productionOrderSplit;
    }

    public String getOperationNumber() {
        return mOperationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        mOperationNumber = operationNumber;
    }

    public String getOperationSplit() {
        return mOperationSplit;
    }

    public void setOperationSplit(String operationSplit) {
        mOperationSplit = operationSplit;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    public Boolean isPlannable() {
        return mIsPlannable;
    }

    public void setIsPlannable(Boolean plannable) {
        mIsPlannable = plannable;
    }

    public Boolean isDispatched() {
        return mIsDispatched;
    }

    public void setIsDispatched(Boolean dispatched) {
        mIsDispatched = dispatched;
    }

    public Boolean isInProgress() {
        return mIsInProgress;
    }

    public void setIsInProgress(Boolean inProgress) {
        mIsInProgress = inProgress;
    }
}