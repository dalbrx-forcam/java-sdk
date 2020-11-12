////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 03.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The request body for operation quality detail.
 */
@ApiModel("operationQualityDetail")
@JsonPropertyOrder({ "workplaceId", "quantity", "qualityDetailId", "remark", "staffMemberId" })
public class OperationQualityDetailRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the workplace. */
    private String mWorkplaceId;

    /** The quantity. */
    private double mQuantity;

    /** The id of the quality detail. */
    private String mQualityDetailId;

    /** The remark. */
    private String mRemark;

    /** The id of the staff member. */
    private String mStaffMemberId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("workplaceId", mWorkplaceId)
            .append("quantity", mQuantity)
            .append("qualityDetailId", mQualityDetailId)
            .append("remark", mRemark)
            .append("staffMemberId", mStaffMemberId)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OperationQualityDetailRequestBody)) {
            return false;
        }

        OperationQualityDetailRequestBody that = (OperationQualityDetailRequestBody) o;

        return new EqualsBuilder()
            .append(getQuantity(), that.getQuantity())
            .append(getWorkplaceId(), that.getWorkplaceId())
            .append(getQualityDetailId(), that.getQualityDetailId())
            .append(getRemark(), that.getRemark())
            .append(getStaffMemberId(), that.getStaffMemberId())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getWorkplaceId())
            .append(getQuantity())
            .append(getQualityDetailId())
            .append(getRemark())
            .append(getStaffMemberId())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the workplace. The target workplace is used if no workplace is provided.", required = false, position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "The quantity amount", required = true, position = 1)
    public void setQuantity(double quantity) {
        mQuantity = quantity;
    }

    public double getQuantity() {
        return mQuantity;
    }

    @ApiModelProperty(value = "UUID of the quality detail", required = true, position = 2)
    public void setQualityDetailId(String qualityDetailId) {
        mQualityDetailId = qualityDetailId;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    @ApiModelProperty(position = 3)
    public void setRemark(String remark) {
        mRemark = remark;
    }

    public String getRemark() {
        return mRemark;
    }

    @ApiModelProperty(position = 4)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }
}