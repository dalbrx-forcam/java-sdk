////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 09.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * The basic properties of a ticket activity attachment.
 */
@ApiModel(value = "ticketActivityAttachmentProperties")
@JsonPropertyOrder({ "id", "name", "editor", "description", "creationDate", "mimeType", "size" })
public class TicketActivityAttachmentPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mId;
    private String mName;
    private String mEditor;
    private String mDescription;
    private Date mCreationDate;
    private String mMimeType;
    private Long mSize;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "", position = 1, required = true)
    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "", position = 2)
    public void setName(String name) {
        mName = name;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "", position = 3)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "", position = 4)
    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "", position = 5, required = true)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public String getMimeType() {
        return mMimeType;
    }

    @ApiModelProperty(value = "", position = 6)
    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
    }

    public Long getSize() {
        return mSize;
    }

    @ApiModelProperty(value = "", position = 7)
    public void setSize(Long size) {
        mSize = size;
    }
}
