////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 20.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;

/**
 * The request object for getting a ticket attachment.
 */
public class GetTicketAttachmentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A ticket attachmentId */
    private String mAttachmentId;

    /** A ticket Id */
    private String mTicketId;

    /** Determines what shall be embedded. */
    private TicketEmbed mEmbed = new TicketEmbed();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetTicketRequest} object with a staff member ID.
     *
     * @param ticketId     The ticket ID.
     * @param attachmentId The ticket attachment id.
     */
    public GetTicketAttachmentRequest(String ticketId, String attachmentId) {
        mAttachmentId = attachmentId;
        mTicketId = ticketId;
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
            .append("attachmentId", mAttachmentId)
            .append("ticketId", mTicketId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------
    public String getAttachmentId() {
        return mAttachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        mAttachmentId = attachmentId;
    }

    public String getTicketId() {
        return mTicketId;
    }

    public void setTicketId(String ticketId) {
        mTicketId = ticketId;
    }

}
