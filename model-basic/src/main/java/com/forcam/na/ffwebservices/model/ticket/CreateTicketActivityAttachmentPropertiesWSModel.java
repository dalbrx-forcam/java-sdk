////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 10.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * Model containing the properties to create a ticket activity attachment.
 */
@ApiModel(value = "createTicketActivityAttachmentProperties")
@JsonPropertyOrder({ "description" })
public class CreateTicketActivityAttachmentPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mDescription;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("description", mDescription)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @NotBlank
    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "", position = 0, required = true)
    public void setDescription(String description) {
        mDescription = description;
    }
}
