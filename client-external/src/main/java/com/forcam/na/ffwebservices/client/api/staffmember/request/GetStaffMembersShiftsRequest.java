////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Request parameter for getting all staff member shifts.
 */
public class GetStaffMembersShiftsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** The personnel number. */
    private String mPersonnelNumber;

    /** The staff member first name. */
    private String mFirstName;

    /** The staff member last name. */
    private String mLastName;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The shift type ID. */
    private String mShiftTypeId;

    /** Determines what shall be embedded. */
    private StaffMemberShiftEmbed mEmbed = new StaffMemberShiftEmbed();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public StaffMemberShiftEmbed embed() {
        return mEmbed;
    }

    public void embed(StaffMemberShiftEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("staffMemberId", mStaffMemberId)
            .append("personnelNumber", mPersonnelNumber)
            .append("firstName", mFirstName)
            .append("lastName", mLastName)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("shiftTypeId", mShiftTypeId)
            .append("embed", mEmbed)
            .toString();
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

    public String getPersonnelNumber() {
        return mPersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        mPersonnelNumber = personnelNumber;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public String getShiftTypeId() {
        return mShiftTypeId;
    }

    public void setShiftTypeId(String shiftTypeId) {
        mShiftTypeId = shiftTypeId;
    }
}