////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;

/**
 * The request object for getting a ticket activity.
 */
public class GetTicketActivityRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** A ticket activity Id. */
    private String mActivityId;

    /** A ticket Id. */
    private String mTicketId;

    /** Determines what shall be embedded. */
    private TicketEmbed mEmbed = new TicketEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creats a new {@link GetTicketActivitiesRequest} obejct with a activity id and a ticket id.
     *
     * @param activityId The activity Id.
     * @param ticketId   The ticket Id.
     */
    public GetTicketActivityRequest(String ticketId, String activityId) {
        mActivityId = activityId;
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
            .append("activityId", mActivityId)
            .append("ticketId", mTicketId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getActivityId() {
        return mActivityId;
    }

    public void setActivityId(String activityId) {
        mActivityId = activityId;
    }

    public String getTicketId() {
        return mTicketId;
    }

    public void setTicketId(String ticketId) {
        mTicketId = ticketId;
    }
}
