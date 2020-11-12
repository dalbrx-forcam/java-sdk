////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 */
@ApiModel(value = "operationPhase")
@JsonPropertyOrder({ "workplaceId", "staffMemberId"})
public class OperationPhaseRequestBody {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the workplace. */
    private String mWorkplaceId;

    /** The id of the personnel. */
    private String mStaffMemberId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).appendSuper(super.toString()).append("workplaceId", mWorkplaceId).append(
            "staffMemberId",
            mStaffMemberId).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof OperationPhaseRequestBody)) {
            return false;
        }

        OperationPhaseRequestBody that = (OperationPhaseRequestBody) o;

        return new EqualsBuilder().append(getWorkplaceId(), that.getWorkplaceId()).append(getStaffMemberId(), that.getStaffMemberId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getWorkplaceId()).append(getStaffMemberId()).toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the workplace where the operation is executed (mandatory for SETUP and PROCESSING).", required = false, position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(position = 1)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }
}