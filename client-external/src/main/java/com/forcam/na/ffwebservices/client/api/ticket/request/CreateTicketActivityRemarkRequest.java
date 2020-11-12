////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 12.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketActivityRemarkPropertiesWSModel;

/**
 * The request object for creating a new ticket activity remark
 */
public class CreateTicketActivityRemarkRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;
    private String mActivityId;
    private CreateTicketActivityRemarkPropertiesWSModel mTicketActivityRemarkData = new CreateTicketActivityRemarkPropertiesWSModel();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CreateTicketActivityRemarkRequest(String ticketId, String activityId, String remark) {
        mTicketId = ticketId;
        mActivityId = activityId;
        mTicketActivityRemarkData.setRemark(remark);
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
            .append("ticketActivityRemarkData", mTicketActivityRemarkData)
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

    public CreateTicketActivityRemarkPropertiesWSModel getTicketActivityRemarkData() {
        return mTicketActivityRemarkData;
    }

    public void setTicketActivityRemarkData(CreateTicketActivityRemarkPropertiesWSModel ticketActivityRemarkData) {
        mTicketActivityRemarkData = ticketActivityRemarkData;
    }
}
