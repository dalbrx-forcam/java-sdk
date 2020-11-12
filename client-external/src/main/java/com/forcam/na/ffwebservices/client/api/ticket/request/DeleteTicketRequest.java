////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 07.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * The request object for deleting a ticket.
 */
public class DeleteTicketRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** The Ticket Id */
    private String mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link DeleteTicketRequest} object with a ticket ID.
     *
     * @param ticketId The ticket ID.
     */
    public DeleteTicketRequest(String ticketId) {
        mId = ticketId;
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("id", mId)
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
