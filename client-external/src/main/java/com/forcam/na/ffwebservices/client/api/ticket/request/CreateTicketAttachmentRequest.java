////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 22.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketAttachmentPropertiesWSModel;

/**
 * The request object for creating a new ticket attachment.
 */
public class CreateTicketAttachmentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;

    /** The data of the ticket attachment */
    private CreateTicketAttachmentPropertiesWSModel mTicketAttachmentData = new CreateTicketAttachmentPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    public CreateTicketAttachmentRequest(String ticketId, String description) {
        mTicketId = ticketId;
        mTicketAttachmentData.setDescription(description);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketId", mTicketId)
            .append("ticketAttachmentData", mTicketAttachmentData)
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

    public CreateTicketAttachmentPropertiesWSModel getTicketAttachmentData() {
        return mTicketAttachmentData;
    }

    public void setTicketAttachmentData(CreateTicketAttachmentPropertiesWSModel ticketAttachmentData) {
        mTicketAttachmentData = ticketAttachmentData;
    }
}
