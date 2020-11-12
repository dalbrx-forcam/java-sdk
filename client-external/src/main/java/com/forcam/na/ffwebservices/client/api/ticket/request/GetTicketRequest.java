////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;

/**
 * The request object for getting a ticket.
 */
public class GetTicketRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A ticket ID. */
    private String mId;

    /** Determines what shall be embedded. */
    private TicketEmbed mEmbed = new TicketEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetTicketRequest} object with a staff member ID.
     *
     * @param ticketId The ticket ID.
     */
    public GetTicketRequest(String ticketId) {
        mId = ticketId;
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
            .append("id", mId)
            .append("embed", mEmbed)
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

}
