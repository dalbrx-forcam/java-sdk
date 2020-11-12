////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.10.2018.
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
 *
 */
@ApiModel(value = "staffMemberWorkplaceStateRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "STAFF_MEMBER_WORKPLACE_STATE_REVISION_INSERT";

    private static final long serialVersionUID = -6433238025130008846L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private StaffMemberWorkplaceStateCommandDataWSModel mStaffMemberWorkplaceStateCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mStaffMemberWorkplaceStateCommand", mStaffMemberWorkplaceStateCommand)
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

        final StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel that = (StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mStaffMemberWorkplaceStateCommand, that.mStaffMemberWorkplaceStateCommand)
            .append(mInsertionTimestamp, that.mInsertionTimestamp)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberWorkplaceStateCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberWorkplaceStateCommandDataWSModel getStaffMemberWorkplaceStateCommand() {
        return mStaffMemberWorkplaceStateCommand;
    }

    public void setStaffMemberWorkplaceStateCommand(StaffMemberWorkplaceStateCommandDataWSModel staffMemberWorkplaceStateCommand) {
        mStaffMemberWorkplaceStateCommand = staffMemberWorkplaceStateCommand;
    }

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

}
