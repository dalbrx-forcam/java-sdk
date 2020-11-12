////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 13.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketPropertiesWSModel;

/**
 * The request object for updating a ticket.
 */
public class UpdateTicketRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The Ticket Id */
    private String mId;

    /** The data of the ticket that shall be created. */
    private WriteTicketPropertiesWSModel mTicketData;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link CreateTicketRequest} object with the ticket Data.
     *
     * @param ticketId   The ticket ID.
     * @param ticketData The ticket properties.
     */
    public UpdateTicketRequest(String ticketId, WriteTicketPropertiesWSModel ticketData) {
        mId = ticketId;
        mTicketData = ticketData;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("id", mId)
            .append("ticketData", mTicketData)
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

    public WriteTicketPropertiesWSModel getTicketData() {
        return mTicketData;
    }

    public void setTicketData(WriteTicketPropertiesWSModel ticketData) {
        mTicketData = ticketData;
    }

}
