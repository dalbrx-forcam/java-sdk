////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 10.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketAttachmentPropertiesWSModel;

/**
 * The request object for creating a new ticket activity attachment.
 */
public class CreateTicketActivityAttachmentRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private String mActivityId;
    private CreateTicketAttachmentPropertiesWSModel mTicketActivityAttachmentData = new CreateTicketAttachmentPropertiesWSModel();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CreateTicketActivityAttachmentRequest(String ticketId, String activityId, String description) {
        mTicketId = ticketId;
        mActivityId = activityId;
        mTicketActivityAttachmentData.setDescription(description);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("ticketId", mTicketId)
            .append("activityId", mActivityId)
            .append("mTicketActivityAttachmentData", mTicketActivityAttachmentData)
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

    public String getActivityId() {
        return mActivityId;
    }

    public void setActivityId(String activityId) {
        mActivityId = activityId;
    }

    public CreateTicketAttachmentPropertiesWSModel getTicketActivityAttachmentData() {
        return mTicketActivityAttachmentData;
    }

    public void setTicketActivityAttachmentData(CreateTicketAttachmentPropertiesWSModel ticketActivityAttachmentData) {
        mTicketActivityAttachmentData = ticketActivityAttachmentData;
    }
}
