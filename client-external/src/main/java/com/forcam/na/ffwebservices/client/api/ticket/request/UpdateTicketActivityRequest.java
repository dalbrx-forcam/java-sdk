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

import java.util.Date;

/**
 * The request object for creating a new ticket activity
 */
public class UpdateTicketActivityRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private String mActivityId;
    private WriteTicketActivityPropertiesWSModel mTicketActivityData = new WriteTicketActivityPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    public UpdateTicketActivityRequest(String ticketId, String activityId, String title, String description, TicketActivityState ticketActivityState,
                                       Date dueDate) {
        mTicketId = ticketId;
        mActivityId = activityId;

        mTicketActivityData.setTitle(title);
        mTicketActivityData.setDescription(description);
        mTicketActivityData.setTicketActivityStateId(ticketActivityState);
        mTicketActivityData.setDueDate(dueDate);

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

    public String getActivityId() {
        return mActivityId;
    }

    public void setActivityId(String activityId) {
        mActivityId = activityId;
    }
}
