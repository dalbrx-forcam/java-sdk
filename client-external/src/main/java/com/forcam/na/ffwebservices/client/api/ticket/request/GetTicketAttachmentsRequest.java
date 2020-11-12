////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 18.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * The request object for getting ticket attachments.
 */
public class GetTicketAttachmentsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTicketId;

    private String mName;

    private Date mCreationDateFrom;

    private Date mCreationDateTo;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetTicketAttachmentsRequest} object with a ticket ID.
     *
     * @param ticketId The ticket ID.
     */
    public GetTicketAttachmentsRequest(String ticketId) {
        mTicketId = ticketId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mName", mName)
            .append("mCreationDateFrom", mCreationDateFrom)
            .append("mCreationDateTo", mCreationDateTo)
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getCreationDateFrom() {
        return mCreationDateFrom;
    }

    public void setCreationDateFrom(Date creationDate) {
        mCreationDateFrom = creationDate;
    }

    public Date getCreationDateTo() {
        return mCreationDateTo;
    }

    public void setCreationDateTo(Date creationDate) {
        mCreationDateTo = creationDate;
    }
}
