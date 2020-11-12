////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shift.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftEmbed;

import java.util.Date;

;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplaceShiftsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id. */
    private String mWorkplaceId;

    /** Workplace number. */
    private String mWorkplaceNumber;

    /** The ERP context ID. */
    private String mErpContextId;

    /** The workplace group number. */
    private String mWorkplaceGroupNumber;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** Flag if shift is a working shift. */
    private Boolean mIsWorkingShift;

    /** Shift type ID. */
    private String mShiftTypeId;

    private String mAssociatedDay;

    /** Determines what shall be embedded. */
    private WorkplaceShiftEmbed mEmbed = new WorkplaceShiftEmbed();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceShiftEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceShiftEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceId", mWorkplaceId)
            .append("workplaceNumber", mWorkplaceNumber)
            .append("associatedDay", mAssociatedDay)
            .append("erpContextId", mErpContextId)
            .append("workplaceGroupNumber", mWorkplaceGroupNumber)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("isWorkingShift", mIsWorkingShift)
            .append("shiftTypeId", mShiftTypeId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getWorkplaceGroupNumber() {
        return mWorkplaceGroupNumber;
    }

    public void setWorkplaceGroupNumber(String workplaceGroupNumber) {
        mWorkplaceGroupNumber = workplaceGroupNumber;
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

    public Boolean isWorkingShift() {
        return mIsWorkingShift;
    }

    public void setWorkingShift(Boolean isWorkingShift) {
        mIsWorkingShift = isWorkingShift;
    }

    public String getShiftTypeId() {
        return mShiftTypeId;
    }

    public void setShiftTypeId(String shiftTypeId) {
        mShiftTypeId = shiftTypeId;
    }

    public String getAssociatedDay() {
        return mAssociatedDay;
    }

    public void setAssociatedDay(String associatedDay) {
        mAssociatedDay = associatedDay;
    }
}