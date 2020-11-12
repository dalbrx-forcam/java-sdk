////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 11-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * WS model for operation planning scenario assignment.
 */
@XmlRootElement(name = "operationAssignment")
@ApiModel(value = "operationAssignment")
@JsonPropertyOrder({ "operationId", "workplaceId", "startDate", "endDate", "setupStartDate", "setupEndDate", "processingStartDate", "processingEndDate",
                     "isFixed" })
public class OperationAssignmentWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation id. */
    private String mOperationId;

    /** The workplace id. */
    private String mWorkplaceId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The setup start date. */
    private Date mSetupStartDate;

    /** The setup end date. */
    private Date mSetupEndDate;

    /** The processing start date. */
    private Date mProcessingStartDate;

    /** The processing end date. */
    private Date mProcessingEndDate;

    /** This flag indicates that an operation must not be rescheduled during automatic order planning. */
    private boolean mIsFixed;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operationId", mOperationId)
            .append("workplaceId", mWorkplaceId)
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .append("setupStartDate", DateFormatUtility.formatLogging(mSetupStartDate))
            .append("setupEndDate", DateFormatUtility.formatLogging(mSetupEndDate))
            .append("processingStartDate", DateFormatUtility.formatLogging(mProcessingStartDate))
            .append("processingEndDate", DateFormatUtility.formatLogging(mProcessingEndDate))
            .append("isFixed", mIsFixed)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OperationAssignmentWSModel)) {
            return false;
        }

        OperationAssignmentWSModel that = (OperationAssignmentWSModel) o;

        return new EqualsBuilder()
            .append(getEndDate(), that.getEndDate())
            .append(getStartDate(), that.getStartDate())
            .append(getProcessingEndDate(), that.getProcessingEndDate())
            .append(getProcessingStartDate(), that.getProcessingStartDate())
            .append(getSetupEndDate(), that.getSetupEndDate())
            .append(getSetupStartDate(), that.getSetupStartDate())
            .append(getWorkplaceId(), that.getWorkplaceId())
            .append(getOperationId(), that.getOperationId())
            .append(isFixed(), that.isFixed())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getEndDate())
            .append(getStartDate())
            .append(getProcessingEndDate())
            .append(getProcessingStartDate())
            .append(getSetupEndDate())
            .append(getSetupStartDate())
            .append(getWorkplaceId())
            .append(isFixed())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    @ApiModelProperty(value = "UUID of the assigned operation", required = true, position = 0)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the planned workplace ", required = true, position = 1)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "Planned start timestamp of an operation in the planning scenario", required = true, position = 2)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "Planned end timestamp of an operation in the planning scenario", required = true, position = 3)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Date getSetupStartDate() {
        return mSetupStartDate;
    }

    @ApiModelProperty(value = "Planned start timestamp of the setup phase of an operation in the planning scenario", required = true, position = 4)
    public void setSetupStartDate(Date setupStartDate) {
        mSetupStartDate = setupStartDate;
    }

    public Date getSetupEndDate() {
        return mSetupEndDate;
    }

    @ApiModelProperty(value = "Planned end timestamp of the setup phase of an operation in the planning scenario", required = true, position = 5)
    public void setSetupEndDate(Date setupEndDate) {
        mSetupEndDate = setupEndDate;
    }

    public Date getProcessingStartDate() {
        return mProcessingStartDate;
    }

    @ApiModelProperty(value = "Planned start timestamp of the processing phase of an operation in the planning scenario", required = true, position = 6)
    public void setProcessingStartDate(Date processingStartDate) {
        mProcessingStartDate = processingStartDate;
    }

    public Date getProcessingEndDate() {
        return mProcessingEndDate;
    }

    @ApiModelProperty(value = "Planned end timestamp of the processing phase of an operation in the planning scenario", required = true, position = 7)
    public void setProcessingEndDate(Date processingEndDate) {
        mProcessingEndDate = processingEndDate;
    }

    public boolean isFixed() {
        return mIsFixed;
    }

    @ApiModelProperty(value = "Boolean to indicate that an operation is fixed and must not be rescheduled during automatic order planning", position = 8)
    public void setFixed(boolean fixed) {
        mIsFixed = fixed;
    }
}
