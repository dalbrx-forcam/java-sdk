////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;

/**
 * The request object for getting a ticket activity state.
 */
public class GetTicketActivityStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A ticket ID. */
    private TicketActivityState mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketActivityStateRequest(TicketActivityState ticketActivityStateId) {
        mId = ticketActivityStateId;
    }
    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityState getId() {
        return mId;
    }

    public void setId(TicketActivityState id) {
        mId = id;
    }

}
