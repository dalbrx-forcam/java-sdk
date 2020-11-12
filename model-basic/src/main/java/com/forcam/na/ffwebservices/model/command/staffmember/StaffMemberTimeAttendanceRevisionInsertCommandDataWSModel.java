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
 * Time attendance revision insert command data ws model.
 */
@ApiModel(value = "staffMemberTimeAttendanceRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** The name as a constant string. */
    public static final String NAME = "STAFF_MEMBER_TIME_ATTENDANCE_REVISION_INSERT";

    private static final long serialVersionUID = -805982187250193413L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** A model of the time attendance command. */
    private StaffMemberTimeAttendanceCommandDataWSModel mStaffMemberTimeAttendanceCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mStaffMemberTimeAttendanceCommand", mStaffMemberTimeAttendanceCommand)
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

        final StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel that = (StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel) o;
        return new EqualsBuilder()
            .append(mStaffMemberTimeAttendanceCommand, that.mStaffMemberTimeAttendanceCommand)
            .append(mInsertionTimestamp, that.mInsertionTimestamp)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberTimeAttendanceCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberTimeAttendanceCommandDataWSModel getStaffMemberTimeAttendanceCommand() {
        return mStaffMemberTimeAttendanceCommand;
    }

    public void setStaffMemberTimeAttendanceCommand(StaffMemberTimeAttendanceCommandDataWSModel staffMemberTimeAttendanceCommand) {
        mStaffMemberTimeAttendanceCommand = staffMemberTimeAttendanceCommand;
    }

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }
}
