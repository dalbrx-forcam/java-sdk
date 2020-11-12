////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-Nov-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.staffmember;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberTimeAttendanceBreak;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * WS model for person/staff member time attendance break command.
 */
public class StaffMemberTimeAttendanceBreakCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as constant string. */
    public static final String NAME = "STAFF_MEMBER_TIME_ATTENDANCE_BREAK";

    private static final long serialVersionUID = 873244094765454275L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Person id as staff member id.. */
    private String mStaffMemberId;

    /** Staff member time attendance. */
    private StaffMemberTimeAttendanceBreak mStaffMemberTimeAttendanceBreakId;

    /** Flag to identify if person is forcibly logged off. */
    private boolean mForcedLogOff;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberTimeAttendanceBreakCommandDataWSModel() {
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
            .append("mStaffMemberTimeAttendanceBreakId", mStaffMemberTimeAttendanceBreakId)
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

        final StaffMemberTimeAttendanceBreakCommandDataWSModel that = (StaffMemberTimeAttendanceBreakCommandDataWSModel) o;
        return new EqualsBuilder()
            .append(mStaffMemberId, that.mStaffMemberId)
            .append(mStaffMemberTimeAttendanceBreakId, that.mStaffMemberTimeAttendanceBreakId)
            .append(mForcedLogOff, that.mForcedLogOff)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberId)
            .append(mStaffMemberTimeAttendanceBreakId)
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

    public StaffMemberTimeAttendanceBreak getStaffMemberTimeAttendanceBreakId() {
        return mStaffMemberTimeAttendanceBreakId;
    }

    public void setStaffMemberTimeAttendanceBreakId(StaffMemberTimeAttendanceBreak staffMemberTimeAttendanceBreakId) {
        mStaffMemberTimeAttendanceBreakId = staffMemberTimeAttendanceBreakId;
    }

    public boolean isForcedLogOff() {
        return mForcedLogOff;
    }

    public void setForcedLogOff(boolean forcedLogOff) {
        mForcedLogOff = forcedLogOff;
    }
}
