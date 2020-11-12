////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 23.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Staff member assignment model.
 */
@XmlRootElement(name = "staffMemberAssignment")
@ApiModel(value = "staffMemberAssignment")
@JsonPropertyOrder({ "staffMemberId", "staffMemberShiftId", "workplaceId", "skillId", "workplaceShiftId", "startDate", "endDate", "capacity", "isFixed" })
public class StaffMemberAssignmentWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** The staff member shift ID. */
    private String mStaffMemberShiftId;

    /** The workplace ID. */
    private String mWorkplaceId;

    /** The skill ID. */
    private String mSkillId;

    /** The workplace shift ID. */
    private String mWorkplaceShiftId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The capacity. */
    private Double mCapacity;

    /** Flag if assignment is fixed. */
    private boolean mIsFixed;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("staffMemberShiftId", mStaffMemberShiftId)
            .append("workplaceSiftId", mWorkplaceShiftId)
            .append("staffMemberId", mStaffMemberId)
            .append("workplaceId", mWorkplaceId)
            .append("startDate", DateFormatUtility.formatLogging(mStartDate))
            .append("capacity", mCapacity)
            .append("skillId", mSkillId)
            .append("endDate", DateFormatUtility.formatLogging(mEndDate))
            .append("isFixed", mIsFixed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    @ApiModelProperty(value = "UUID of the staff member", required = true, position = 0)
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberShiftId() {
        return mStaffMemberShiftId;
    }

    @ApiModelProperty(value = "UUID of the staff shift", required = true, position = 1)
    public void setStaffMemberShiftId(String staffMemberShiftId) {
        mStaffMemberShiftId = staffMemberShiftId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the workplace to which the staff member has been assigned", required = true, position = 2)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getSkillId() {
        return mSkillId;
    }

    @ApiModelProperty(value = "UUID of the required skill to be covered by the staff member", required = true, position = 3)
    public void setSkillId(String skillId) {
        mSkillId = skillId;
    }

    public String getWorkplaceShiftId() {
        return mWorkplaceShiftId;
    }

    @ApiModelProperty(value = "UUID of the workplace shift", required = true, position = 4)
    public void setWorkplaceShiftId(String workplaceShiftId) {
        mWorkplaceShiftId = workplaceShiftId;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "The start date on which the staff member was scheduled (optional)", required = true, position = 5)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    @ApiModelProperty(value = "The end date by which the employee was scheduled (optional)", required = true, position = 6)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Double getCapacity() {
        return mCapacity;
    }

    @ApiModelProperty(value = "A value between 0 and 1, which describes the capacitive share of the staff member planned", required = true, position = 7, allowableValues = "range[0,1]", example = "0.1")
    public void setCapacity(Double capacity) {
        mCapacity = capacity;
    }

    public boolean isFixed() {
        return mIsFixed;
    }

    @ApiModelProperty(value = "Boolean to indicate the assignment has been fixed", position = 8)
    public void setFixed(boolean fixed) {
        mIsFixed = fixed;
    }

    @Override
    public Date getPaginationDate() {
        return mStartDate;
    }
}