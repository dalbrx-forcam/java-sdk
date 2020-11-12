////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 25.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * The request object for deleting a ticket attachment.
 */
public class DeleteTicketAttachmentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mId;

    private String mTicketId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link DeleteTicketAttachmentRequest} object with a ticket attachment Id and a ticket Id.
     *
     * @param ticketId           The ticket Id.
     * @param ticketAttachmentId The ticket attachment Id.
     */
    public DeleteTicketAttachmentRequest(String ticketId, String ticketAttachmentId) {
        mId = ticketAttachmentId;
        mTicketId = ticketId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("id", mId)
            .append("ticketId", mTicketId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTicketId() {
        return mTicketId;
    }

    public void setTicketId(String ticketId) {
        mTicketId = ticketId;
    }
}
