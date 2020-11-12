////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-Nov-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.staffmember;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Time attendance break revision insert command data ws model.
 */
@ApiModel(value = "staffMemberTimeAttendanceBreakRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** The name as a constant string. */
    public static final String NAME = "STAFF_MEMBER_TIME_ATTENDANCE_BREAK_REVISION_INSERT";

    private static final long serialVersionUID = 2360872377808957935L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A model of the time attendance command. */
    private StaffMemberTimeAttendanceBreakCommandDataWSModel mStaffMemberTimeAttendanceBreakCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mStaffMemberTimeAttendanceCommand", mStaffMemberTimeAttendanceBreakCommand)
            .append("mInsertionTimestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
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

        final StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel that = (StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel) o;
        return new EqualsBuilder()
            .append(mStaffMemberTimeAttendanceBreakCommand, that.mStaffMemberTimeAttendanceBreakCommand)
            .append(mInsertionTimestamp, that.mInsertionTimestamp)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberTimeAttendanceBreakCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberTimeAttendanceBreakCommandDataWSModel getStaffMemberTimeAttendanceBreakCommand() {
        return mStaffMemberTimeAttendanceBreakCommand;
    }

    public void setStaffMemberTimeAttendanceBreakCommand(StaffMemberTimeAttendanceBreakCommandDataWSModel staffMemberTimeAttendanceBreakCommand) {
        mStaffMemberTimeAttendanceBreakCommand = staffMemberTimeAttendanceBreakCommand;
    }

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }
}
