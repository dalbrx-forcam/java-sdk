////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 28.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * The basic properties of a ticket activity.
 */
@ApiModel(value = "ticketActivityProperties")
@JsonPropertyOrder({ "id", "title", "description", "editor", "ticketActivityStateId", "dueDate" })
public class TicketActivityPropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mId;
    private String mTitle;
    private String mDescription;
    private String mEditor;
    private TicketActivityState mTicketActivityStateId;
    private Date mDueDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "", position = 0, required = true)
    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    @ApiModelProperty(value = "", position = 1)
    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "", position = 3)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public TicketActivityState getTicketActivityStateId() {
        return mTicketActivityStateId;
    }

    @ApiModelProperty(value = "", position = 4)
    public void setTicketActivityStateId(TicketActivityState ticketActivityStateId) {
        mTicketActivityStateId = ticketActivityStateId;
    }

    public Date getDueDate() {
        return mDueDate;
    }

    @ApiModelProperty(value = "", position = 5)
    public void setDueDate(Date dueDate) {
        mDueDate = dueDate;
    }
}
