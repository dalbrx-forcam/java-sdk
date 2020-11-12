////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 12.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketPriority;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketPropertiesWSModel;

/**
 * The request object for creating a new ticket.
 */
public class CreateTicketRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The data of the ticket that shall be created. */
    private WriteTicketPropertiesWSModel mTicketData = new WriteTicketPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public CreateTicketRequest(String title, String description) {
        mTicketData.setTitle(title);
        mTicketData.setDescription(description);
        mTicketData.setTicketStateId(TicketState.NEW);
        mTicketData.setPriority(TicketPriority.MEDIUM);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketData", mTicketData)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WriteTicketPropertiesWSModel getTicketData() {
        return mTicketData;
    }

    public void setTicketData(WriteTicketPropertiesWSModel ticketData) {
        mTicketData = ticketData;
    }
}
