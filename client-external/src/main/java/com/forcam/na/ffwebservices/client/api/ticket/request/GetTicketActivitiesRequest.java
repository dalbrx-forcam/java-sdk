////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * The request object for getting ticket activities.
 */
public class GetTicketActivitiesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mTicketId;

    private String mTitle;

    private String mEditor;

    private Date mDueDateStart;

    private Date mDueDateEnd;

    private String mTicketActivityStateId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetTicketActivitiesRequest} object with a ticket ID.
     *
     * @param ticketId The ticket ID.
     */
    public GetTicketActivitiesRequest(String ticketId) {
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
            .append("mTicketId", mTicketId)
            .append("mTitle", mTitle)
            .append("mEditor", mEditor)
            .append("mDueDateStart", mDueDateStart)
            .append("mDueDateEnd", mDueDateEnd)
            .append("mTicketActivityStateId", mTicketActivityStateId)
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

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getEditor() {
        return mEditor;
    }

    public void setEditor(String editor) {
        mEditor = editor;
    }

    public Date getDueDateStart() {
        return mDueDateStart;
    }

    public void setDueDateStart(Date dueDateStart) {
        mDueDateStart = dueDateStart;
    }

    public Date getDueDateEnd() {
        return mDueDateEnd;
    }

    public void setDueDateEnd(Date dueDateEnd) {
        mDueDateEnd = dueDateEnd;
    }

    public String getTicketActivityStateId() {
        return mTicketActivityStateId;
    }

    public void setTicketActivityStateId(String ticketActivityStateId) {
        mTicketActivityStateId = ticketActivityStateId;
    }
}
