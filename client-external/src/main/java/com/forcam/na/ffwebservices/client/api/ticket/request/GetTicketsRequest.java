////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketEmbed;
import com.forcam.na.ffwebservices.model.ticket.TicketPriority;
import com.forcam.na.ffwebservices.model.ticket.TicketState;

import java.util.Date;

/**
 * The request object for getting ticket matching a filter.
 */
public class GetTicketsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private TicketEmbed mEmbed = new TicketEmbed();

    private String mWorkplaceNumber;

    private String mWorkplaceId;

    private String mTicketTitle;

    private String mTicketNumber;

    private Date mCreationDateFrom;

    private Date mCreationDateTo;

    private String mOperationId;

    private String mMaterialNumber;

    private TicketPriority mTicketPriority;

    private TicketState mTicketStateId;

    private String mTicketClassId;

    private String mEditor;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public TicketEmbed embed() {
        return mEmbed;
    }

    public void embed(TicketEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mEmbed", mEmbed)
            .append("mWorkplaceNumber", mWorkplaceNumber)
            .append("mWorkplaceId", mWorkplaceId)
            .append("mEditor", mEditor)
            .append("mTicketTitle", mTicketTitle)
            .append("mTicketNumber", mTicketNumber)
            .append("mCreationDateFrom", mCreationDateFrom)
            .append("mCreationDateTo", mCreationDateTo)
            .append("mOperationId", mOperationId)
            .append("mMaterialNumber", mMaterialNumber)
            .append("mTicketPriority", mTicketPriority)
            .append("mTicketStateId", mTicketStateId)
            .append("mTicketClassId", mTicketClassId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
    }

    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getTicketTitle() {
        return mTicketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        mTicketTitle = ticketTitle;
    }

    public String getTicketNumber() {
        return mTicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        mTicketNumber = ticketNumber;
    }

    public Date getCreationDateFrom() {
        return mCreationDateFrom;
    }

    public void setCreationDateFrom(Date creationDateFrom) {
        mCreationDateFrom = creationDateFrom;
    }

    public Date getCreationDateTo() {
        return mCreationDateTo;
    }

    public void setCreationDateTo(Date creationDateTo) {
        mCreationDateTo = creationDateTo;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public TicketPriority getTicketPriority() {
        return mTicketPriority;
    }

    public void setTicketPriority(TicketPriority ticketPriority) {
        mTicketPriority = ticketPriority;
    }

    public TicketState getTicketStateId() {
        return mTicketStateId;
    }

    public void setTicketStateId(TicketState ticketStateId) {
        mTicketStateId = ticketStateId;
    }

    public String getTicketClassId() {
        return mTicketClassId;
    }

    public void setTicketClassId(String ticketClassId) {
        mTicketClassId = ticketClassId;
    }

    public void setEditor(String editor) {
        mEditor = editor;
    }

    public String getEditor() {
        return mEditor;
    }
}
