////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 08.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketState;

/**
 * The request object for setting a ticket state.
 */
public class SetTicketStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** The Ticket ID */
    private String mTicketId;

    /** The Ticket State ID */
    private TicketState mTicketStateId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link SetTicketStateRequest} object with a ticket state ID.
     *
     * @param ticketId      The ticket ID.
     * @param ticketStateId The ticket state ID.
     */
    public SetTicketStateRequest(String ticketId, TicketState ticketStateId) {
        mTicketId = ticketId;
        mTicketStateId = ticketStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketId", mTicketId)
            .append("ticketStateId", mTicketStateId)
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

    public TicketState getTicketStateId() {
        return mTicketStateId;
    }

    public void setTicketStateId(TicketState id) {
        mTicketStateId = id;
    }

}
