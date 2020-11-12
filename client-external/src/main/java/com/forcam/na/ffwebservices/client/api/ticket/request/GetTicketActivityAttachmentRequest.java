////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 09.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;

/**
 *
 */
public class GetTicketActivityAttachmentRequest {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private String mActivityId;
    private String mAttachmentId;
    private TicketEmbed mEmbed = new TicketEmbed();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketActivityAttachmentRequest(String ticketId, String activityId, String attachmentId) {
        mTicketId = ticketId;
        mActivityId = activityId;
        mAttachmentId = attachmentId;
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
            .append("attachmentId", mAttachmentId)
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

    public String getAttachmentId() {
        return mAttachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        mAttachmentId = attachmentId;
    }
}
