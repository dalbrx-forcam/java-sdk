////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.Constants;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * The request body for search operations.
 */
@ApiModel(value = "searchOperations")
public class SearchOperationsRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mOperationIds;

    /** The number of the operation. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mOperationNumbers;

    /** The operation split. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mOperationSplits;

    /** The id of the order. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderIds;

    /** The number of the order. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderNumbers;

    /** The order split. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderSplits;

    /** The id of the ERP context. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mERPContextIds;

    /** The id of the target workplace. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mTargetWorkplaceIds;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mTargetWorkplaceNumbers;

    /** The id of the planned workplace. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mPlannedWorkplaceIds;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mPlannedWorkplaceNumbers;

    /** The number of the material. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mMaterialNumbers;

    private Date mStartDate;

    private Date mEndDate;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<OperationPhase> mPhaseIds;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<OperationPhase> mOperationPhaseIds;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mWorkplaceIds;

    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mWorkplaceNumbers;

    private Boolean mIsDispatched;

    private Boolean mIsInProgress;

    private Boolean mIsPlannable;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final SearchOperationsRequestBody that = (SearchOperationsRequestBody) o;

        return new EqualsBuilder()
            .append(mOperationIds, that.mOperationIds)
            .append(mOperationNumbers, that.mOperationNumbers)
            .append(mOperationSplits, that.mOperationSplits)
            .append(mProductionOrderIds, that.mProductionOrderIds)
            .append(mProductionOrderNumbers, that.mProductionOrderNumbers)
            .append(mProductionOrderSplits, that.mProductionOrderSplits)
            .append(mERPContextIds, that.mERPContextIds)
            .append(mTargetWorkplaceIds, that.mTargetWorkplaceIds)
            .append(mTargetWorkplaceNumbers, that.mTargetWorkplaceNumbers)
            .append(mPlannedWorkplaceIds, that.mPlannedWorkplaceIds)
            .append(mPlannedWorkplaceNumbers, that.mPlannedWorkplaceNumbers)
            .append(mMaterialNumbers, that.mMaterialNumbers)
            .append(mStartDate, that.mStartDate)
            .append(mEndDate, that.mEndDate)
            .append(mPhaseIds, that.mPhaseIds)
            .append(mWorkplaceIds, that.mWorkplaceIds)
            .append(mWorkplaceNumbers, that.mWorkplaceNumbers)
            .append(mIsDispatched, that.mIsDispatched)
            .append(mIsInProgress, that.mIsInProgress)
            .append(mIsPlannable, that.mIsPlannable)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mOperationIds)
            .append(mOperationNumbers)
            .append(mOperationSplits)
            .append(mProductionOrderIds)
            .append(mProductionOrderNumbers)
            .append(mProductionOrderSplits)
            .append(mERPContextIds)
            .append(mTargetWorkplaceIds)
            .append(mTargetWorkplaceNumbers)
            .append(mPlannedWorkplaceIds)
            .append(mPlannedWorkplaceNumbers)
            .append(mMaterialNumbers)
            .append(mStartDate)
            .append(mEndDate)
            .append(mPhaseIds)
            .append(mWorkplaceIds)
            .append(mWorkplaceNumbers)
            .append(mIsDispatched)
            .append(mIsInProgress)
            .append(mIsPlannable)
            .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mOperationIds", mOperationIds)
            .append("mOperationNumbers", mOperationNumbers)
            .append("mOperationSplits", mOperationSplits)
            .append("mProductionOrderIds", mProductionOrderIds)
            .append("mProductionOrderNumbers", mProductionOrderNumbers)
            .append("mProductionOrderSplits", mProductionOrderSplits)
            .append("mERPContextIds", mERPContextIds)
            .append("mTargetWorkplaceIds", mTargetWorkplaceIds)
            .append("mTargetWorkplaceNumbers", mTargetWorkplaceNumbers)
            .append("mPlannedWorkplaceIds", mPlannedWorkplaceIds)
            .append("mPlannedWorkplaceNumbers", mPlannedWorkplaceNumbers)
            .append("mMaterialNumbers", mMaterialNumbers)
            .append("mStartDate", DateFormatUtility.formatLogging(mStartDate))
            .append("mEndDate", DateFormatUtility.formatLogging(mEndDate))
            .append("mPhaseIds", mPhaseIds)
            .append("mWorkplaceIds", mWorkplaceIds)
            .append("mWorkplaceNumbers", mWorkplaceNumbers)
            .append("mIsDispatched", mIsDispatched)
            .append("mIsInProgress", mIsInProgress)
            .append("mIsPlannable", mIsPlannable)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "Operations with an earlier end date are excluded. The end date of an operation is either the actual end date or the planned end date or the scheduled end date, depending on the operation phase (default value: beginning of the current week)")
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "Operations with a later start date are excluded. The start date of an operation is either the actual start date or the planned start date or the scheduled start date, depending on the operation phase")
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public List<String> getWorkplaceNumbers() {
        return mWorkplaceNumbers;
    }

    @ApiModelProperty(value = "The number of the workplace at which the operation is or has been executed for operations in the SETUP, PROCESSING, COMPLETED and CLOSED phases.  For operations in the DISPATCHED phase, it is the number of the planned workplace. For operations in the RELEASED phase, it is the number of the target workplace")
    public void setWorkplaceNumbers(List<String> workplaceNumbers) {
        mWorkplaceNumbers = workplaceNumbers;
    }

    public Boolean getIsDispatched() {
        return mIsDispatched;
    }

    @ApiModelProperty(value = "True if the operationPhaseId is 'DISPATCHED'")
    public void setIsDispatched(Boolean dispatched) {
        mIsDispatched = dispatched;
    }

    public Boolean getIsInProgress() {
        return mIsInProgress;
    }

    public void setIsInProgress(Boolean inProgress) {
        mIsInProgress = inProgress;
    }

    public Boolean getIsPlannable() {
        return mIsPlannable;
    }

    @ApiModelProperty(value =
        "“true” or “false”. An operation is plannable if the operation phase is either RELEASED or DISPATCHED and the plannedStartDate is out-side the frozen zone. " +
        "If no frozen zone has been defined, the first condition is sufficient. If there is an operation block, e.g. in joint production, only the leading operation of the operation block is planned. " +
        "This means that all operations for which a block number has been defined and which are not themselves leading operations cannot be planned separately")
    public void setIsPlannable(Boolean isPlannable) {
        mIsPlannable = isPlannable;
    }

    public List<String> getOperationNumbers() {
        return mOperationNumbers;
    }

    @ApiModelProperty(value = "The operation number")
    public void setOperationNumbers(List<String> operationNumbers) {
        mOperationNumbers = operationNumbers;
    }

    public List<String> getProductionOrderIds() {
        return mProductionOrderIds;
    }

    @ApiModelProperty(value = "UUID of an order")
    public void setProductionOrderIds(List<String> productionOrderIds) {
        mProductionOrderIds = productionOrderIds;
    }

    public List<String> getProductionOrderNumbers() {
        return mProductionOrderNumbers;
    }

    @ApiModelProperty(value = "The order number of the corresponding production order")
    public void setProductionOrderNumbers(List<String> productionOrderNumbers) {
        mProductionOrderNumbers = productionOrderNumbers;
    }

    public List<String> getERPContextIds() {
        return mERPContextIds;
    }

    @JsonProperty("erpContextIds")
    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. " +
                              "In SAP ERP, for example, this context is defined by the client, the company code, and the plant")
    public void setERPContextIds(List<String> ERPContextIds) {
        mERPContextIds = ERPContextIds;
    }

    public List<String> getTargetWorkplaceIds() {
        return mTargetWorkplaceIds;
    }

    public void setTargetWorkplaceIds(List<String> targetWorkplaceIds) {
        mTargetWorkplaceIds = targetWorkplaceIds;
    }

    public List<String> getPlannedWorkplaceIds() {
        return mPlannedWorkplaceIds;
    }

    public void setPlannedWorkplaceIds(List<String> plannedWorkplaceIds) {
        mPlannedWorkplaceIds = plannedWorkplaceIds;
    }

    public List<String> getMaterialNumbers() {
        return mMaterialNumbers;
    }

    @ApiModelProperty(value = "The material number of the material produced by the operation")
    public void setMaterialNumbers(List<String> materialNumbers) {
        mMaterialNumbers = materialNumbers;
    }

    @Deprecated
    public List<OperationPhase> getPhaseIds() {
        return mPhaseIds;
    }

    @ApiModelProperty(hidden = true, value = "The identifier of the current operation phase of the operation")
    @Deprecated
    public void setPhaseIds(List<OperationPhase> phaseIds) {
        mPhaseIds = phaseIds;
    }

    public List<OperationPhase> getOperationPhaseIds() {
        return mOperationPhaseIds;
    }

    @ApiModelProperty(value = "The identifier of the current operation phase of the operation")
    public void setOperationPhaseIds(List<OperationPhase> operationPhaseIds) {
        mOperationPhaseIds = operationPhaseIds;
    }

    public List<String> getOperationIds() {
        return mOperationIds;
    }

    public void setOperationIds(List<String> operationIds) {
        mOperationIds = operationIds;
    }

    public List<String> getTargetWorkplaceNumbers() {
        return mTargetWorkplaceNumbers;
    }

    @ApiModelProperty(value = "The number of the target workplace specified by the ERP system")
    public void setTargetWorkplaceNumbers(List<String> targetWorkplaceNumbers) {
        mTargetWorkplaceNumbers = targetWorkplaceNumbers;
    }

    public List<String> getPlannedWorkplaceNumbers() {
        return mPlannedWorkplaceNumbers;
    }

    @ApiModelProperty(value = "The number of the planned workplace that is defined in detailed scheduling and dispatching")
    public void setPlannedWorkplaceNumbers(List<String> plannedWorkplaceNumbers) {
        mPlannedWorkplaceNumbers = plannedWorkplaceNumbers;
    }

    public List<String> getWorkplaceIds() {
        return mWorkplaceIds;
    }

    public void setWorkplaceIds(List<String> workplaceIds) {
        mWorkplaceIds = workplaceIds;
    }

    public List<String> getProductionOrderSplits() {
        return mProductionOrderSplits;
    }

    @ApiModelProperty(value = "The split number of the corresponding production order split")
    public void setProductionOrderSplits(List<String> productionOrderSplits) {
        mProductionOrderSplits = productionOrderSplits;
    }

    public List<String> getOperationSplits() {
        return mOperationSplits;
    }

    @ApiModelProperty(value = "The split number of the operation")
    public void setOperationSplits(List<String> operationSplits) {
        mOperationSplits = operationSplits;
    }
}