////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 10.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * The basic properties of a ticket activity remark.
 */
@ApiModel(value = "ticketActivityRemarkProperties")
@JsonPropertyOrder({ "id", "remark", "editor", "creationDate" })
public class TicketActivityRemarkPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mId;
    private String mRemark;
    private String mEditor;
    private Date mCreationDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "", position = 1)
    public void setId(String id) {
        mId = id;
    }

    public String getRemark() {
        return mRemark;
    }

    @ApiModelProperty(value = "", position = 2)
    public void setRemark(String remark) {
        mRemark = remark;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "", position = 3)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "", position = 4)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }
}
