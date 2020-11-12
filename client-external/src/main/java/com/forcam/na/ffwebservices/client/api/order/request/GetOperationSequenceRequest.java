////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 07.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameters to get production order operation sequence.
 */
public class GetOperationSequenceRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The production order number. */
    private String mProductionOrderId;

    /** The production order number. */
    private String mOperationNumber;

    /** The production order split. */
    private String mOperationSplit;

    /** The material number. */
    private String mMaterialNumber;

    /** The ID of the ERP context. */
    private String mWorkplaceNumber;

    /** The ID of the ERP context. */
    private Boolean mIsPlannable;

    /** The ID of the ERP context. */
    private Boolean mIsDispatched;

    /** The ID of the ERP context. */
    private OperationPhase mOperationPhaseId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with production order ID.
     *
     * @param productionOrderId The production order ID.
     */
    public GetOperationSequenceRequest(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("productionOrderId", mProductionOrderId)
            .append("operationNumber", mOperationNumber)
            .append("materialNumber", mMaterialNumber)
            .append("operationSplit", mOperationSplit)
            .append("workplaceNumber", mWorkplaceNumber)
            .append("isPlannable", mIsPlannable)
            .append("isDispatched", mIsDispatched)
            .append("operationPhaseId", mOperationPhaseId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
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

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    public Boolean getPlannable() {
        return mIsPlannable;
    }

    public void setPlannable(Boolean plannable) {
        mIsPlannable = plannable;
    }

    public Boolean getDispatched() {
        return mIsDispatched;
    }

    public void setDispatched(Boolean dispatched) {
        mIsDispatched = dispatched;
    }

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }
}