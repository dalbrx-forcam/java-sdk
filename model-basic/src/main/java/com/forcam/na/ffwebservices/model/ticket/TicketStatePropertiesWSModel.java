////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 26.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ticketStateProperties")
@JsonPropertyOrder({ "id", "name", "color" })
public class TicketStatePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private TicketState mId;

    private String mName;

    private String mColor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public TicketState getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the ticket state", position = 0)
    public void setId(TicketState id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "Name of the ticket state", position = 1)
    public void setName(String name) {
        mName = name;
    }

    public String getColor() {
        return mColor;
    }

    @ApiModelProperty(value = "Color of the ticket state", position = 2)
    public void setColor(String color) {
        mColor = color;
    }

}
