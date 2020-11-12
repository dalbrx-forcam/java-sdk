////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-Nov-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.staffmember;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberTimeAttendance;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Web service model for command PersonTimeAttendanceCommand.
 */
@ApiModel(value = "staffMemberTimeAttendanceCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberTimeAttendanceCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** The name as constant string. */
    public static final String NAME = "STAFF_MEMBER_TIME_ATTENDANCE";

    private static final long serialVersionUID = 6756439318737043010L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Person id as staff member id.. */
    private String mStaffMemberId;

    /** Staff member time attendance. */
    private StaffMemberTimeAttendance mStaffMemberTimeAttendanceId;

    /** Flag to identify if person is forcibly logged off. */
    private boolean mForcedLogOff;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberTimeAttendanceCommandDataWSModel() {
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
            .append("mStaffMemberTimeAttendanceId", mStaffMemberTimeAttendanceId)
            .append("mForcedLogOff", mForcedLogOff)
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

        final StaffMemberTimeAttendanceCommandDataWSModel that = (StaffMemberTimeAttendanceCommandDataWSModel) o;
        return new EqualsBuilder()
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mStaffMemberTimeAttendanceId, that.mStaffMemberTimeAttendanceId)
            .append(mForcedLogOff, that.mForcedLogOff)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberId)
            .append(mStaffMemberTimeAttendanceId)
            .append(mForcedLogOff)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public StaffMemberTimeAttendance getStaffMemberTimeAttendanceId() {
        return mStaffMemberTimeAttendanceId;
    }

    public void setStaffMemberTimeAttendanceId(StaffMemberTimeAttendance staffMemberTimeAttendanceId) {
        mStaffMemberTimeAttendanceId = staffMemberTimeAttendanceId;
    }

    public boolean isForcedLogOff() {
        return mForcedLogOff;
    }

    public void setForcedLogOff(boolean forcedLogOff) {
        mForcedLogOff = forcedLogOff;
    }
}
