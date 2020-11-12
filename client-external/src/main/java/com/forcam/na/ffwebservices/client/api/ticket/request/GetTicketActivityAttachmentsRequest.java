////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 09.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * The request object for getting ticket attachments.
 */
public class GetTicketActivityAttachmentsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mTicketId;

    private String mActivityId;

    private String mName;

    private Date mCreationDateFrom;

    private Date mCreationDateTo;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketActivityAttachmentsRequest(String ticketId, String activityId) {
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
            .append("mName", mName)
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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
