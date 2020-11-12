////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.TicketStateEmbed;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The request object for getting a ticket state.
 */
public class GetTicketStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketState mId;

    /** Determines what shall be embedded. */
    private TicketStateEmbed mEmbed = new TicketStateEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GetTicketStateRequest(TicketState id) {
        mId = id;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public TicketStateEmbed embed() {
        return mEmbed;
    }

    public void embed(TicketStateEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final GetTicketStateRequest that = (GetTicketStateRequest) o;

        return new EqualsBuilder()
            .append(mId, that.mId)
            .append(mEmbed, that.mEmbed)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mId)
            .append(mEmbed)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getter/setters
    // ------------------------------------------------------------------------

    public TicketState getId() {
        return mId;
    }

    public void setId(TicketState id) {
        mId = id;
    }
}
