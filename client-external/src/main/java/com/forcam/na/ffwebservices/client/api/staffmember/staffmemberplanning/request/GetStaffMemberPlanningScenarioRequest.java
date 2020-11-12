////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Request to get a staff member planning scenario by ID.
 */
public class GetStaffMemberPlanningScenarioRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning scenario ID. */
    private String mStaffMemberPlanningScenarioId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberPlanningScenarioId The staff member planing scenario ID.
     */
    public GetStaffMemberPlanningScenarioRequest(String staffMemberPlanningScenarioId) {
        mStaffMemberPlanningScenarioId = staffMemberPlanningScenarioId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("staffMemberPlanningScenarioId", mStaffMemberPlanningScenarioId)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the staff member planning scenario ID.
     *
     * @return The staff member planning scenario ID.
     */
    public String getStaffMemberPlanningScenarioId() {
        return mStaffMemberPlanningScenarioId;
    }

    /**
     * Sets the staff member planning scenario ID.
     *
     * @param staffMemberPlanningScenarioId The staff member planning scenario ID.
     */
    public void setStaffMemberPlanningScenarioId(String staffMemberPlanningScenarioId) {
        mStaffMemberPlanningScenarioId = staffMemberPlanningScenarioId;
    }

    /**
     * Provides the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}