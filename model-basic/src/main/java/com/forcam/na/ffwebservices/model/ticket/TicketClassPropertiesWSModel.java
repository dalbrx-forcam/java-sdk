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

@ApiModel("ticketClassProperties")
@JsonPropertyOrder({ "id", "shortDescription", "description", "sequence", "code" })
public class TicketClassPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;
    private Long mSequence;
    private String mDescription;
    private String mShortDescription;
    private String mCode;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the ticket class", position = 0)
    public void setId(String id) {
        mId = id;
    }

    @ApiModelProperty(value = "Sequence number of the ticket class", position = 3)
    public void setSequence(long sequence) {
        mSequence = sequence;
    }

    public long getSequence() {
        return mSequence;
    }

    @ApiModelProperty(value = "Description of the ticket class", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "Short description of the ticket class", position = 1)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    @ApiModelProperty(value = "The code of the tickte class", position = 4)
    public void setCode(String code) {
        mCode = code;
    }

    public String getCode() {
        return mCode;
    }
}
