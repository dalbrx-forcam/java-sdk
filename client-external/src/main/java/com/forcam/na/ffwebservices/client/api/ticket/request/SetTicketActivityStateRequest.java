////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 03.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;

/**
 * The request object for setting a ticket activity state.
 */
public class SetTicketActivityStateRequest extends GetTicketActivityRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private TicketActivityState mTicketActivityState;
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creats a new {@link GetTicketActivitiesRequest} object with a activity id and a ticket id.
     *
     * @param activityId The activity Id.
     * @param ticketId   The ticket Id.
     * @param state      The ticket activity state.
     */
    public SetTicketActivityStateRequest(String ticketId, String activityId, TicketActivityState state) {
        super(ticketId, activityId);
        mTicketActivityState = state;
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append(super.toString())
            .append("ticketActivityState", this.getTicketActivityState())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketActivityState getTicketActivityState() {
        return mTicketActivityState;
    }

    public void setTicketActivityState(TicketActivityState ticketActivityState) {
        mTicketActivityState = ticketActivityState;
    }
}
