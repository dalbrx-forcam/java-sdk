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
@ApiModel(value = "staffMemberWorkplaceStateCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberWorkplaceStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "STAFF_MEMBER_WORKPLACE_STATE";

    private static final long serialVersionUID = -2233523358094699624L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mStaffMemberId;

    private String mWorkplaceId;

    private StaffMemberState mStaffMemberStateId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberWorkplaceStateCommandDataWSModel() {
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

        final StaffMemberWorkplaceStateCommandDataWSModel that = (StaffMemberWorkplaceStateCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mWorkplaceId, that.mWorkplaceId)
            .append(mStaffMemberStateId, that.mStaffMemberStateId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberId)
            .append(mWorkplaceId)
            .append(mStaffMemberStateId)
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

}
