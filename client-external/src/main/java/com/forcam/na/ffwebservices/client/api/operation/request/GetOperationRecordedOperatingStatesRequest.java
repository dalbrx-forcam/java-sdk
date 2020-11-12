////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

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
public class GetOperationRecordedOperatingStatesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation id. */
    private String mOperationId;

    /** Determines what shall be embedded. */
    private RecordedOperatingStateEmbed mEmbed = new RecordedOperatingStateEmbed();

    /** The workplace state id. */
    private WorkplaceState mWorkplaceStateId;

    /** The operating state class id. */
    private String mOperatingStateClassId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The time base. */
    private TimeBaseFilter mTimeBase;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperationRecordedOperatingStatesRequest} object with an operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationRecordedOperatingStatesRequest(String operationId) {
        mOperationId = operationId;
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
            .append("operationId", mOperationId)
            .append("workplaceStateId", mWorkplaceStateId)
            .append("operatingStateClassId", mOperatingStateClassId)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
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

    public TimeBaseFilter getTimeBase() {
        return mTimeBase;
    }

    public void setTimeBase(TimeBaseFilter timeBase) {
        mTimeBase = timeBase;
    }
}