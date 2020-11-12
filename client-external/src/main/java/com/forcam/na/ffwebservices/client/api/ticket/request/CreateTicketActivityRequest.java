////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 02.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketActivityPropertiesWSModel;

/**
 * The request object for creating a new ticket activity
 */
public class CreateTicketActivityRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private WriteTicketActivityPropertiesWSModel mTicketActivityData = new WriteTicketActivityPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    public CreateTicketActivityRequest(String ticketId, String title, String description) {
        mTicketId = ticketId;
        mTicketActivityData.setTitle(title);
        mTicketActivityData.setDescription(description);
        mTicketActivityData.setTicketActivityStateId(TicketActivityState.NEW);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketId", mTicketId)
            .append("ticketActivityData", mTicketActivityData)
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

    public WriteTicketActivityPropertiesWSModel getTicketActivityData() {
        return mTicketActivityData;
    }

    public void setTicketActivityData(WriteTicketActivityPropertiesWSModel ticketActivityData) {
        mTicketActivityData = ticketActivityData;
    }
}
