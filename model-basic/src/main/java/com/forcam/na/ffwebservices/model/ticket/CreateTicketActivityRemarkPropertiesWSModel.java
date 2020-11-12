////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 12.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * Model containing the properties to create a ticket activity remark.
 */
@ApiModel(value = "createTicketActivityRemarkProperties")
@JsonPropertyOrder({ "remark", "editor" })
public class CreateTicketActivityRemarkPropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mRemark;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------
    @NotBlank
    public String getRemark() {
        return mRemark;
    }

    @ApiModelProperty(value = "", position = 1, required = true)
    public void setRemark(String remark) {
        mRemark = remark;
    }
}
