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
@ApiModel(value = "staffMemberOperationStateRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class StaffMemberOperationStateRevisionInsertCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "STAFF_MEMBER_OPERATION_STATE_REVISION_INSERT";

    private static final long serialVersionUID = 6912888131763946667L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private StaffMemberOperationStateCommandDataWSModel mStaffMemberOperationStateCommand;

    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public StaffMemberOperationStateRevisionInsertCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mStaffMemberOperationStateCommand", mStaffMemberOperationStateCommand)
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

        final StaffMemberOperationStateRevisionInsertCommandDataWSModel that = (StaffMemberOperationStateRevisionInsertCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mStaffMemberOperationStateCommand, that.mStaffMemberOperationStateCommand)
            .append(mInsertionTimestamp, that.mInsertionTimestamp)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mStaffMemberOperationStateCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

    public StaffMemberOperationStateCommandDataWSModel getStaffMemberOperationStateCommand() {
        return mStaffMemberOperationStateCommand;
    }

    public void setStaffMemberOperationStateCommand(StaffMemberOperationStateCommandDataWSModel staffMemberOperationStateCommand) {
        mStaffMemberOperationStateCommand = staffMemberOperationStateCommand;
    }
}
