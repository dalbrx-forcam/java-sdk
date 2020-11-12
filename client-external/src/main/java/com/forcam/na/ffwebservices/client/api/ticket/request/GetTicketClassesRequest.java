////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 27.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketClassEmbed;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The request object for getting ticket classes.
 */
public class GetTicketClassesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private TicketClassEmbed mEmbed = new TicketClassEmbed();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public TicketClassEmbed embed() {
        return mEmbed;
    }

    public void embed(TicketClassEmbed embed) {
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

        final GetTicketClassesRequest that = (GetTicketClassesRequest) o;

        return new EqualsBuilder()
            .append(mEmbed, that.mEmbed)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mEmbed)
            .toHashCode();
    }
}
