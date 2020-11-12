////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 15.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.RecordedOperatingStateEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplaceRecordedOperatingStatesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id. */
    private String mWorkplaceId;

    /** Determines what shall be embedded. */
    private RecordedOperatingStateEmbed mEmbed = new RecordedOperatingStateEmbed();

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The shift id. */
    private String mShiftId;

    /** The time base. */
    private TimeBaseFilter mTimeBase;

    /** The workplace state ID. */
    private WorkplaceState mWorkplaceStateId;

    /** The operating state class ID. */
    private String mOperatingStateClassId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceRecordedOperatingStatesRequest} object with a workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetWorkplaceRecordedOperatingStatesRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public RecordedOperatingStateEmbed embed() {
        return mEmbed;
    }

    public void embed(RecordedOperatingStateEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("operatingStateClassId", mOperatingStateClassId)
            .append("workplaceStateId", mWorkplaceStateId)
            .append("workplaceId", mWorkplaceId)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("shiftId", mShiftId)
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

    public String getShiftId() {
        return mShiftId;
    }

    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

    public TimeBaseFilter getTimeBase() {
        return mTimeBase;
    }

    public void setTimeBase(TimeBaseFilter timeBase) {
        mTimeBase = timeBase;
    }

    public WorkplaceState getWorkplaceStateId() {
        return mWorkplaceStateId;
    }

    public void setWorkplaceStateId(WorkplaceState workplaceStateId) {
        mWorkplaceStateId = workplaceStateId;
    }

    public String getOperatingStateClassId() {
        return mOperatingStateClassId;
    }

    public void setOperatingStateClassId(String operatingStateClassId) {
        mOperatingStateClassId = operatingStateClassId;
    }
}