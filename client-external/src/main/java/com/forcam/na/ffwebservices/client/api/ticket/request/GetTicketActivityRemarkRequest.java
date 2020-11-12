////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 11.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;

/**
 * The request object for getting a ticket activity remark.
 */
public class GetTicketActivityRemarkRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private String mActivityId;
    private String mRemarkId;
    private TicketEmbed mEmbed = new TicketEmbed();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketActivityRemarkRequest(String ticketId, String activityId, String remarkId) {
        mTicketId = ticketId;
        mActivityId = activityId;
        mRemarkId = remarkId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    public TicketEmbed embed() {
        return mEmbed;
    }

    public void embed(TicketEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketId", mTicketId)
            .append("activityId", mActivityId)
            .append("remarkId", mRemarkId)
            .append("embed", mEmbed)
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

    public String getRemarkId() {
        return mRemarkId;
    }

    public void setRemarkId(String remarkId) {
        mRemarkId = remarkId;
    }
}
