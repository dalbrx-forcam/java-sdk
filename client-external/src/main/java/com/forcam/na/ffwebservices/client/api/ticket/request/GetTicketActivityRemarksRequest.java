////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 11.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * The request object for gettting ticket activity remarks.
 */
public class GetTicketActivityRemarksRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mTicketId;

    private String mActivityId;

    private String mEditor;

    private Date mCreationDateFrom;

    private Date mCreationDateTo;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketActivityRemarksRequest(String ticketId, String activityId) {
        mTicketId = ticketId;
        mActivityId = activityId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mEditor", mEditor)
            .append("mCreationDateFrom", mCreationDateFrom)
            .append("mCreationDateTo", mCreationDateTo)
            .toString();
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getTicketId() {
        return mTicketId;
    }

    public void setTicketId(String ticketId) {
        mTicketId = ticketId;
    }

    public String getActivityId() {
        return mActivityId;
    }

    public void setActivityId(String activityId) {
        mActivityId = activityId;
    }

    public String getEditor() {
        return mEditor;
    }

    public void setEditor(String editor) {
        mEditor = editor;
    }

    public Date getCreationDateFrom() {
        return mCreationDateFrom;
    }

    public void setCreationDateFrom(Date creationDateFrom) {
        mCreationDateFrom = creationDateFrom;
    }

    public Date getCreationDateTo() {
        return mCreationDateTo;
    }

    public void setCreationDateTo(Date creationDateTo) {
        mCreationDateTo = creationDateTo;
    }
}
