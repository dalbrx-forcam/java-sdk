////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 02.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Model containing the properties to create or update a ticket activity.
 */
@ApiModel(value = "writeTicketActivityProperties")
@JsonPropertyOrder({ "title", "description", "ticketActivityStateId", "dueDate" })
public class WriteTicketActivityPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mTitle;
    private String mDescription;
    private Date mDueDate;
    private TicketActivityState mTicketActivityStateId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @NotBlank
    public String getTitle() {
        return mTitle;
    }

    @ApiModelProperty(position = 1)
    public void setTitle(String title) {
        mTitle = title;
    }

    @NotBlank
    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    @NotNull
    public TicketActivityState getTicketActivityStateId() {
        return mTicketActivityStateId;
    }

    @ApiModelProperty(position = 3)
    public void setTicketActivityStateId(TicketActivityState ticketActivityStateId) {
        mTicketActivityStateId = ticketActivityStateId;
    }

    public Date getDueDate() {
        return mDueDate;
    }

    @ApiModelProperty(position = 4)
    public void setDueDate(Date dueDate) {
        mDueDate = dueDate;
    }

}
