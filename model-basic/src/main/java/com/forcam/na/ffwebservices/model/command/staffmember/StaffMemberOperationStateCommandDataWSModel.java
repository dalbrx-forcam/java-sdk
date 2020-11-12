////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.staffmember;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberState;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 */
@ApiModel(value = "staffMemberOperationStateCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberOperationStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "STAFF_MEMBER_OPERATION_STATE";

    private static final long serialVersionUID = 4870023744827323380L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mStaffMemberId;

    private String mWorkplaceId;

    private StaffMemberState mStaffMemberStateId;

    private String mOperationId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberOperationStateCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mStaffMemberId", mStaffMemberId)
            .append("mWorkplaceId", mWorkplaceId)
            .append("mStaffMemberStateId", mStaffMemberStateId)
            .append("mOperationId", mOperationId)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final StaffMemberOperationStateCommandDataWSModel that = (StaffMemberOperationStateCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mWorkplaceId, that.mWorkplaceId)
            .append(mStaffMemberStateId, that.mStaffMemberStateId)
            .append(mOperationId, that.mOperationId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberId)
            .append(mWorkplaceId)
            .append(mStaffMemberStateId)
            .append(mOperationId)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberState getStaffMemberStateId() {
        return mStaffMemberStateId;
    }

    public void setStaffMemberStateId(StaffMemberState staffMemberStateId) {
        mStaffMemberStateId = staffMemberStateId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }
}
